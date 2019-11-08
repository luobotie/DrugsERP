package com.drug.dml.entity;

import org.springframework.stereotype.Component;

/**
 * 月计划详情实体类
 * @author dml
 */
@Component
public class DrugsMonthPlanDetails {
	private Integer monthPlanDetailId;	// 生产月计划明细编号(主键)
	private Integer monthPlanId;		// 生产月计划编号（外键 表：drugs_monthPlan  主键：monthPlanId） REFERENCES drugs_monthPlan(monthPlanId)
	private Integer proId;				// 药品Id(外键 表：product_Info 主键：proId ) REFERENCES product_Info(proId)
	private Integer produceNum;			// 生产数量
	private String remarks;			// 备注
	
	public Integer getMonthPlanDetailId() {
		return monthPlanDetailId;
	}

	public void setMonthPlanDetailId(Integer monthPlanDetailId) {
		this.monthPlanDetailId = monthPlanDetailId;
	}

	public Integer getMonthPlanId() {
		return monthPlanId;
	}

	public void setMonthPlanId(Integer monthPlanId) {
		this.monthPlanId = monthPlanId;
	}

	public Integer getProId() {
		return proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public Integer getProduceNum() {
		return produceNum;
	}

	public void setProduceNum(Integer produceNum) {
		this.produceNum = produceNum;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public DrugsMonthPlanDetails() {
		super();
	}
	
}
