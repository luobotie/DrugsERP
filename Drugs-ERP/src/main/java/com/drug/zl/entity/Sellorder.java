package com.drug.zl.entity;
/**
 * 
 *描述:销售订单的实体类
 * @author 磊锅锅
 *上午9:06:34
 * version
 */
public class Sellorder {
	private int sellOrderId;//销售订单id
	private int sellDetailId;//销售订单详情id
	private String drugName;//药品名称
	private int drugNum;//数量
	private double subTotal;//小计
	public int getSellOrderId() {
		return sellOrderId;
	}
	public void setSellOrderId(int sellOrderId) {
		this.sellOrderId = sellOrderId;
	}
	public int getSellDetailId() {
		return sellDetailId;
	}
	public void setSellDetailId(int sellDetailId) {
		this.sellDetailId = sellDetailId;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public int getDrugNum() {
		return drugNum;
	}
	public void setDrugNum(int drugNum) {
		this.drugNum = drugNum;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public Sellorder(int sellOrderId, int sellDetailId, String drugName, int drugNum, double subTotal) {
		super();
		this.sellOrderId = sellOrderId;
		this.sellDetailId = sellDetailId;
		this.drugName = drugName;
		this.drugNum = drugNum;
		this.subTotal = subTotal;
	}
	public Sellorder() {
		super();
	}
	
	
}
