package com.uniweibo.privileges.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uniweibo.privileges.pojo.Users;
import com.uniweibo.privileges.service.UsersService;
import com.uniweibo.privileges.service.redis.UserRedis;
import com.uniweibo.privileges.util.PrivilegeConstants;

/**
 * @author BillWu
 * @since 2014-10-12
 * @update 2014-10-12
 * @desc 权限模块  Spring MVC 测试类
 * @version 2.0
 * 
 */
@Controller
@RequestMapping("/welcome")
public class TestController {
	
	public final String CLASS_NAME = this.getClass().getName();
	
	@Autowired
	private UserRedis userRedis;
	
	/**
	 * @author BillWu
	 * @since 2014-10-13
	 * @update 2014-10-13
	 * @desc 测试method
	 * @param model model
	 * @return String page
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String printW(ModelMap model) {
//		String str = userRedis.getTest("dfd");
//		Users users = useraService.getUsers(11011);
//		PrivilegeConstants.PRIVILEGE_LOGGER.debug(CLASS_NAME + ".users .======================  " + users.getName());
		model.addAttribute("message","test model bill");
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy年MM月dd日");
		model.addAttribute("date", dateformat.format(new Date()));
		return "hello";
	}
	
}
