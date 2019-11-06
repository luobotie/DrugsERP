package com.drug.shw.entity;

import org.springframework.stereotype.Component;

@Component
public class DailyPlanDetails {
 private Integer dpdId;
 private Integer dpId;
 private Integer proId;
 private String chineseName;
 private Integer productionQuantity;
 private Integer daypracticalQuantity;
 private String planDetailDes;

public DailyPlanDetails(Integer dpdId, Integer dpId, Integer proId, String chineseName, Integer productionQuantity,
		Integer daypracticalQuantity, String planDetailDes) {
	super();
	this.dpdId = dpdId;
	this.dpId = dpId;
	this.proId = proId;
	this.chineseName = chineseName;
	this.productionQuantity = productionQuantity;
	this.daypracticalQuantity = daypracticalQuantity;
	this.planDetailDes = planDetailDes;
}
public String getChineseName() {
	return chineseName;
}
public void setChineseName(String chineseName) {
	this.chineseName = chineseName;
}
public String getPlanDetailDes() {
	return planDetailDes;
}
public void setPlanDetailDes(String planDetailDes) {
	this.planDetailDes = planDetailDes;
}
public DailyPlanDetails(Integer dpdId, Integer dpId, Integer proId, Integer productionQuantity,
		Integer daypracticalQuantity, String planDetailDes) {
	super();
	this.dpdId = dpdId;
	this.dpId = dpId;
	this.proId = proId;
	this.productionQuantity = productionQuantity;
	this.daypracticalQuantity = daypracticalQuantity;
	this.planDetailDes = planDetailDes;
}
public DailyPlanDetails() {
	super();
}
public Integer getDpdId() {
	return dpdId;
}
public void setDpdId(Integer dpdId) {
	this.dpdId = dpdId;
}
public Integer getDpId() {
	return dpId;
}
public void setDpId(Integer dpId) {
	this.dpId = dpId;
}
public Integer getProId() {
	return proId;
}
public void setProId(Integer proId) {
	this.proId = proId;
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
 
}
