package com.drug.djl.entity;

import org.springframework.stereotype.Component;

/**
 * 
 * 描述:总店销售订单表实体类
 * @author djl
 * 2019年11月4日下午6:36:39
 * version:1.0
 */
@Component
public class HeadStoreSalesOrder {
	private String orderId	;//主键 销售订单ID
	private String orderTime ;// 下单时间
	private String orderNo	;//分店采购订单号
	private Double orderTotalMoney;// 订单总金额
	private String orderIsPay ;//支付状态（已支付/未支付）
	private String orderCheckStatus ;//审核状态
	private String orderOutStatus ;// 订单出库状态（xx）
	private Integer bsId;// 分店id(外键)
	private String orderReceiveTime ;// 收货时间（为null代表未收货）
	private Integer saleManId  ;//   -- 销售员id
	private String standByField1  ;// 备用字段1
	private String standByField2  ;// 备用字段2
	
	public String getOrderId() {
		return orderId;
	}
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Double getOrderTotalMoney() {
		return orderTotalMoney;
	}
	public void setOrderTotalMoney(Double orderTotalMoney) {
		this.orderTotalMoney = orderTotalMoney;
	}
	public String getOrderIsPay() {
		return orderIsPay;
	}
	public void setOrderIsPay(String orderIsPay) {
		this.orderIsPay = orderIsPay;
	}
	public String getOrderCheckStatus() {
		return orderCheckStatus;
	}
	public void setOrderCheckStatus(String orderCheckStatus) {
		this.orderCheckStatus = orderCheckStatus;
	}
	public String getOrderOutStatus() {
		return orderOutStatus;
	}
	public void setOrderOutStatus(String orderOutStatus) {
		this.orderOutStatus = orderOutStatus;
	}
	public Integer getBsId() {
		return bsId;
	}
	public void setBsId(Integer bsId) {
		this.bsId = bsId;
	}
	public String getOrderReceiveTime() {
		return orderReceiveTime;
	}
	public void setOrderReceiveTime(String orderReceiveTime) {
		this.orderReceiveTime = orderReceiveTime;
	}
	public Integer getSaleManId() {
		return saleManId;
	}
	public void setSaleManId(Integer saleManId) {
		this.saleManId = saleManId;
	}
	public String getStandByField1() {
		return standByField1;
	}
	public void setStandByField1(String standByField1) {
		this.standByField1 = standByField1;
	}
	public String getStandByField2() {
		return standByField2;
	}
	public void setStandByField2(String standByField2) {
		this.standByField2 = standByField2;
	}
	
	
}
