package com.drug.zl.entity;
/**
 * 
 *描述:采购详情表的实体类
 * @author 磊锅锅
 *上午10:54:07
 * version
 */
public class Purchasedetails {
	private int purchaseDetailsId;//采购详情逐渐
	private int purchaseorderId;//采购订单id
	private String purchaseType;//类别
	private int purchaseNum;//采购数量
	private int purchaseQuanNum;//合格数量
	private double purchaseTotal;//小计
	
	
	public int getPurchaseDetailsId() {
		return purchaseDetailsId;
	}

	public void setPurchaseDetailsId(int purchaseDetailsId) {
		this.purchaseDetailsId = purchaseDetailsId;
	}

	public int getPurchaseorderId() {
		return purchaseorderId;
	}

	public void setPurchaseorderId(int purchaseorderId) {
		this.purchaseorderId = purchaseorderId;
	}

	public String getPurchaseType() {
		return purchaseType;
	}

	public void setPurchaseType(String purchaseType) {
		this.purchaseType = purchaseType;
	}

	public int getPurchaseNum() {
		return purchaseNum;
	}

	public void setPurchaseNum(int purchaseNum) {
		this.purchaseNum = purchaseNum;
	}

	public int getPurchaseQuanNum() {
		return purchaseQuanNum;
	}

	public void setPurchaseQuanNum(int purchaseQuanNum) {
		this.purchaseQuanNum = purchaseQuanNum;
	}

	public double getPurchaseTotal() {
		return purchaseTotal;
	}

	public void setPurchaseTotal(double purchaseTotal) {
		this.purchaseTotal = purchaseTotal;
	}

	
	public Purchasedetails(int purchaseDetailsId, int purchaseorderId, String purchaseType, int purchaseNum,
			int purchaseQuanNum, double purchaseTotal) {
		super();
		this.purchaseDetailsId = purchaseDetailsId;
		this.purchaseorderId = purchaseorderId;
		this.purchaseType = purchaseType;
		this.purchaseNum = purchaseNum;
		this.purchaseQuanNum = purchaseQuanNum;
		this.purchaseTotal = purchaseTotal;
		
	}

	public Purchasedetails() {
		super();
	}
	
	                 
}
