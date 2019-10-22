package com.drug.hxb.entity;

import org.springframework.stereotype.Component;

/**
 * @说明:原料出库表
 * @author hxb
 * @datetime 2019年10月21日上午11:44:05
 * @version 1.0
 */
@Component
public class RawMaterialOutbound {
	/**
	 * 原料出库单id
	 */
	private int rmoId;
	/**
	 * 出库时间
	 */
	private String rmoTime;
	/**
	 * 领料人
	 */
	private String accepter;
	/**
	 * 出库状态
	 */
	private String rmoStatus;
	/**
	 * 备注
	 */
	private String storageRemarks;
	/**
	 * 仓库id
	 */
	private int warId;
	/**
	 * 管理员id
	 */
	private int Employeeid;
	/**
	 * 出库数量
	 */
	private int rmoNumber;
	/**
	 * 成品id
	 */
	private int rawMaterialId;
	
	public int getRmoNumber() {
		return rmoNumber;
	}
	public void setRmoNumber(int rmoNumber) {
		this.rmoNumber = rmoNumber;
	}
	
	
	public int getRawMaterialId() {
		return rawMaterialId;
	}
	public void setRawMaterialId(int rawMaterialId) {
		this.rawMaterialId = rawMaterialId;
	}
	public int getRmoId() {
		return rmoId;
	}
	public void setRmoId(int rmoId) {
		this.rmoId = rmoId;
	}
	public String getRmoTime() {
		return rmoTime;
	}
	public void setRmoTime(String rmoTime) {
		this.rmoTime = rmoTime;
	}
	public String getAccepter() {
		return accepter;
	}
	public void setAccepter(String accepter) {
		this.accepter = accepter;
	}
	public String getRmoStatus() {
		return rmoStatus;
	}
	public void setRmoStatus(String rmoStatus) {
		this.rmoStatus = rmoStatus;
	}
	public String getStorageRemarks() {
		return storageRemarks;
	}
	public void setStorageRemarks(String storageRemarks) {
		this.storageRemarks = storageRemarks;
	}
	public int getWarId() {
		return warId;
	}
	public void setWarId(int warId) {
		this.warId = warId;
	}
	public int getEmployeeid() {
		return Employeeid;
	}
	public void setEmployeeid(int employeeid) {
		Employeeid = employeeid;
	}
	
	
}
