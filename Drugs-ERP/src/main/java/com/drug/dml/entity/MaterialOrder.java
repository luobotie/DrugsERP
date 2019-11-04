package com.drug.dml.entity;

import org.springframework.stereotype.Component;

/**
 * 领料单、原材料单、原料出库单实体类
 * @author dml
 */
@Component
public class MaterialOrder {
	private Integer moId;   				// 领料单Id
	private Integer orderId;				// 外键	生产订单Id
	private String applydate;				// 申请时间
	private Integer proposerId;				// 外键	订单申请人,来自员工表
	private String auditingdate;			// 审核时间
	private Integer auditorId;				// 外键	审核人,来自员工表
	private String moStatus;				// 审核状态
	private String warehouseStatus;			// 出库状态
	private String materialOrderdes;		// 备注
	private Integer materialId;				// 原材料ID
	private String materialName;			// 原材料名字
	private String materialPrice;			// 原材料价格
	private Integer productionQuantity; 	//所需原料数量
	private Integer rmoId; 					// 原料出库表主键
	private String rmoTime; 				// 创建时间
	private String rmoStatus; 				// 出库状态
	private Integer warId; 					// 仓库主键
	private Integer Employeeid; 			// 管理员主键
	private String storageRemarks; 			// 备注
	public Integer getMoId() {
		return moId;
	}
	public void setMoId(Integer moId) {
		this.moId = moId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getApplydate() {
		return applydate;
	}
	public void setApplydate(String applydate) {
		this.applydate = applydate;
	}
	public Integer getProposerId() {
		return proposerId;
	}
	public void setProposerId(Integer proposerId) {
		this.proposerId = proposerId;
	}
	public String getAuditingdate() {
		return auditingdate;
	}
	public void setAuditingdate(String auditingdate) {
		this.auditingdate = auditingdate;
	}
	public Integer getAuditorId() {
		return auditorId;
	}
	public void setAuditorId(Integer auditorId) {
		this.auditorId = auditorId;
	}
	public String getMoStatus() {
		return moStatus;
	}
	public void setMoStatus(String moStatus) {
		this.moStatus = moStatus;
	}
	public String getWarehouseStatus() {
		return warehouseStatus;
	}
	public void setWarehouseStatus(String warehouseStatus) {
		this.warehouseStatus = warehouseStatus;
	}
	public String getMaterialOrderdes() {
		return materialOrderdes;
	}
	public void setMaterialOrderdes(String materialOrderdes) {
		this.materialOrderdes = materialOrderdes;
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
	public Integer getRmoId() {
		return rmoId;
	}
	public void setRmoId(Integer rmoId) {
		this.rmoId = rmoId;
	}
	public String getRmoTime() {
		return rmoTime;
	}
	public void setRmoTime(String rmoTime) {
		this.rmoTime = rmoTime;
	}
	public String getRmoStatus() {
		return rmoStatus;
	}
	public void setRmoStatus(String rmoStatus) {
		this.rmoStatus = rmoStatus;
	}
	public Integer getWarId() {
		return warId;
	}
	public void setWarId(Integer warId) {
		this.warId = warId;
	}
	public Integer getEmployeeid() {
		return Employeeid;
	}
	public void setEmployeeid(Integer employeeid) {
		Employeeid = employeeid;
	}
	public String getStorageRemarks() {
		return storageRemarks;
	}
	public void setStorageRemarks(String storageRemarks) {
		this.storageRemarks = storageRemarks;
	}
	
}
