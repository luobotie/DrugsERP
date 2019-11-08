package com.drug.hxb.entity;

import org.springframework.stereotype.Component;

/**
 * @说明:仓库表
 * @author hxb
 * @datetime 2019年10月21日上午10:49:22
 * @version 1.0
 */
@Component
public class Warehouse {
	/**
	 * 仓库id
	 */
	private Integer warId;
	/**
	 * 仓库名
	 */
	private String warName;
	/**
	 * 仓库类型
	 */
	private String warType;
	/**
	 * 仓库地址
	 */
	private String warAddress;
	/**
	 * 仓库电话
	 */
	private String warTel;
	
	
	public Integer getWarId() {
		return warId;
	}
	public void setWarId(Integer warId) {
		this.warId = warId;
	}
	public String getWarName() {
		return warName;
	}
	public void setWarName(String warName) {
		this.warName = warName;
	}
	public String getWarType() {
		return warType;
	}
	public void setWarType(String warType) {
		this.warType = warType;
	}
	public String getWarAddress() {
		return warAddress;
	}
	public void setWarAddress(String warAddress) {
		this.warAddress = warAddress;
	}
	public String getWarTel() {
		return warTel;
	}
	public void setWarTel(String warTel) {
		this.warTel = warTel;
	}
	public Warehouse(Integer warId, String warName, String warType, String warAddress, String warTel) {
		super();
		this.warId = warId;
		this.warName = warName;
		this.warType = warType;
		this.warAddress = warAddress;
		this.warTel = warTel;
	}
	public Warehouse() {
		super();
	}
	
	
}
