package com.drug.dml.entity;

import org.springframework.stereotype.Component;

/**
 * 质检表实体类
 * @author dml
 */
@Component
public class CheckProduct {
	private Integer podId;			// 质检表主键
	private Integer orderId;		// 外键	成品生产订单id
	private Integer proId;			// 外键	成品id
	private String chineseName;		// 药品名
	private String qualitystatus;	// 质检状态
	private Integer statusMan;		// 质检人
	private String statustime;		// 质检时间
	private Integer materialId;				// 原材料ID
	private String materialName;			// 原材料名字
	private String materialPrice;			// 原材料价格
	private Integer productionQuantity; 	// 所需数量
	private Integer daypracticalQuantity;   // 实际完成数量
	private Integer dailyPlanid;			// 日计划ID
	private Integer dpId;					// 日计划ID 外键形式
	public Integer getPodId() {
		return podId;
	}
	public void setPodId(Integer podId) {
		this.podId = podId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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
	public String getQualitystatus() {
		return qualitystatus;
	}
	public void setQualitystatus(String qualitystatus) {
		this.qualitystatus = qualitystatus;
	}
	public Integer getStatusMan() {
		return statusMan;
	}
	public void setStatusMan(Integer statusMan) {
		this.statusMan = statusMan;
	}
	public String getStatustime() {
		return statustime;
	}
	public void setStatustime(String statustime) {
		this.statustime = statustime;
	}
	public Integer getMaterialId() {
		return materialId;
	}
	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public String getMaterialPrice() {
		return materialPrice;
	}
	public void setMaterialPrice(String materialPrice) {
		this.materialPrice = materialPrice;
	}
	public Integer getProductionQuantity() {
		return productionQuantity;
	}
	public void setProductionQuantity(Integer productionQuantity) {
		this.productionQuantity = productionQuantity;
	}
	public Integer getDaypracticalQuantity() {
		return daypracticalQuantity;
	}
	public void setDaypracticalQuantity(Integer daypracticalQuantity) {
		this.daypracticalQuantity = daypracticalQuantity;
	}
	public Integer getDailyPlanid() {
		return dailyPlanid;
	}
	public void setDailyPlanid(Integer dailyPlanid) {
		this.dailyPlanid = dailyPlanid;
	}
	public Integer getDpId() {
		return dpId;
	}
	public void setDpId(Integer dpId) {
		this.dpId = dpId;
	}
	
	
}
