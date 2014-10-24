package com.uniweibo.privileges.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserResource extends BasePojo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer uId;
	private Integer reId;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Integer isDeleted;

	public UserResource(){}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this. id = id;
	}
	public Integer getUId() {
		return uId;
	}
	public void setUId(Integer uId) {
		this. uId = uId;
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