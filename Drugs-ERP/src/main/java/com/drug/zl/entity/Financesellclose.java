package com.drug.zl.entity;
/**
 * 
 *描述:财务销售结算表实体类
 * @author 磊锅锅
 *上午9:11:23
 * version
 */
public class Financesellclose {
	private int financeSellCloseId;//销售结算id
	private double paidMoney;//已结算金额
	private double unPaidMoney;//未结算金额
	private int sellOrderId;//销售订单idid
	private String financeManId;//财务经办人id
	private String fSCTime;//结算时间
	private String fSCRemark;//备注
	
	
	

	public int getFinanceSellCloseId() {
		return financeSellCloseId;
	}




	public void setFinanceSellCloseId(int financeSellCloseId) {
		this.financeSellCloseId = financeSellCloseId;
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




	public int getSellOrderId() {
		return sellOrderId;
	}




	public void setSellOrderId(int sellOrderId) {
		this.sellOrderId = sellOrderId;
	}




	public String getFinanceManId() {
		return financeManId;
	}




	public void setFinanceManId(String financeManId) {
		this.financeManId = financeManId;
	}




	public String getfSCTime() {
		return fSCTime;
	}




	public void setfSCTime(String fSCTime) {
		this.fSCTime = fSCTime;
	}




	public String getfSCRemark() {
		return fSCRemark;
	}




	public void setfSCRemark(String fSCRemark) {
		this.fSCRemark = fSCRemark;
	}
	



	public Financesellclose(int financeSellCloseId, double paidMoney, double unPaidMoney, int sellOrderId,
			String financeManId, String fSCTime, String fSCRemark) {
		super();
		this.financeSellCloseId = financeSellCloseId;
		this.paidMoney = paidMoney;
		this.unPaidMoney = unPaidMoney;
		this.sellOrderId = sellOrderId;
		this.financeManId = financeManId;
		this.fSCTime = fSCTime;
		this.fSCRemark = fSCRemark;
	}




	public Financesellclose() {
		super();
	}
	
}
