package com.drug.hxb.entity;

import org.springframework.stereotype.Component;

/**
 * @说明:调拨单
 * @author hxb
 * @datetime 2019年10月21日下午3:21:25
 * @version 1.0
 */
@Component
public class Allocate_supplies {
	/**
	 * 调拨单id
	 */
	private int asId;
	/**
	 * 调拨时间
	 */
	private String asTime;
	/**
	 * 调入仓库
	 */
	private int iwarId;
	/**
	 * 调出仓库
	 */
	private int owarId;
	/**
	 * 管理员
	 */
	private int Employeeid;
	/**
	 * 详情表id
	 */
	private int asdId;
	/**
	 * 调货数量
	 */
	private int asdNumber;
	/**
	 * 药品编号
	 */
	private int proId;
	public int getAsId() {
		return asId;
	}
	public void setAsId(int asId) {
		this.asId = asId;
	}
	public String getAsTime() {
		return asTime;
	}
	public void setAsTime(String asTime) {
		this.asTime = asTime;
	}
	public int getIwarId() {
		return iwarId;
	}
	public void setIwarId(int iwarId) {
		this.iwarId = iwarId;
	}
	public int getOwarId() {
		return owarId;
	}
	public void setOwarId(int owarId) {
		this.owarId = owarId;
	}
	public int getEmployeeid() {
		return Employeeid;
	}
	public void setEmployeeid(int employeeid) {
		Employeeid = employeeid;
	}
	public int getAsdId() {
		return asdId;
	}
	public void setAsdId(int asdId) {
		this.asdId = asdId;
	}
	public int getAsdNumber() {
		return asdNumber;
	}
	public void setAsdNumber(int asdNumber) {
		this.asdNumber = asdNumber;
	}
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	
}
