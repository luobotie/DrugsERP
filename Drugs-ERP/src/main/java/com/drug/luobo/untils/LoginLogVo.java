package com.drug.luobo.untils;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.drug.luobo.entity.LoginLog;

public class LoginLogVo extends LoginLog{
	/**
	 * 分页参数
	 */
	private Integer page;
	private Integer limit;
	
	/**
	 * 时间
	 */
	private String startTime;
	private String  endTime;
	
	
	//接收多个id
	private Integer [] ids;
	
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
}
