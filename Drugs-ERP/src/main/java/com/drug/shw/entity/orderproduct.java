package com.drug.shw.entity;

import org.springframework.stereotype.Component;

@Component
public class orderproduct {
private Integer orderId;
private Integer produceNumber;
private Double produceMoney;
private Integer finishNumber;
private String employName;
private String orderDate;
private String produceState;
private String materialState;
private String  auditState;
private Integer  dayPlanId;

public orderproduct(Integer orderId, Integer produceNumber, Double produceMoney, Integer finishNumber,
		String employName, String orderDate, String produceState, String materialState, String auditState,
		Integer dayPlanId) {
	super();
	this.orderId = orderId;
	this.produceNumber = produceNumber;
	this.produceMoney = produceMoney;
	this.finishNumber = finishNumber;
	this.employName = employName;
	this.orderDate = orderDate;
	this.produceState = produceState;
	this.materialState = materialState;
	this.auditState = auditState;
	this.dayPlanId = dayPlanId;
}

public orderproduct() {
	super();
}

public Integer getDayPlanId() {
	return dayPlanId;
}
public void setDayPlanId(Integer dayPlanId) {
	this.dayPlanId = dayPlanId;
}
public Integer getOrderId() {
	return orderId;
}
public void setOrderId(Integer orderId) {
	this.orderId = orderId;
}
public Integer getProduceNumber() {
	return produceNumber;
}
public void setProduceNumber(Integer produceNumber) {
	this.produceNumber = produceNumber;
}
public Double getProduceMoney() {
	return produceMoney;
}
public void setProduceMoney(Double produceMoney) {
	this.produceMoney = produceMoney;
}
public Integer getFinishNumber() {
	return finishNumber;
}
public void setFinishNumber(Integer finishNumber) {
	this.finishNumber = finishNumber;
}
public String getEmployName() {
	return employName;
}
public void setEmployName(String employName) {
	this.employName = employName;
}
public String getOrderDate() {
	return orderDate;
}
public void setOrderDate(String orderDate) {
	this.orderDate = orderDate;
}
public String getProduceState() {
	return produceState;
}
public void setProduceState(String produceState) {
	this.produceState = produceState;
}
public String getMaterialState() {
	return materialState;
}
public void setMaterialState(String materialState) {
	this.materialState = materialState;
}
public String getAuditState() {
	return auditState;
}
public void setAuditState(String auditState) {
	this.auditState = auditState;
}

}
