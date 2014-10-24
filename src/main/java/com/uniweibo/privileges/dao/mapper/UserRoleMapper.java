package com.uniweibo.privileges.dao.mapper;

import com.uniweibo.privileges.pojo.UserRole;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {

	public int insertUserRole(UserRole userRole);

	public int updateUserRole(UserRole userRole);

	public int removeUserRole(UserRole userRole);

	public int removeUserRole(Integer id);

	public UserRole getUserRole(Integer id);

	public List<UserRole> listUserRole();

	public List<UserRole> pagingUserRole(UserRole userRole);

	public int listUserRoleCount();


}