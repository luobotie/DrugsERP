package com.drug.zl.entity;
/**
 * 
 *描述:采购退货详情表的实体类
 * @author 磊锅锅
 *上午10:47:06
 * version
 */
public class Purchasereturndetail {
	private int purchaseReturnDetailId;//采购退货详情id
	private String rawMarerialName;//原材料名字
	private int rawMareriaNum;//数量
	private double returnPrice;//退货价
	private int purchaseorderId;//采购单id
	private double returnTotalPrice;//退货总额
	
	
	

	public int getPurchaseReturnDetailId() {
		return purchaseReturnDetailId;
	}



	public void setPurchaseReturnDetailId(int purchaseReturnDetailId) {
		this.purchaseReturnDetailId = purchaseReturnDetailId;
	}



	public String getRawMarerialName() {
		return rawMarerialName;
	}



	public void setRawMarerialName(String rawMarerialName) {
		this.rawMarerialName = rawMarerialName;
	}



	public int getRawMareriaNum() {
		return rawMareriaNum;
	}



	public void setRawMareriaNum(int rawMareriaNum) {
		this.rawMareriaNum = rawMareriaNum;
	}



	public double getReturnPrice() {
		return returnPrice;
	}



	public void setReturnPrice(double returnPrice) {
		this.returnPrice = returnPrice;
	}



	public int getPurchaseorderId() {
		return purchaseorderId;
	}



	public void setPurchaseorderId(int purchaseorderId) {
		this.purchaseorderId = purchaseorderId;
	}



	public double getReturnTotalPrice() {
		return returnTotalPrice;
	}



	public void setReturnTotalPrice(double returnTotalPrice) {
		this.returnTotalPrice = returnTotalPrice;
	}




	public Purchasereturndetail(int purchaseReturnDetailId, String rawMarerialName, int rawMareriaNum,
			double returnPrice, int purchaseorderId, double returnTotalPrice) {
		super();
		this.purchaseReturnDetailId = purchaseReturnDetailId;
		this.rawMarerialName = rawMarerialName;
		this.rawMareriaNum = rawMareriaNum;
		this.returnPrice = returnPrice;
		this.purchaseorderId = purchaseorderId;
		this.returnTotalPrice = returnTotalPrice;
	}



	public Purchasereturndetail() {
		super();
	}
	
}
