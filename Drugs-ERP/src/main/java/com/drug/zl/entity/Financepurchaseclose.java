package com.drug.zl.entity;
/**
 * 
 *描述:财务采购结算单的实体类
 * @author 磊锅锅
 *上午8:51:09
 * version
 */
public class Financepurchaseclose {
	private int financePurchaseCloseId;//采购结算单id
	private double paidMoney;//已付金额
	private double unPaidMoney;//未付金额
	private int purchaseorderId;//采购单id
	private String financeManId;//经办人id
	private String closeTime;//结算时间
	private double firstMoney;//首款
	private double lastMoney;//尾款
	private double practicalPaidMoney;//实际支出金额
	private double shouldPaidMoney;//应支出金额
	private String fPCRemark;//备注
	
	
	public int getFinancePurchaseCloseId() {
		return financePurchaseCloseId;
	}

	public void setFinancePurchaseCloseId(int financePurchaseCloseId) {
		this.financePurchaseCloseId = financePurchaseCloseId;
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

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

	public double getFirstMoney() {
		return firstMoney;
	}

	public void setFirstMoney(double firstMoney) {
		this.firstMoney = firstMoney;
	}

	public double getLastMoney() {
		return lastMoney;
	}

	public void setLastMoney(double lastMoney) {
		this.lastMoney = lastMoney;
	}

	public double getPracticalPaidMoney() {
		return practicalPaidMoney;
	}

	public void setPracticalPaidMoney(double practicalPaidMoney) {
		this.practicalPaidMoney = practicalPaidMoney;
	}

	public double getShouldPaidMoney() {
		return shouldPaidMoney;
	}

	public void setShouldPaidMoney(double shouldPaidMoney) {
		this.shouldPaidMoney = shouldPaidMoney;
	}

	public String getfPCRemark() {
		return fPCRemark;
	}

	public void setfPCRemark(String fPCRemark) {
		this.fPCRemark = fPCRemark;
	}

	
	
	public Financepurchaseclose(int financePurchaseCloseId, double paidMoney, double unPaidMoney, int purchaseorderId,
			String financeManId, String closeTime, double firstMoney, double lastMoney, double practicalPaidMoney,
			double shouldPaidMoney, String fPCRemark) {
		super();
		this.financePurchaseCloseId = financePurchaseCloseId;
		this.paidMoney = paidMoney;
		this.unPaidMoney = unPaidMoney;
		this.purchaseorderId = purchaseorderId;
		this.financeManId = financeManId;
		this.closeTime = closeTime;
		this.firstMoney = firstMoney;
		this.lastMoney = lastMoney;
		this.practicalPaidMoney = practicalPaidMoney;
		this.shouldPaidMoney = shouldPaidMoney;
		this.fPCRemark = fPCRemark;
		
	}
	
	public Financepurchaseclose(double paidMoney, double unPaidMoney, int purchaseorderId, String financeManId,
			String closeTime, double firstMoney, double lastMoney, double practicalPaidMoney, double shouldPaidMoney,
			String fPCRemark) {
		super();
		this.paidMoney = paidMoney;
		this.unPaidMoney = unPaidMoney;
		this.purchaseorderId = purchaseorderId;
		this.financeManId = financeManId;
		this.closeTime = closeTime;
		this.firstMoney = firstMoney;
		this.lastMoney = lastMoney;
		this.practicalPaidMoney = practicalPaidMoney;
		this.shouldPaidMoney = shouldPaidMoney;
		this.fPCRemark = fPCRemark;
	}

	public Financepurchaseclose() {
		super();
	}
	
}
