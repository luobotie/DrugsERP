package com.drug.luobo.untils;

import com.drug.luobo.entity.Employee;

public class EmployeeVo extends Employee {
     private Integer page;
     private Integer limit;
     private String  depName;
     private String  rolename;
     private String  startTime;
     private String  endTime;
     private String  restPwd;
     private String  oldPwd;
     private String  newPwd;
     
     
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public String getOldPwd() {
		return oldPwd;
	}
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}
	public String getRestPwd() {
		return restPwd;
	}
	public void setRestPwd(String restPwd) {
		this.restPwd = restPwd;
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
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
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
     
}
