package com.uniweibo.privileges.filter;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uniweibo.privileges.service.redis.UserRedis;
import com.uniweibo.privileges.util.PrivilegeConstants;
import com.uniweibo.privileges.util.PrivilegeUtil;

/**
 * @author BillWu
 * @since 2014-10-16
 * @update 2014-10-16
 * @desc 检查roleid对应的resources 是否有权限的 伪filter
 * @version 1.0
 * 
 */
public class RoleResourceFilter implements IPrivilegeFilter {

	public final String CLASS_NAME = this.getClass().getName();
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	}

	/**
	 * @author BillWu
	 * @since 2014-10-16
	 * @update 2014-10-16
	 * @desc  检查roleid对应的resources 是否有权限 doPrivilegeFilter入口 
	 * @version 1.0
	 * @param Object ... privilegeObjects [uid(userid), userRedis(userRedis的Spring Service组件), roidList(roleid组成的set), url(此次访问的url)]
	 * @return int [Constants.PRIVILEGE_YES(801):成功，表示找到对应的权限; Constants.PRIVILEGE_NO(802):失败，表示没有找到对应的权限;]
	 */
	@Override
	public int doPrivilegeFilter(ServletRequest request, ServletResponse response, FilterChain chain, Object... privilegeObjects) throws IOException, ServletException {
		PrivilegeConstants.PRIVILEGE_LOGGER.debug(CLASS_NAME + ".doPrivilegeFilter(object... ) . ");
		String uid = (String)privilegeObjects[0];
		UserRedis userRedis = (UserRedis)privilegeObjects[1];
		List<String> roidList = (List<String>)privilegeObjects[2];
		String url = (String)privilegeObjects[3];
		//根据roleList 查出对应的资源列表
		Set<String> resourceSet = userRedis.selectResourceByRoidList(roidList);
		//检查这个resourceSet 里是否存在对应的"url权限"
		if (PrivilegeUtil.checkPrivileges4UrlSet(url, resourceSet)) {
			PrivilegeConstants.PRIVILEGE_LOGGER.info(CLASS_NAME + ".doPrivilegeFilter(object... ) . PRIVILEGE_YES . ");
			return PrivilegeConstants.PRIVILEGE_YES;
		}
		PrivilegeConstants.PRIVILEGE_LOGGER.info(CLASS_NAME + ".doPrivilegeFilter(object... ) . PRIVILEGE_NO . ");
		return PrivilegeConstants.PRIVILEGE_NO;
	}

}
