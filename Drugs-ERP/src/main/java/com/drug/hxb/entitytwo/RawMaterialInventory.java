package com.drug.hxb.entitytwo;

import org.springframework.stereotype.Component;

/**
 * @描述:原料库存查询结果实体类 
 *  @author hxb
 *	@datetime 2019年10月30日上午9:50:22
 * 	@version: 1.0
 */
@Component
public class RawMaterialInventory {
	/**
	 * 原材料主键
	 */
	private int materialId; 	   		
	/**
	 * 原材料名字
	 */
	private String materialName; 	    
	/**
	 * 计量单位
	 */
	private String materialStandard; 	
	/**
	 * 供应商外键
	 */
	private int supplierInfoId;			
	/**
	 * 有效期
	 */
	private int materialVaild;			
	/**
	 * 采购价
	 */
	private double materialPrice;		 
	/**
	 * 是否显示（1为默认 2不显示）
	 */
	private int visibles;	          	
	/**
	 * 仓库ID 外键 Warehouse_主键
	 */
	private int warId;			   		
	/**
	 * 仓库名称
	 */
	private String warName;				
	/**
	 * 预留字段
	 */
	private String materialOne;		    
	/**
	 * 库存数量
	 */
	private int miNumber;				
	/**
	 * 最大库存数量
	 */
	private int miMax;				
	/**
	 * 供应商ID
	 */
	private int supplierId;				
	/**
	 * 供应商名称
	 */
	private String supplierName;        
	public int getMaterialId() {
		return materialId;
	}
	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public String getMaterialStandard() {
		return materialStandard;
	}
	public void setMaterialStandard(String materialStandard) {
		this.materialStandard = materialStandard;
	}
	public int getSupplierInfoId() {
		return supplierInfoId;
	}
	public void setSupplierInfoId(int supplierInfoId) {
		this.supplierInfoId = supplierInfoId;
	}
	public int getMaterialVaild() {
		return materialVaild;
	}
	public void setMaterialVaild(int materialVaild) {
		this.materialVaild = materialVaild;
	}
	public double getMaterialPrice() {
		return materialPrice;
	}
	public void setMaterialPrice(double materialPrice) {
		this.materialPrice = materialPrice;
	}
	public int getVisibles() {
		return visibles;
	}
	public void setVisibles(int visibles) {
		this.visibles = visibles;
	}
	public int getWarId() {
		return warId;
	}
	public void setWarId(int warId) {
		this.warId = warId;
	}
	public String getWarName() {
		return warName;
	}
	public void setWarName(String warName) {
		this.warName = warName;
	}
	public String getMaterialOne() {
		return materialOne;
	}
	public void setMaterialOne(String materialOne) {
		this.materialOne = materialOne;
	}
	public int getMiNumber() {
		return miNumber;
	}
	public void setMiNumber(int miNumber) {
		this.miNumber = miNumber;
	}
	
	public int getMiMax() {
		return miMax;
	}
	public void setMiMax(int miMax) {
		this.miMax = miMax;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	
}
