package com.drug.shw.entity;

import org.springframework.stereotype.Component;

@Component
public class Drug{
 private Integer monthPlanDetailId;
 private Integer monthPlanId;
 private Integer proId;
 private Integer produceNum;
 private String remarks;
 private String  spare1;
 private String  spare2;
 private String  spare3;
 
public String getRemarks() {
	return remarks;
}
public void setRemarks(String remarks) {
	this.remarks = remarks;
}
public String getSpare1() {
	return spare1;
}
public void setSpare1(String spare1) {
	this.spare1 = spare1;
}
public String getSpare2() {
	return spare2;
}
public void setSpare2(String spare2) {
	this.spare2 = spare2;
}
public String getSpare3() {
	return spare3;
}
public void setSpare3(String spare3) {
	this.spare3 = spare3;
}
public Integer getMonthPlanDetailId() {
	return monthPlanDetailId;
}
public void setMonthPlanDetailId(Integer monthPlanDetailId) {
	this.monthPlanDetailId = monthPlanDetailId;
}
public Integer getMonthPlanId() {
	return monthPlanId;
}
public void setMonthPlanId(Integer monthPlanId) {
	this.monthPlanId = monthPlanId;
}
public Integer getProId() {
	return proId;
}
public void setProId(Integer proId) {
	this.proId = proId;
}
public Integer getProduceNum() {
	return produceNum;
}
public void setProduceNum(Integer produceNum) {
	this.produceNum = produceNum;
}

public Drug(Integer monthPlanDetailId, Integer monthPlanId, Integer proId, Integer produceNum, String remarks,
		String spare1, String spare2, String spare3) {
	super();
	this.monthPlanDetailId = monthPlanDetailId;
	this.monthPlanId = monthPlanId;
	this.proId = proId;
	this.produceNum = produceNum;
	this.remarks = remarks;
	this.spare1 = spare1;
	this.spare2 = spare2;
	this.spare3 = spare3;
}
public Drug() {
	super();
}
 
}
