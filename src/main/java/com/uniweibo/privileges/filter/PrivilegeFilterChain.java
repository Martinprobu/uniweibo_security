package com.uniweibo.privileges.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import redis.clients.jedis.exceptions.JedisConnectionException;

import com.uniweibo.privileges.service.redis.UserRedis;
import com.uniweibo.privileges.util.PrivilegeConstants;

/**
 * @author BillWu
 * @since 2014-10-13
 * @update 2014-10-17
 * @desc 权限模块  Filter链， 主接口
 * @version 1.0
 * 
 */
public class PrivilegeFilterChain implements Filter {

	public final String CLASS_NAME = this.getClass().getName();
	
	private static WebApplicationContext wac;
	private static UserRedis userRedis;
	
	private static IPrivilegeFilter roleResourceFilter = new RoleResourceFilter();
	private static IPrivilegeFilter userResourceFilter = new UserResourceFilter();
	private static IPrivilegeFilter userRejectResourceFilter = new UserRejectResourceFilter();
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		PrivilegeConstants.PRIVILEGE_LOGGER.debug(CLASS_NAME + ".init Begin. ");
		wac = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
		userRedis = (UserRedis) wac.getBean("userRedis",UserRedis.class);
		PrivilegeConstants.PRIVILEGE_LOGGER.debug(CLASS_NAME + ".init End. ");
	}
	
	@Override
	public void destroy() {
		PrivilegeConstants.PRIVILEGE_LOGGER.debug(CLASS_NAME + ".destroy Begin. ");
		PrivilegeConstants.PRIVILEGE_LOGGER.debug(CLASS_NAME + ".destroy End. ");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, javax.servlet.FilterChain chain) throws IOException, ServletException {
		PrivilegeConstants.PRIVILEGE_LOGGER.info(CLASS_NAME + ".doFilter Begin. ");
		//拿出session
		HttpSession session = ((HttpServletRequest)request).getSession();
		//sesison的 isLogin
		boolean isLogin = Boolean.parseBoolean((String)session.getAttribute(PrivilegeConstants.SESSION_ISLOGIN));
		isLogin = true;	//test
		//判断是否isLogin
		if (!isLogin) {
			request.getRequestDispatcher(PrivilegeConstants.PRIVILEGE_NO_URL).forward(request, response);
			return;		////////////////////////////////////////////////////////////////////////////////////////
		}
		//session的uid
		String uid = (String)session.getAttribute(PrivilegeConstants.SESSION_UID);
		uid = "11011";	//test
		if (null == uid || uid.isEmpty()) {
			request.getRequestDispatcher(PrivilegeConstants.PRIVILEGE_NO_URL).forward(request, response);
			return;		////////////////////////////////////////////////////////////////////////////////////////
		}
		//此uid 访问的url
		String url = ((HttpServletRequest)request).getServletPath();
		//url的访问类型，get post put del等
		String urlType = ((HttpServletRequest)request).getMethod().toLowerCase();
		//放在redis中的url格式如： get:/welcome
		url = "/welcome/welcome2/welcome3";//test
		url = urlType + PrivilegeConstants.URL_TYPE_SEPARATE + url;
		
		try {
			
			//拿出对应的所有角色 roleid
			List<String> roidList = userRedis.selectRoidByUid(uid);
			PrivilegeConstants.PRIVILEGE_LOGGER.debug(CLASS_NAME + ".doFilter roid: " + roidList);
			
			//拿出所有roleid对应的resources，再验证是否有
			int level1 = roleResourceFilter.doPrivilegeFilter(request, response, chain, uid, userRedis, roidList, url);
			//如果roleid对应的resource没有权限,就检验user的reousece列表
			if (level1 == PrivilegeConstants.PRIVILEGE_NO) {
				PrivilegeConstants.PRIVILEGE_LOGGER.info(CLASS_NAME + ".doFilter > roleResourceFilter.doPrivilegeFilter . level1 . PRIVILEGE_NO . ");
					//先拿出user的reousece列表，再检验user的reousece列表
					int level2 = userResourceFilter.doPrivilegeFilter(request, response, chain, uid, userRedis, url);
					//如果user也没有对应权限,就重定向到 PrivilegeConstants.PRIVILEGE_NO_URL页面
					if (level2 == PrivilegeConstants.PRIVILEGE_NO) {
						PrivilegeConstants.PRIVILEGE_LOGGER.info(CLASS_NAME + ".doFilter > userResourceFilter.doPrivilegeFilter . level2 . PRIVILEGE_NO . ");
						request.getRequestDispatcher(PrivilegeConstants.PRIVILEGE_NO_URL).forward(request, response);
						return;		////////////////////////////////////////////////////////////////////////////////////////
					}
					//如果user是有对应权限,继续向下执行
					PrivilegeConstants.PRIVILEGE_LOGGER.debug(CLASS_NAME + ".doFilter > userResourceFilter.doPrivilegeFilter End . ");
			}
			
			//判断user reject表,是否有拉黑的权限配置
			int level3 = userRejectResourceFilter.doPrivilegeFilter(request, response, chain, uid, userRedis, url);
			//如果user reject resource是有对应的'url'的，表示 此url权限被拉黑了，果断重定向到 PrivilegeConstants.PRIVILEGE_NO_URL页面
			if (level3 == PrivilegeConstants.PRIVILEGE_YES) {
				PrivilegeConstants.PRIVILEGE_LOGGER.info(CLASS_NAME + ".doFilter > userResourceFilter.doPrivilegeFilter . level3 . PRIVILEGE_YES . ");
				request.getRequestDispatcher(PrivilegeConstants.PRIVILEGE_NO_URL).forward(request, response);
				return;		////////////////////////////////////////////////////////////////////////////////////////
			}
		
		} catch (RedisConnectionFailureException redisConnectionFailureE) {
			//如果redis挂了，切换到MySQL, 目前 是在Redis层面做高可用 . 在这里暂时不用切换到MySQL
			request.getRequestDispatcher(PrivilegeConstants.PRIVILEGE_REDIS_ERROR_URL).forward(request, response);
			PrivilegeConstants.PRIVILEGE_LOGGER.info(CLASS_NAME + ".doFilter isRedisConnected NO . Redis挂了.  快救火 . ");
		} catch (JedisConnectionException jedisConnectionE) {
			request.getRequestDispatcher(PrivilegeConstants.PRIVILEGE_REDIS_ERROR_URL).forward(request, response);
			PrivilegeConstants.PRIVILEGE_LOGGER.info(CLASS_NAME + ".doFilter isRedisConnected NO . Redis挂了.  快救火 . ");
		}
		
		//上面的都通过的话，可以放行，从Filter链把权限交给下一个Filter
		chain.doFilter(request, response);
		
		PrivilegeConstants.PRIVILEGE_LOGGER.info(CLASS_NAME + ".doFilter End. ");
	}


}
