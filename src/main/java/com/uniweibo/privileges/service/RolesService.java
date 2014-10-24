package com.uniweibo.privileges.service;

import java.util.List;

import com.uniweibo.privileges.pojo.Roles;
import com.uniweibo.privileges.dao.mapper.RolesMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class RolesService {

	@Autowired
	private RolesMapper rolesMapper;

	public int insertRoles(Roles roles) {
		return rolesMapper.insertRoles(roles);
	}

	public int updateRoles(Roles roles) {
		return rolesMapper.updateRoles(roles);
	}

	public int removeRoles(Roles roles) {
		return rolesMapper.removeRoles(roles);
	}

	public int removeRolesById(Integer id) {
		return rolesMapper.removeRoles(id);
	}

	public Roles getRoles(Integer id) {
		return rolesMapper.getRoles(id);
	}

	public List<Roles> listRoles() {
		return rolesMapper.listRoles();
	}

	public List<Roles> pagingRoles(Roles roles) {
		List<Roles> list = rolesMapper.pagingRoles(roles);
		if (list.size() > 0) {
			list.get(0).setTotalCount(
				rolesMapper.listRolesCount());
			list.get(0).setNumber(roles.getNumber());
			list.get(0).setCurrentPage(roles.getCurrentPage());
		}
		return list;
	}


}