package com.uniweibo.privileges.pojo;

/**
 * @author BillWu
 * @since 2014-10-15
 * @update 2014-10-15
 * @desc POJO base类,参考uniweibo别的系统的
 * @version 1.0
 * 
 */
public class BasePojo  {
	

	private int currentPage = 1;
	private int number = 25;
	
	private int totalCount;
	private int totalPage;
	
	private int offset;
	
	private String orderby;
	private int desc = 0;

	public BasePojo(){}

	public Integer getCurrentPage() {
		return currentPage;
	}
	/**
	 * Set property number <b>before</b> set property currentPage
	 * @param currentPage
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
		this.offset = (this.currentPage-1)*this.number;
	}

	public Integer getNumber() {
		return number;
	}
	
	/**
	 * Set property number before set property currentPage
	 * @param number
	 */
	public void setNumber(Integer number) {
		this.number = number;
		this.offset = (this.currentPage-1)*this.number;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPage() {
		return this.totalCount%this.number==0?this.totalCount/this.number:this.totalCount/this.number+1;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	public int getDesc() {
		return desc;
	}

	public void setDesc(int desc) {
		this.desc = desc;
	}
	
}
