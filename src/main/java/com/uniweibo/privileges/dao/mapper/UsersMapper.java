package com.uniweibo.privileges.dao.mapper;

import com.uniweibo.privileges.pojo.Users;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsersMapper {

	public int insertUsers(Users users);

	public int updateUsers(Users users);

	public int removeUsers(Users users);

	public int removeUsers(Integer id);

	public Users getUsers(Integer id);

	public List<Users> listUsers();

	public List<Users> pagingUsers(Users users);

	public int listUsersCount();


}