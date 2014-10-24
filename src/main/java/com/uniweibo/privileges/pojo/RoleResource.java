package com.uniweibo.privileges.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class RoleResource extends BasePojo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer roId;
	private Integer reId;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Integer isDeleted;

	public RoleResource(){}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this. id = id;
	}
	public Integer getRoId() {
		return roId;
	}
	public void setRoId(Integer roId) {
		this. roId = roId;
	}
	public Integer getReId() {
		return reId;
	}
	public void setReId(Integer reId) {
		this. reId = reId;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this. createTime = createTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this. updateTime = updateTime;
	}
	public Integer getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Integer isDeleted) {
		this. isDeleted = isDeleted;
	}

}