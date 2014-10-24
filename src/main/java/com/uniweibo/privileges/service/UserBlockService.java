package com.uniweibo.privileges.service;

import java.util.List;

import com.uniweibo.privileges.pojo.UserBlock;
import com.uniweibo.privileges.dao.mapper.UserBlockMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class UserBlockService {

	@Autowired
	private UserBlockMapper userBlockMapper;

	public int insertUserBlock(UserBlock userBlock) {
		return userBlockMapper.insertUserBlock(userBlock);
	}

	public int updateUserBlock(UserBlock userBlock) {
		return userBlockMapper.updateUserBlock(userBlock);
	}

	public int removeUserBlock(UserBlock userBlock) {
		return userBlockMapper.removeUserBlock(userBlock);
	}

	public int removeUserBlockById(Integer id) {
		return userBlockMapper.removeUserBlock(id);
	}

	public UserBlock getUserBlock(Integer id) {
		return userBlockMapper.getUserBlock(id);
	}

	public List<UserBlock> listUserBlock() {
		return userBlockMapper.listUserBlock();
	}

	public List<UserBlock> pagingUserBlock(UserBlock userBlock) {
		List<UserBlock> list = userBlockMapper.pagingUserBlock(userBlock);
		if (list.size() > 0) {
			list.get(0).setTotalCount(
				userBlockMapper.listUserBlockCount());
			list.get(0).setNumber(userBlock.getNumber());
			list.get(0).setCurrentPage(userBlock.getCurrentPage());
		}
		return list;
	}


}