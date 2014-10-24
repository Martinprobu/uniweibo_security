package com.uniweibo.privileges.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author BillWu
 * @since 2014-10-16
 * @update 2014-10-16
 * @desc 权限模块  Filter接口,不算是一个Filter,没有用到Filter的功能.(ServletRequest request, ServletResponse response, FilterChain chain)[这三个参数暂时也没用到]，
 * @version 1.0
 * 
 */
public interface IPrivilegeFilter extends Filter {
	/**
	 * @author BillWu
	 * @since 2014-10-16
	 * @update 2014-10-16
	 * @desc  代替dofilter方法
	 * @version 1.0
	 * @param Object ... privilegeObjects [若干个参数]
	 * @return int [Constants.PRIVILEGE_YES(801):成功，表示找到对应的权限; Constants.PRIVILEGE_NO(802):失败，表示没有找到对应的权限;]
	 */
	public int doPrivilegeFilter(ServletRequest request, ServletResponse response, FilterChain chain, Object ... privilegeObjects) throws IOException, ServletException ;
}
