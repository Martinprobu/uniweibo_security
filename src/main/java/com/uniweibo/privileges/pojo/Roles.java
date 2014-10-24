package com.uniweibo.privileges.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class Roles extends BasePojo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer roId;
	private String name;
	private String detail;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Integer isDeleted;

	public Roles(){}

	public Integer getRoId() {
		return roId;
	}
	public void setRoId(Integer roId) {
		this. roId = roId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this. name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this. detail = detail;
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