package com.drug.dml.entity;

/**
 * 月计划详情实体类
 * @author dml
 */
public class DrugsMonthPlanDetails {
	private int monthPlanDetailId;	// 生产月计划明细编号(主键)
	private int monthPlanId;		// 生产月计划编号（外键 表：drugs_monthPlan  主键：monthPlanId） REFERENCES drugs_monthPlan(monthPlanId)
	private int proId;				// 药品Id(外键 表：product_Info 主键：proId ) REFERENCES product_Info(proId)
	private int produceNum;			// 生产数量
	private String remarks;			// 备注
	public int getMonthPlanDetailId() {
		return monthPlanDetailId;
	}
	public void setMonthPlanDetailId(int monthPlanDetailId) {
		this.monthPlanDetailId = monthPlanDetailId;
	}
	public int getMonthPlanId() {
		return monthPlanId;
	}
	public void setMonthPlanId(int monthPlanId) {
		this.monthPlanId = monthPlanId;
	}
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public int getProduceNum() {
		return produceNum;
	}
	public void setProduceNum(int produceNum) {
		this.produceNum = produceNum;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public DrugsMonthPlanDetails(int monthPlanDetailId, int monthPlanId, int proId, int produceNum, String remarks) {
		super();
		this.monthPlanDetailId = monthPlanDetailId;
		this.monthPlanId = monthPlanId;
		this.proId = proId;
		this.produceNum = produceNum;
		this.remarks = remarks;
	}
	public DrugsMonthPlanDetails() {
		super();
	}
	
}
