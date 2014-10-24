package com.uniweibo.privileges.dao.mapper;

import com.uniweibo.privileges.pojo.Roles;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolesMapper {

	public int insertRoles(Roles roles);

	public int updateRoles(Roles roles);

	public int removeRoles(Roles roles);

	public int removeRoles(Integer id);

	public Roles getRoles(Integer id);

	public List<Roles> listRoles();

	public List<Roles> pagingRoles(Roles roles);

	public int listRolesCount();


}