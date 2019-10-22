package com.drug.hxb.entity;

import org.springframework.stereotype.Component;

/**
 * @说明:废料表入库单
 * @author hxb
 * @datetime 2019年10月21日下午2:37:50
 * @version 1.0
 */
@Component
public class WasteStorage {
	/**
	 * 废料单id
	 */
	private int wsId;
	/**
	 * 入库时间
	 */
	private String wsTime;
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
	 * 详情表id
	 */
	private Integer rsdId;
	/**
	 * 入库数量
	 */
	private Integer wsdNumber;
	/**
	 * 原料id
	 */
	private Integer rawMaterialId;
	public int getWsId() {
		return wsId;
	}
	public void setWsId(int wsId) {
		this.wsId = wsId;
	}
	public String getWsTime() {
		return wsTime;
	}
	public void setWsTime(String wsTime) {
		this.wsTime = wsTime;
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
	public Integer getRsdId() {
		return rsdId;
	}
	public void setRsdId(Integer rsdId) {
		this.rsdId = rsdId;
	}
	
	public Integer getWsdNumber() {
		return wsdNumber;
	}
	public void setWsdNumber(Integer wsdNumber) {
		this.wsdNumber = wsdNumber;
	}
	public Integer getRawMaterialId() {
		return rawMaterialId;
	}
	public void setRawMaterialId(Integer rawMaterialId) {
		this.rawMaterialId = rawMaterialId;
	} 
	
}
