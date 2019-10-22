package com.drug.hxb.entity;

import org.springframework.stereotype.Component;

/**
 * @说明:成品出库表
 * @author hxb
 * @datetime 2019年10月21日下午1:52:12
 * @version 1.0
 */
@Component
public class FinishedProductOutbound {
	/**
	 * 出库单id
	 */
	private int fpoId;
	/**
	 * 出库时间
	 */
	private String fpoTime;
	/**
	 * 收货人
	 */
	private String accepter;
	/**
	 * 收货状态
	 */
	private String fpoStatus;
	/**
	 * 备注
	 */
	private String storageRemarks;
	/**
	 * 仓库id
	 */
	private int warId;
	/**
	 * 管理员
	 */
	private int Employeeid;
	/**
	 * 出库数量
	 */
	private int fpodNumber;
	/**
	 * 成品表主键id
	 */
	private int proId;
	public int getFpoId() {
		return fpoId;
	}
	public void setFpoId(int fpoId) {
		this.fpoId = fpoId;
	}
	public String getFpoTime() {
		return fpoTime;
	}
	public void setFpoTime(String fpoTime) {
		this.fpoTime = fpoTime;
	}
	public String getAccepter() {
		return accepter;
	}
	public void setAccepter(String accepter) {
		this.accepter = accepter;
	}
	public String getFpoStatus() {
		return fpoStatus;
	}
	public void setFpoStatus(String fpoStatus) {
		this.fpoStatus = fpoStatus;
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
	public int getFpodNumber() {
		return fpodNumber;
	}
	public void setFpodNumber(int fpodNumber) {
		this.fpodNumber = fpodNumber;
	}
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	
	
}
