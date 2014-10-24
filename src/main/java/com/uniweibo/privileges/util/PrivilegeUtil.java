package com.uniweibo.privileges.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author BillWu
 * @since 2014-10-12
 * @update 2014-10-17
 * @desc 权限模块  Filter权限过滤 工具类
 * @version 1.0
 * 
 */
public class PrivilegeUtil {

	/**
	 * @author BillWu
	 * @since 2014-10-15
	 * @update 2014-10-15
	 * @desc 检查这个resourceSet 里是否存在对应的(url权限)
	 * @param String url[当前访问url],Set<String> resourceSet[当前uid对应的resource url]
	 * @return boolean true[有权限], false[没有权限]
	 */
	public static boolean checkPrivileges4UrlSet(String url, Set<String> resourceSet) {
		PrivilegeConstants.PRIVILEGE_LOGGER.debug("PrivilegeUtil.checkPrivileges4UrlSet . ");
		//如果能表面找到对应的url,说明有此url访问权限，放行
		if (resourceSet.contains(url)) {
			PrivilegeConstants.PRIVILEGE_LOGGER.debug("PrivilegeUtil.checkPrivileges4UrlSet . true . ");
			return true;
		} else {
			//如果表面不能找到对应的url,需要以'/'为分融符 分解 成N段 来对比
			if (checkPrivileges2IteratUrl2(url, resourceSet)) {
				return true;
			}
		}
		PrivilegeConstants.PRIVILEGE_LOGGER.debug("PrivilegeUtil.checkPrivileges4UrlSet . false . ");
		return false;
	}

	/**
	 * @author BillWu
	 * @since 2014-10-15
	 * @update 2014-10-15
	 * @desc 如果表面不能找到对应的url,并不能说明没有权限，需要每条迭代 判断是否带有*号.  若带有*号，需要在*号的前后两段判断，可用正则表达式匹配 (Spring MVC的url有时会带有*)
	 * @param String url[当前访问url], Set<String> resourceSet[当前uid对应的resource url]
	 * @return boolean true [有权限], false[没有权限] 
	 * @deprecated [此贷效率低下，out了]
	 */
	public static boolean checkPrivileges2IteratUrl(String url, Set<String> resourceSet) {
		PrivilegeConstants.PRIVILEGE_LOGGER.debug("PrivilegeUtil.checkPrivileges2IteratUrl . ");
		Iterator<String> ita = resourceSet.iterator();
		while (ita.hasNext()) {
			String setUrl = ita.next();
			//匹配带'*'号的 正则表达式, 这里表示 ，中间只包含一个*  
			if (PrivilegeConstants.PATTERN_STAR.matcher(setUrl).matches()) {
				//把此贷从*号 切分成两段
				String[] setUrlList = setUrl.split("*");
				//分别判断*号的前后两段
				if (url.startsWith(setUrlList[0]) && url.endsWith(setUrlList[1])) {
					PrivilegeConstants.PRIVILEGE_LOGGER.debug("PrivilegeUtil.checkPrivileges2IteratUrl . true . ");
					return true;
				}
			}
		}
		PrivilegeConstants.PRIVILEGE_LOGGER.debug("PrivilegeUtil.checkPrivileges2IteratUrl . false . ");
		return false;
	}
	
	/**
	 * @author BillWu
	 * @since 2014-10-17
	 * @update 2014-10-17
	 * @desc 如果表面不能找到对应的url,并不能说明没有权限，需要以'/'为分融符 分解 成N段 来对比(如：/aa/*), [Spring MVC,Spring Resful的url有时会带有*]
	 * @param String url[当前访问url], Set<String> resourceSet[当前uid对应的resource url]
	 * @return boolean true [有权限], false[没有权限] 
	 */
	public static boolean checkPrivileges2IteratUrl2(String url, Set<String> resourceSet) {
		PrivilegeConstants.PRIVILEGE_LOGGER.debug("PrivilegeUtil.checkPrivileges2IteratUrl . ");
		//以'/'分隔的当前url的 String数组
		String[] urlList = url.split("/");
		//以'/'为分隔符，把当前url 暴力分解出N个String
		Set<String> seperaUrlSet = separateUrl4Star(urlList);
		//迭代的判断此贷
		Iterator<String> urlSetItera = seperaUrlSet.iterator();
		while (urlSetItera.hasNext()) {
			if (resourceSet.contains(urlSetItera.next())) {
				PrivilegeConstants.PRIVILEGE_LOGGER.debug("PrivilegeUtil.checkPrivileges2IteratUrl2 . true . ");
				return true;
			}
		}
		PrivilegeConstants.PRIVILEGE_LOGGER.debug("PrivilegeUtil.checkPrivileges2IteratUrl2 . false . ");
		return false;
	}

	/**
	 * @author BillWu
	 * @since 2014-10-17
	 * @update 2014-10-17
	 * @desc 以'/'为分隔符，把当前url分解出N个String,组成一个Set<String>(由于个数不会多，所以不用考虑优先顺序的性能), 
	 * @param String[] urlList[以'/'分隔的当前url的 String数组]
	 * @return Set<String>[分解的String，组成一个Set]
	 */
	public static Set<String> separateUrl4Star(String[] urlList) {
		PrivilegeConstants.PRIVILEGE_LOGGER.debug("PrivilegeUtil.separateUrl4Star . ");
		//两次冒泡,如： get:/aa/bb/cc/dd 分解成 [get:/aa/*/cc/dd], [get:/aa/*/*/dd], [get:/aa/*/*/*], [get:/aa/bb/*/dd], [get:/aa/bb/*/*], [get:/aa/bb/cc/*]
		//要返回的Set
		Set<String> outSet = new HashSet<String>();
		//影子变量
		String[] urlListCache;
		//因为数组第一位是 'get:', 第二位，都可以忽略, 所以迭代index从1开始
		for (int i = 1; i < urlList.length; i++) {
			urlListCache = Arrays.copyOf(urlList, urlList.length);
			for (int j = i+1; j < urlList.length; j++) {
				urlListCache[j] = "*";
				//影子数组合并成一条字符串，并以/分隔
				String aaListStr = array2String(urlListCache);
				outSet.add(aaListStr);
			}
		}
		PrivilegeConstants.PRIVILEGE_LOGGER.debug("PrivilegeUtil.separateUrl4Star . outSet . " + outSet);
		return outSet;
	}
	
	/**
	 * @author BillWu
	 * @since 2014-10-17
	 * @update 2014-10-17
	 * @desc 数组合并成一条字符串，并以/分隔
	 * @param String[] inArr
	 * @return String
	 */
	public static String array2String(String[] inArr) {
		String aaListStr = Arrays.toString(inArr);
	    return aaListStr.substring(1, aaListStr.length()-1).replaceAll(",", "/").replaceAll(" ", "");
	}
	
	
}
