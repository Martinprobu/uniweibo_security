package com.uniweibo.privileges.dao.mapper;

import com.uniweibo.privileges.pojo.Resources;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourcesMapper {

	public int insertResources(Resources resources);

	public int updateResources(Resources resources);

	public int removeResources(Resources resources);

	public int removeResources(Integer id);

	public Resources getResources(Integer id);

	public List<Resources> listResources();

	public List<Resources> pagingResources(Resources resources);

	public int listResourcesCount();


}