package com.drug.hxb.entity;

import org.springframework.stereotype.Component;

/**
 * @说明:原料入库表
 * @author hxb
 * @datetime 2019年10月21日上午11:16:05
 * @version 1.0
 */
@Component
public class RawMaterialStorage {
	/**
	 * 原料入库单id
	 */
	private Integer rmsId;
	/**
	 * 入库时间
	 */
	private String rmsTime;
	/**
	 * 送货人
	 */
	private String deliveryMan;
	/**
	 * 入库状态
	 */
	private String rmsStatus;
	/**
	 * 备注
	 */
	private String storageRemarks;
	/**
	 * 仓库id
	 */
	private Integer warId;
	/**
	 * 管理员id
	 */
	private Integer Employeeid;
	/**
	 * 入库数量
	 */
	private Integer rsdNumber;
	/**
	 * 原料id
	 */
	private Integer rawMaterialId;
	public Integer getRmsId() {
		return rmsId;
	}
	public void setRmsId(Integer rmsId) {
		this.rmsId = rmsId;
	}
	public String getRmsTime() {
		return rmsTime;
	}
	public void setRmsTime(String rmsTime) {
		this.rmsTime = rmsTime;
	}
	public String getDeliveryMan() {
		return deliveryMan;
	}
	public void setDeliveryMan(String deliveryMan) {
		this.deliveryMan = deliveryMan;
	}
	public String getRmsStatus() {
		return rmsStatus;
	}
	public void setRmsStatus(String rmsStatus) {
		this.rmsStatus = rmsStatus;
	}
	public String getStorageRemarks() {
		return storageRemarks;
	}
	public void setStorageRemarks(String storageRemarks) {
		this.storageRemarks = storageRemarks;
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
	public Integer getRsdNumber() {
		return rsdNumber;
	}
	public void setRsdNumber(Integer rsdNumber) {
		this.rsdNumber = rsdNumber;
	}
	public Integer getRawMaterialId() {
		return rawMaterialId;
	}
	public void setRawMaterialId(Integer rawMaterialId) {
		this.rawMaterialId = rawMaterialId;
	}
	
	
}
