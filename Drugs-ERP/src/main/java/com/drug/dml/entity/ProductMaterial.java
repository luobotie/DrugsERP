package com.drug.dml.entity;

import org.springframework.stereotype.Component;

/**
 * 产品原材料实体类、供应商实体类
 * @author Administrator
 *
 */
@Component
public class ProductMaterial {

	private int materialId; 	   		// 原材料主键
	private String materialName; 	    // 原材料名字
	private String materialStandard; 	// 计量单位
	private int supplierInfoId;			// 供应商外键
	private int materialVaild;			// 有效期
	private double materialPrice;		// 价格
	private int visibles;	          	// 是否显示（1为默认 2不显示）
	private int warId;			   		// 仓库ID 外键 Warehouse_主键
	private String materialOne;		   	// 预留字段
	private int miNumber;				// 库存数量
	private int supplierId;				// 供应商ID
	private String supplierClassify; 	// 供应商分类
	private String supplierName; 		// 供应商名称
	private String supplierContact;		// 供应商联系电话
	private String supplierSite;		// 公司地址
	private String importTime;			// 导入时间
	private int prdId;					// 配方详情表Id
	private int rawMaterrialId;			// 外键	原材料表Id
	private int recipeId;				// 外键	配方表主键
	private int realityDosage;			// 毛用量
	private int trueDosage;				// 净用量
	private String Unit;				// 单位 g
	private String recipeDetailDes;		// 备注
	private String recipeStatues;		// 配方审核状态
	private int createEmpId;			// 配方审核人ID
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
	
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierClassify() {
		return supplierClassify;
	}
	public void setSupplierClassify(String supplierClassify) {
		this.supplierClassify = supplierClassify;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierContact() {
		return supplierContact;
	}
	public void setSupplierContact(String supplierContact) {
		this.supplierContact = supplierContact;
	}
	public String getSupplierSite() {
		return supplierSite;
	}
	public void setSupplierSite(String supplierSite) {
		this.supplierSite = supplierSite;
	}
	public String getImportTime() {
		return importTime;
	}
	public void setImportTime(String importTime) {
		this.importTime = importTime;
	}
	public int getPrdId() {
		return prdId;
	}
	public void setPrdId(int prdId) {
		this.prdId = prdId;
	}
	public int getRawMaterrialId() {
		return rawMaterrialId;
	}
	public void setRawMaterrialId(int rawMaterrialId) {
		this.rawMaterrialId = rawMaterrialId;
	}
	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public int getRealityDosage() {
		return realityDosage;
	}
	public void setRealityDosage(int realityDosage) {
		this.realityDosage = realityDosage;
	}
	public int getTrueDosage() {
		return trueDosage;
	}
	public void setTrueDosage(int trueDosage) {
		this.trueDosage = trueDosage;
	}
	public String getUnit() {
		return Unit;
	}
	public void setUnit(String unit) {
		Unit = unit;
	}
	public String getRecipeDetailDes() {
		return recipeDetailDes;
	}
	public void setRecipeDetailDes(String recipeDetailDes) {
		this.recipeDetailDes = recipeDetailDes;
	}
	public String getRecipeStatues() {
		return recipeStatues;
	}
	public void setRecipeStatues(String recipeStatues) {
		this.recipeStatues = recipeStatues;
	}
	public int getCreateEmpId() {
		return createEmpId;
	}
	public void setCreateEmpId(int createEmpId) {
		this.createEmpId = createEmpId;
	}
	public ProductMaterial() {
		super();
	}
	
	
}
