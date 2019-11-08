package com.drug.hxb.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import com.drug.dml.entity.ProductMaterial;

/**
 * @说明:原料库存表
 * @author hxb
 * @datetime 2019年10月21日上午11:01:33
 * @version 1.0
 */
@Component
public class MaterialInventory {
	/**
	 * 原料表id 外键
	 */
	private Integer materialId;
	/**
	 * 库存数量
	 */
	private Integer miNumber;
	/**
	 * 最大库存数量
	 */
	private Integer miMax;
	/**
	 * 仓库id
	 */
	private Integer warId;
	
	public Integer getMaterialId() {
		return materialId;
	}
	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}
	public Integer getMiNumber() {
		return miNumber;
	}
	public void setMiNumber(Integer miNumber) {
		this.miNumber = miNumber;
	}
	public Integer getMiMax() {
		return miMax;
	}
	public void setMiMax(Integer miMax) {
		this.miMax = miMax;
	}
	public Integer getWarId() {
		return warId;
	}
	public void setWarId(Integer warId) {
		this.warId = warId;
	}
}
