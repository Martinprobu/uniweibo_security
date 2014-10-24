package com.uniweibo.privileges.dao.mapper;

import com.uniweibo.privileges.pojo.UserResource;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserResourceMapper {

	public int insertUserResource(UserResource userResource);

	public int updateUserResource(UserResource userResource);

	public int removeUserResource(UserResource userResource);

	public int removeUserResource(Integer id);

	public UserResource getUserResource(Integer id);

	public List<UserResource> listUserResource();

	public List<UserResource> pagingUserResource(UserResource userResource);

	public int listUserResourceCount();


}