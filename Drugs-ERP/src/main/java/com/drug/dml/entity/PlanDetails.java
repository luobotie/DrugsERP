package com.drug.dml.entity;

import org.springframework.stereotype.Component;

/**
 * 多表查询获得该月计划的月计划详情实体类
 * @author dml
 */
@Component
public class PlanDetails {
	private int monthPlanDetailId;	//药品详情Id
	private int proId;				//药品Id
	private String chineseName;		//药品名称
	private String proImage;		//药品图片路径
	private int produceNum;			//药品生产数量
	
	public int getMonthPlanDetailId() {
		return monthPlanDetailId;
	}
	public void setMonthPlanDetailId(int monthPlanDetailId) {
		this.monthPlanDetailId = monthPlanDetailId;
	}
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
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
	public int getProduceNum() {
		return produceNum;
	}
	public void setProduceNum(int produceNum) {
		this.produceNum = produceNum;
	}
	public PlanDetails(int monthPlanDetailId, int proId, String chineseName, String proImage, int produceNum) {
		this.monthPlanDetailId = monthPlanDetailId;
		this.proId = proId;
		this.chineseName = chineseName;
		this.proImage = proImage;
		this.produceNum = produceNum;
	}
	public PlanDetails(int monthPlanDetailId, int proId, String chineseName, int produceNum) {
		this.monthPlanDetailId = monthPlanDetailId;
		this.proId = proId;
		this.chineseName = chineseName;
		this.produceNum = produceNum;
	}
	public PlanDetails() {
		super();
	}
	
}
