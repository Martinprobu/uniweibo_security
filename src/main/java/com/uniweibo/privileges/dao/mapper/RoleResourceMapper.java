package com.uniweibo.privileges.dao.mapper;

import com.uniweibo.privileges.pojo.RoleResource;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleResourceMapper {

	public int insertRoleResource(RoleResource roleResource);

	public int updateRoleResource(RoleResource roleResource);

	public int removeRoleResource(RoleResource roleResource);

	public int removeRoleResource(Integer id);

	public RoleResource getRoleResource(Integer id);

	public List<RoleResource> listRoleResource();

	public List<RoleResource> pagingRoleResource(RoleResource roleResource);

	public int listRoleResourceCount();


}