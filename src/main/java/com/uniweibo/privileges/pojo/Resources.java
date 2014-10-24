package com.uniweibo.privileges.pojo;

import java.io.Serializable;
import java.sql.Timestamp;


public class Resources extends BasePojo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer reId;
	private String url;
	private String name;
	private String type;
	private String detail;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Integer isDeleted;

	public Resources(){}

	public Integer getReId() {
		return reId;
	}
	public void setReId(Integer reId) {
		this. reId = reId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this. url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this. name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this. type = type;
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