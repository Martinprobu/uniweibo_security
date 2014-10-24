package com.uniweibo.privileges.util;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author BillWu
 * @since 2014-10-13
 * @update 2014-10-13
 * @desc 权限模块  final stati fields
 * @version 1.0
 * 
 */
public interface PrivilegeConstants {

	//session中 useid的定义
	public static final String SESSION_UID = "u_id";
	//session中islogin的定义
	public static final String SESSION_ISLOGIN = "is_login";
	
	//redis的key中 use role 的缩写
	public static final String REDIS_USER_ROLE = "uro:";
	//redis的key中 role resource的缩写
	public static final String REDIS_ROLE_RESOURCE = "rore:";
	//redis的key中 user resource的缩写
	public static final String REDIS_USER_RESOURCE = "ure:";
	//redis的key中 user reject resource的缩写
	public static final String REDIS_USER_REJECT_RESOURCE = "ubl:";
	//放到redis中的 当前url与当前访问方式(get/post/del..) 的拆分符号
	public static final String URL_TYPE_SEPARATE = ":"; 

	//有权限或成功 (纯个人定义, 801是楼主大学时的宿舍)
	public static final int PRIVILEGE_YES = 801;
	//没有权限或失败 (纯个人定义, 802是楼主大学时的隔壁宿舍)
	public static final int PRIVILEGE_NO = 802;
	
	//没有权限返回url,一般的主页
	public static final String PRIVILEGE_NO_URL = "/index.jsp";
	//Redis挂了的页面
	public static final String PRIVILEGE_REDIS_ERROR_URL = "/redis_error.jsp";
	
	//@depected 匹配带'*'号的 正则表达式, 这里表示 ，中间只包含一个*
	public static final Pattern PATTERN_STAR = Pattern.compile("\\w*\\*\\w*");
	
	//global Logger Name
	public static final String PRIVILEGE_LOGGER_NAME = "com.uniweibo.privileges.util.FilterChain";
	//global Logger
	public static final Logger PRIVILEGE_LOGGER = LoggerFactory.getLogger(PRIVILEGE_LOGGER_NAME);
	
	
}
