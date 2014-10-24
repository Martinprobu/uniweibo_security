package com.uniweibo.privileges.service;

import java.util.List;

import com.uniweibo.privileges.pojo.UserResource;
import com.uniweibo.privileges.dao.mapper.UserResourceMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class UserResourceService {

	@Autowired
	private UserResourceMapper userResourceMapper;

	public int insertUserResource(UserResource userResource) {
		return userResourceMapper.insertUserResource(userResource);
	}

	public int updateUserResource(UserResource userResource) {
		return userResourceMapper.updateUserResource(userResource);
	}

	public int removeUserResource(UserResource userResource) {
		return userResourceMapper.removeUserResource(userResource);
	}

	public int removeUserResourceById(Integer id) {
		return userResourceMapper.removeUserResource(id);
	}

	public UserResource getUserResource(Integer id) {
		return userResourceMapper.getUserResource(id);
	}

	public List<UserResource> listUserResource() {
		return userResourceMapper.listUserResource();
	}

	public List<UserResource> pagingUserResource(UserResource userResource) {
		List<UserResource> list = userResourceMapper.pagingUserResource(userResource);
		if (list.size() > 0) {
			list.get(0).setTotalCount(
				userResourceMapper.listUserResourceCount());
			list.get(0).setNumber(userResource.getNumber());
			list.get(0).setCurrentPage(userResource.getCurrentPage());
		}
		return list;
	}


}