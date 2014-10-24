package com.uniweibo.privileges.dao.mapper;

import com.uniweibo.privileges.pojo.UserBlock;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserBlockMapper {

	public int insertUserBlock(UserBlock userBlock);

	public int updateUserBlock(UserBlock userBlock);

	public int removeUserBlock(UserBlock userBlock);

	public int removeUserBlock(Integer id);

	public UserBlock getUserBlock(Integer id);

	public List<UserBlock> listUserBlock();

	public List<UserBlock> pagingUserBlock(UserBlock userBlock);

	public int listUserBlockCount();


}