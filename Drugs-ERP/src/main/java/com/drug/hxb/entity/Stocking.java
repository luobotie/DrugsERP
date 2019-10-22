package com.drug.hxb.entity;

import org.springframework.stereotype.Component;

/**
 * @说明:盘点单
 * @author hxb
 * @datetime 2019年10月21日下午3:31:07
 * @version 1.0
 */
@Component
public class Stocking {
	/**
	 * 盘点单号
	 */
	private int skId;
	/**
	 * 盘点时间
	 */
	private String skTime;
	/**
	 * 盘点仓库
	 */
	private int warId;
	/**
	 * 管理员
	 */
	private int Employeeid;
	/**
	 * 盘点详情单id
	 */
	private int skdId;
	/**
	 * 库存数量
	 */
	private int inventoryNumber;
	/**
	 * 实盘数量
	 */
	private int realityNumber;
	/**
	 * 药品编号
	 */
	private int proId;
	public int getSkId() {
		return skId;
	}
	public void setSkId(int skId) {
		this.skId = skId;
	}
	public String getSkTime() {
		return skTime;
	}
	public void setSkTime(String skTime) {
		this.skTime = skTime;
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
	public int getSkdId() {
		return skdId;
	}
	public void setSkdId(int skdId) {
		this.skdId = skdId;
	}
	public int getInventoryNumber() {
		return inventoryNumber;
	}
	public void setInventoryNumber(int inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
	}
	public int getRealityNumber() {
		return realityNumber;
	}
	public void setRealityNumber(int realityNumber) {
		this.realityNumber = realityNumber;
	}
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	
	
}
