package com.drug.dml.entity;

import org.springframework.stereotype.Component;

@Component
public class DrugsMonthPlan {
	  private int monthPlanId;      		// 生产月计划编号(主键)
	  private int monthPlanNum;             // 月计划生产总数量
	  private String monthCompleteTime;     // 月计划完成时间(制定订单的人选择完成时间)
	  private String monthApplicationTime;  // 月计划申请时间(何时产生订单就是何时)
	  private int employeeId;     			// 申请发起人编号(外键 表：drugs_employee 主键：employeeId) REFERENCES drugs_employee(employeeId)
	  private String reviewDate;      		// 月计划审核时间
	  private String reviewStatus;  		// 月计划审核状态(审核/未审核)
	  private int empId ;					//审核人编号(外键 表：drugs_employee 主键：employeeId) REFERENCES drugs_employee(employeeId)
	public int getMonthPlanId() {
		return monthPlanId;
	}
	public void setMonthPlanId(int monthPlanId) {
		this.monthPlanId = monthPlanId;
	}
	public int getMonthPlanNum() {
		return monthPlanNum;
	}
	public void setMonthPlanNum(int monthPlanNum) {
		this.monthPlanNum = monthPlanNum;
	}
	public String getMonthCompleteTime() {
		return monthCompleteTime;
	}
	public void setMonthCompleteTime(String monthCompleteTime) {
		this.monthCompleteTime = monthCompleteTime;
	}
	public String getMonthApplicationTime() {
		return monthApplicationTime;
	}
	public void setMonthApplicationTime(String monthApplicationTime) {
		this.monthApplicationTime = monthApplicationTime;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	public String getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public DrugsMonthPlan(int monthPlanId, int monthPlanNum, String monthCompleteTime, String monthApplicationTime,
			int employeeId, String reviewDate, String reviewStatus, int empId) {
		super();
		this.monthPlanId = monthPlanId;
		this.monthPlanNum = monthPlanNum;
		this.monthCompleteTime = monthCompleteTime;
		this.monthApplicationTime = monthApplicationTime;
		this.employeeId = employeeId;
		this.reviewDate = reviewDate;
		this.reviewStatus = reviewStatus;
		this.empId = empId;
	}
	public DrugsMonthPlan() {
		super();
	}
	  
}
