package com.uniweibo.privileges.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class Users extends BasePojo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer uId;
	private String name;
	private String password;
	private String detail;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Integer isDeleted;

	public Users(){}

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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this. name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this. password = password;
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