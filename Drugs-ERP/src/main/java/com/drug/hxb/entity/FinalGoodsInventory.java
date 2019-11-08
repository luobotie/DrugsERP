package com.drug.hxb.entity;

import org.springframework.stereotype.Component;

/**
 * @说明:成品库存表
 * @author hxb
 * @datetime 2019年10月21日上午11:06:34
 * @version 1.0
 */
@Component
public class FinalGoodsInventory {
	/**
	 * 成品id  外键
	 */
	private Integer proId;
	/**
	 * 成品库存数量
	 */
	private Integer fgiNumber;
	/**
	 * 最大数量
	 */
	private Integer fgiMax;
	/**
	 * 仓库id
	 */
	private Integer warId;
	
	public Integer getProId() {
		return proId;
	}
	public void setProId(Integer proId) {
		this.proId = proId;
	}
	public Integer getFgiNumber() {
		return fgiNumber;
	}
	public void setFgiNumber(Integer fgiNumber) {
		this.fgiNumber = fgiNumber;
	}
	public Integer getFgiMax() {
		return fgiMax;
	}
	public void setFgiMax(Integer fgiMax) {
		this.fgiMax = fgiMax;
	}
	public Integer getWarId() {
		return warId;
	}
	public void setWarId(Integer warId) {
		this.warId = warId;
	}
}
