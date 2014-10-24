package com.uniweibo.privileges.service;

import java.util.List;

import com.uniweibo.privileges.pojo.UserRole;
import com.uniweibo.privileges.dao.mapper.UserRoleMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class UserRoleService {

	@Autowired
	private UserRoleMapper userRoleMapper;

	public int insertUserRole(UserRole userRole) {
		return userRoleMapper.insertUserRole(userRole);
	}

	public int updateUserRole(UserRole userRole) {
		return userRoleMapper.updateUserRole(userRole);
	}

	public int removeUserRole(UserRole userRole) {
		return userRoleMapper.removeUserRole(userRole);
	}

	public int removeUserRoleById(Integer id) {
		return userRoleMapper.removeUserRole(id);
	}

	public UserRole getUserRole(Integer id) {
		return userRoleMapper.getUserRole(id);
	}

	public List<UserRole> listUserRole() {
		return userRoleMapper.listUserRole();
	}

	public List<UserRole> pagingUserRole(UserRole userRole) {
		List<UserRole> list = userRoleMapper.pagingUserRole(userRole);
		if (list.size() > 0) {
			list.get(0).setTotalCount(
				userRoleMapper.listUserRoleCount());
			list.get(0).setNumber(userRole.getNumber());
			list.get(0).setCurrentPage(userRole.getCurrentPage());
		}
		return list;
	}


}