package com.drug.hxb.entity;

import org.springframework.stereotype.Component;

/**
 * @说明:废料库存表
 * @author hxb
 * @datetime 2019年10月21日上午11:10:21
 * @version 1.0
 */
@Component
public class WasteInventory {
	/**
	 * 废料id
	 */
	private Integer wasteId;
	/**
	 * 库存数量
	 */
	private Integer wiNumber;
	/**
	 * 最大数量
	 */
	private Integer wiMax;
	/**
	 * 仓库id
	 */
	private Integer warId;
	/**
	 * 仓库对象
	 */
	private Warehouse warehouse;
	
	
	public Integer getWasteId() {
		return wasteId;
	}
	public void setWasteId(Integer wasteId) {
		this.wasteId = wasteId;
	}
	public Integer getWiNumber() {
		return wiNumber;
	}
	public void setWiNumber(Integer wiNumber) {
		this.wiNumber = wiNumber;
	}
	public Integer getWiMax() {
		return wiMax;
	}
	public void setWiMax(Integer wiMax) {
		this.wiMax = wiMax;
	}
	public Integer getWarId() {
		return warId;
	}
	public void setWarId(Integer warId) {
		this.warId = warId;
	}
	public Warehouse getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	
	
}
