package com.uniweibo.privileges.service;

import java.util.List;

import com.uniweibo.privileges.pojo.Resources;
import com.uniweibo.privileges.dao.mapper.ResourcesMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class ResourcesService {

	@Autowired
	private ResourcesMapper resourcesMapper;

	public int insertResources(Resources resources) {
		return resourcesMapper.insertResources(resources);
	}

	public int updateResources(Resources resources) {
		return resourcesMapper.updateResources(resources);
	}

	public int removeResources(Resources resources) {
		return resourcesMapper.removeResources(resources);
	}

	public int removeResourcesById(Integer id) {
		return resourcesMapper.removeResources(id);
	}

	public Resources getResources(Integer id) {
		return resourcesMapper.getResources(id);
	}

	public List<Resources> listResources() {
		return resourcesMapper.listResources();
	}

	public List<Resources> pagingResources(Resources resources) {
		List<Resources> list = resourcesMapper.pagingResources(resources);
		if (list.size() > 0) {
			list.get(0).setTotalCount(
				resourcesMapper.listResourcesCount());
			list.get(0).setNumber(resources.getNumber());
			list.get(0).setCurrentPage(resources.getCurrentPage());
		}
		return list;
	}


}