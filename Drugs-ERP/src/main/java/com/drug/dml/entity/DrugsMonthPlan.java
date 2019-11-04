package com.drug.dml.entity;

import org.springframework.stereotype.Component;
/**
 * 月计划实体类
 * @author dml
 */
@Component
public class DrugsMonthPlan {
	private Integer monthPlanId;      		// 生产月计划编号(主键)
	private Integer monthPlanNum;             // 月计划生产总数量
	private Integer monthPlanRealNum;         // 月计划实际生产总数量
	private String monthStartTime;     	// 月计划开始时间(制定订单的人选择开始时间)
	private String monthCompleteTime;     // 月计划完成时间(制定订单的人选择完成时间)
	private String monthApplicationTime;  // 月计划申请时间(何时产生订单就是何时)
	private Integer employeeId;     			// 申请发起人编号(外键 表：drugs_employee 主键：employeeId) REFERENCES drugs_employee(employeeId)
	private String reviewDate;      		// 月计划审核时间
	private String reviewStatus;  		// 月计划审核状态(审核/未审核)
	private Integer visibles;					// 显示状态
	private String proState;  			// 月计划生产状态(已生产/未生产)
	private Integer empId ;					//审核人编号(外键 表：drugs_employee 主键：employeeId) REFERENCES drugs_employee(employeeId)
	public Integer getMonthPlanId() {
		return monthPlanId;
	}
	public void setMonthPlanId(Integer monthPlanId) {
		this.monthPlanId = monthPlanId;
	}
	public Integer getMonthPlanNum() {
		return monthPlanNum;
	}
	public void setMonthPlanNum(Integer monthPlanNum) {
		this.monthPlanNum = monthPlanNum;
	}
	public Integer getMonthPlanRealNum() {
		return monthPlanRealNum;
	}
	public void setMonthPlanRealNum(Integer monthPlanRealNum) {
		this.monthPlanRealNum = monthPlanRealNum;
	}
	public String getMonthStartTime() {
		return monthStartTime;
	}
	public void setMonthStartTime(String monthStartTime) {
		this.monthStartTime = monthStartTime;
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
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
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
	public Integer getVisibles() {
		return visibles;
	}
	public void setVisibles(Integer visibles) {
		this.visibles = visibles;
	}
	public String getProState() {
		return proState;
	}
	public void setProState(String proState) {
		this.proState = proState;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public DrugsMonthPlan() {
		super();
	}
	
}
