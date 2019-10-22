package com.drug.hxb.entity;

import org.springframework.stereotype.Component;

/**
 * @说明:废料出库单
 * @author hxb
 * @datetime 2019年10月21日下午2:41:21
 * @version 1.0
 */
@Component
public class WasteOutbound {
	/**
	 * 废料出库单id
	 */
	private int woId;
	/**
	 * 出库时间
	 */
	private String woTime;
	/**
	 * 收货人
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
	private int wodNumber;
	/**
	 * 废料id
	 */
	private int wasteId;
	public int getWoId() {
		return woId;
	}
	public void setWoId(int woId) {
		this.woId = woId;
	}
	public String getWoTime() {
		return woTime;
	}
	public void setWoTime(String woTime) {
		this.woTime = woTime;
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
	public int getWodNumber() {
		return wodNumber;
	}
	public void setWodNumber(int wodNumber) {
		this.wodNumber = wodNumber;
	}
	public int getWasteId() {
		return wasteId;
	}
	public void setWasteId(int wasteId) {
		this.wasteId = wasteId;
	}
	
}
