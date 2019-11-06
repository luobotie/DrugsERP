package com.drug.shw.entity;

import org.springframework.stereotype.Component;

@Component
public class Dailyplan {
private Integer dailyPlanid;
private Integer planId;
private Integer productionQuantity;
private Integer  daypracticalQuantity;
private String auditingDate;
private String auditingStatue;
private String auditorName;
private String productDate;
private String dailyplanDes;
public Integer getDailyPlanid() {
	return dailyPlanid;
}
public void setDailyPlanid(Integer dailyPlanid) {
	this.dailyPlanid = dailyPlanid;
}
public Integer getPlanId() {
	return planId;
}
public void setPlanId(Integer planId) {
	this.planId = planId;
}
public Integer getProductionQuantity() {
	return productionQuantity;
}
public void setProductionQuantity(Integer productionQuantity) {
	this.productionQuantity = productionQuantity;
}
public Integer getDaypracticalQuantity() {
	return daypracticalQuantity;
}
public void setDaypracticalQuantity(Integer daypracticalQuantity) {
	this.daypracticalQuantity = daypracticalQuantity;
}
public String getAuditingDate() {
	return auditingDate;
}
public void setAuditingDate(String auditingDate) {
	this.auditingDate = auditingDate;
}
public String getAuditingStatue() {
	return auditingStatue;
}
public void setAuditingStatue(String auditingStatue) {
	this.auditingStatue = auditingStatue;
}
public String getAuditorName() {
	return auditorName;
}
public void setAuditorName(String auditorName) {
	this.auditorName = auditorName;
}
public String getProductDate() {
	return productDate;
}
public void setProductDate(String productDate) {
	this.productDate = productDate;
}
public String getDailyplanDes() {
	return dailyplanDes;
}
public void setDailyplanDes(String dailyplanDes) {
	this.dailyplanDes = dailyplanDes;
}
public Dailyplan(Integer dailyPlanid, Integer planId, Integer productionQuantity, Integer daypracticalQuantity,
		String auditingDate, String auditingStatue, String auditorName, String productDate, String dailyplanDes) {
	super();
	this.dailyPlanid = dailyPlanid;
	this.planId = planId;
	this.productionQuantity = productionQuantity;
	this.daypracticalQuantity = daypracticalQuantity;
	this.auditingDate = auditingDate;
	this.auditingStatue = auditingStatue;
	this.auditorName = auditorName;
	this.productDate = productDate;
	this.dailyplanDes = dailyplanDes;
}
public Dailyplan() {
	super();
}

}
