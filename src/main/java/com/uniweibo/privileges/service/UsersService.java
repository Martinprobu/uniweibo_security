package com.uniweibo.privileges.service;

import java.util.List;

import com.uniweibo.privileges.pojo.Users;
import com.uniweibo.privileges.dao.mapper.UsersMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class UsersService {

	@Autowired
	private UsersMapper usersMapper;

	public int insertUsers(Users users) {
		return usersMapper.insertUsers(users);
	}

	public int updateUsers(Users users) {
		return usersMapper.updateUsers(users);
	}

	public int removeUsers(Users users) {
		return usersMapper.removeUsers(users);
	}

	public int removeUsersById(Integer id) {
		return usersMapper.removeUsers(id);
	}

	public Users getUsers(Integer id) {
		return usersMapper.getUsers(id);
	}

	public List<Users> listUsers() {
		return usersMapper.listUsers();
	}

	public List<Users> pagingUsers(Users users) {
		List<Users> list = usersMapper.pagingUsers(users);
		if (list.size() > 0) {
			list.get(0).setTotalCount(
				usersMapper.listUsersCount());
			list.get(0).setNumber(users.getNumber());
			list.get(0).setCurrentPage(users.getCurrentPage());
		}
		return list;
	}


}