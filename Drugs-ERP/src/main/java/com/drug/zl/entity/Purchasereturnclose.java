package com.drug.zl.entity;
/**
 * 
 *描述:采购退货结算表的实体类
 * @author 磊锅锅
 *上午9:51:24
 * version
 */
public class Purchasereturnclose {
	private int purchasereturncloseId;//采购退货结算id
	private double paidMoney;//已结算金额
	private double unPaidMoney;//未结算金额
	private int purchaseorderId;//采购单id
	private String financeManId;//经办人id
	private String pRCTime;//结算时间
	private String pRCRemark;//备注
	
	
	

	public int getPurchasereturncloseId() {
		return purchasereturncloseId;
	}




	public void setPurchasereturncloseId(int purchasereturncloseId) {
		this.purchasereturncloseId = purchasereturncloseId;
	}




	public double getPaidMoney() {
		return paidMoney;
	}




	public void setPaidMoney(double paidMoney) {
		this.paidMoney = paidMoney;
	}




	public double getUnPaidMoney() {
		return unPaidMoney;
	}




	public void setUnPaidMoney(double unPaidMoney) {
		this.unPaidMoney = unPaidMoney;
	}




	public int getPurchaseorderId() {
		return purchaseorderId;
	}




	public void setPurchaseorderId(int purchaseorderId) {
		this.purchaseorderId = purchaseorderId;
	}




	public String getFinanceManId() {
		return financeManId;
	}




	public void setFinanceManId(String financeManId) {
		this.financeManId = financeManId;
	}




	public String getpRCTime() {
		return pRCTime;
	}




	public void setpRCTime(String pRCTime) {
		this.pRCTime = pRCTime;
	}




	public String getpRCRemark() {
		return pRCRemark;
	}




	public void setpRCRemark(String pRCRemark) {
		this.pRCRemark = pRCRemark;
	}
	



	public Purchasereturnclose(int purchasereturncloseId, double paidMoney, double unPaidMoney, int purchaseorderId,
			String financeManId, String pRCTime, String pRCRemark) {
		super();
		this.purchasereturncloseId = purchasereturncloseId;
		this.paidMoney = paidMoney;
		this.unPaidMoney = unPaidMoney;
		this.purchaseorderId = purchaseorderId;
		this.financeManId = financeManId;
		this.pRCTime = pRCTime;
		this.pRCRemark = pRCRemark;
	}




	public Purchasereturnclose() {
		super();
	}
	
}
