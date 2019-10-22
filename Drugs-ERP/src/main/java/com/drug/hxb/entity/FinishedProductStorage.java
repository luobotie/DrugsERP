package com.drug.hxb.entity;

import org.springframework.stereotype.Component;

/**
 * @说明:成品入库表
 * @author hxb
 * @datetime 2019年10月21日下午1:45:50
 * @version 1.0
 */
@Component
public class FinishedProductStorage {
	/**
	 * 成品入库表id
	 */
	private int fpsId;
	/**
	 * 入库时间
	 */
	private String fpsTime;
	/**
	 * 送货员
	 */
	private String deliveryMan;
	/**
	 * 入库状态
	 */
	private String fpsStatus;
	/**
	 * 仓库id
	 */
	private int warId;
	/**
	 * 管理员
	 */
	private int Employeeid;
	/**
	 * 入库数量
	 */
	private int fsdNumber;
	/**
	 * 药品id
	 */
	private int proId;
	public int getFpsId() {
		return fpsId;
	}
	public void setFpsId(int fpsId) {
		this.fpsId = fpsId;
	}
	public String getFpsTime() {
		return fpsTime;
	}
	public void setFpsTime(String fpsTime) {
		this.fpsTime = fpsTime;
	}
	public String getDeliveryMan() {
		return deliveryMan;
	}
	public void setDeliveryMan(String deliveryMan) {
		this.deliveryMan = deliveryMan;
	}
	public String getFpsStatus() {
		return fpsStatus;
	}
	public void setFpsStatus(String fpsStatus) {
		this.fpsStatus = fpsStatus;
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
	public int getFsdNumber() {
		return fsdNumber;
	}
	public void setFsdNumber(int fsdNumber) {
		this.fsdNumber = fsdNumber;
	}
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	
	
}
