package com.drug.zl.entity;
/**
 * 
 *描述:退货订单详情实体类
 * @author 磊锅锅
 *下午4:16:56
 * version
 */
public class Sellreturndetail {
	private int sellReturnDetailId;//退货订单详情id
	private int sellOrderId;//销售订单id
	private int sellReturnNum;//退货数量
	private double sellReturnPrice;//退货价格
	private double sellReturnTotalPrice;//退货总额
	private int sellReturnOrderId;//销售退货id
	public int getSellReturnDetailId() {
		return sellReturnDetailId;
	}
	public void setSellReturnDetailId(int sellReturnDetailId) {
		this.sellReturnDetailId = sellReturnDetailId;
	}
	public int getSellOrderId() {
		return sellOrderId;
	}
	public void setSellOrderId(int sellOrderId) {
		this.sellOrderId = sellOrderId;
	}
	public int getSellReturnNum() {
		return sellReturnNum;
	}
	public void setSellReturnNum(int sellReturnNum) {
		this.sellReturnNum = sellReturnNum;
	}
	public double getSellReturnPrice() {
		return sellReturnPrice;
	}
	public void setSellReturnPrice(double sellReturnPrice) {
		this.sellReturnPrice = sellReturnPrice;
	}
	public double getSellReturnTotalPrice() {
		return sellReturnTotalPrice;
	}
	public void setSellReturnTotalPrice(double sellReturnTotalPrice) {
		this.sellReturnTotalPrice = sellReturnTotalPrice;
	}
	public int getSellReturnOrderId() {
		return sellReturnOrderId;
	}
	public void setSellReturnOrderId(int sellReturnOrderId) {
		this.sellReturnOrderId = sellReturnOrderId;
	}
	public Sellreturndetail(int sellReturnDetailId, int sellOrderId, int sellReturnNum, double sellReturnPrice,
			double sellReturnTotalPrice, int sellReturnOrderId) {
		super();
		this.sellReturnDetailId = sellReturnDetailId;
		this.sellOrderId = sellOrderId;
		this.sellReturnNum = sellReturnNum;
		this.sellReturnPrice = sellReturnPrice;
		this.sellReturnTotalPrice = sellReturnTotalPrice;
		this.sellReturnOrderId = sellReturnOrderId;
	}
	public Sellreturndetail() {
		super();
	}
	
}
