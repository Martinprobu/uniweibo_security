package com.uniweibo.privileges.service;

import java.util.List;

import com.uniweibo.privileges.pojo.RoleResource;
import com.uniweibo.privileges.dao.mapper.RoleResourceMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class RoleResourceService {

	@Autowired
	private RoleResourceMapper roleResourceMapper;

	public int insertRoleResource(RoleResource roleResource) {
		return roleResourceMapper.insertRoleResource(roleResource);
	}

	public int updateRoleResource(RoleResource roleResource) {
		return roleResourceMapper.updateRoleResource(roleResource);
	}

	public int removeRoleResource(RoleResource roleResource) {
		return roleResourceMapper.removeRoleResource(roleResource);
	}

	public int removeRoleResourceById(Integer id) {
		return roleResourceMapper.removeRoleResource(id);
	}

	public RoleResource getRoleResource(Integer id) {
		return roleResourceMapper.getRoleResource(id);
	}

	public List<RoleResource> listRoleResource() {
		return roleResourceMapper.listRoleResource();
	}

	public List<RoleResource> pagingRoleResource(RoleResource roleResource) {
		List<RoleResource> list = roleResourceMapper.pagingRoleResource(roleResource);
		if (list.size() > 0) {
			list.get(0).setTotalCount(
				roleResourceMapper.listRoleResourceCount());
			list.get(0).setNumber(roleResource.getNumber());
			list.get(0).setCurrentPage(roleResource.getCurrentPage());
		}
		return list;
	}


}