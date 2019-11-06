package com.drug.dml.entity;

import org.springframework.stereotype.Component;

/**
 * 多表查询获得该月计划的月计划详情实体类
 * @author dml
 */
@Component
public class PlanDetails {
	private Integer monthPlanId;		//月计划Id
	private Integer monthPlanDetailId;	//月计划 详情Id
	private Integer proId;				//药品Id
	private String chineseName;		//药品名称
	private String proImage;		//药品图片路径
	private Integer produceNum;			//药品生产数量
	public Integer getMonthPlanId() {
		return monthPlanId;
	}
	public void setMonthPlanId(Integer monthPlanId) {
		this.monthPlanId = monthPlanId;
	}
	public Integer getMonthPlanDetailId() {
		return monthPlanDetailId;
	}
	public void setMonthPlanDetailId(Integer monthPlanDetailId) {
		this.monthPlanDetailId = monthPlanDetailId;
	}
	public Integer getProId() {
		return proId;
	}
	public void setProId(Integer proId) {
		this.proId = proId;
	}
	public String getChineseName() {
		return chineseName;
	}
	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	public String getProImage() {
		return proImage;
	}
	public void setProImage(String proImage) {
		this.proImage = proImage;
	}
	public Integer getProduceNum() {
		return produceNum;
	}
	public void setProduceNum(Integer produceNum) {
		this.produceNum = produceNum;
	}
	public PlanDetails() {
		super();
	}
	
}
