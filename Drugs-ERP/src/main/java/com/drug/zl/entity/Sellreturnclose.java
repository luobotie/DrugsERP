package com.drug.zl.entity;
/**
 * 
 *描述:销售退货结算表的实体类
 * @author 磊锅锅
 *下午3:19:22
 * version
 */
public class Sellreturnclose {
	private int sellReturnCloseId;//销售退货结算id
	private double paidMoney;//已结算金额
	private double unPaidMoney;//未结算金额
	private int sellOrderId;//销售订单id
	private String financeManId;//财务经办人
	private String sRCTime;//结算时间
	private String sRCRemark;//备注
	
	public int getSellReturnCloseId() {
		return sellReturnCloseId;
	}

	public void setSellReturnCloseId(int sellReturnCloseId) {
		this.sellReturnCloseId = sellReturnCloseId;
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

	public String getsRCTime() {
		return sRCTime;
	}

	public void setsRCTime(String sRCTime) {
		this.sRCTime = sRCTime;
	}

	public String getsRCRemark() {
		return sRCRemark;
	}

	public void setsRCRemark(String sRCRemark) {
		this.sRCRemark = sRCRemark;
	}

	
	public Sellreturnclose(int sellReturnCloseId, double paidMoney, double unPaidMoney, int sellOrderId,
			String financeManId, String sRCTime, String sRCRemark) {
		super();
		this.sellReturnCloseId = sellReturnCloseId;
		this.paidMoney = paidMoney;
		this.unPaidMoney = unPaidMoney;
		this.sellOrderId = sellOrderId;
		this.financeManId = financeManId;
		this.sRCTime = sRCTime;
		this.sRCRemark = sRCRemark;
	}

	public Sellreturnclose() {
		super();
	}
	
	
}
