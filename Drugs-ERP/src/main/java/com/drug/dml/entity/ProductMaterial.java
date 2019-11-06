package com.drug.dml.entity;

import org.springframework.stereotype.Component;

/**
 * 产品原材料实体类、供应商实体类
 * @author Administrator
 *
 */
@Component
public class ProductMaterial {

	private Integer materialId; 	   		// 原材料主键
	private String materialName; 	    	// 原材料名字
	private String materialStandard; 		// 计量单位
	private Integer supplierInfoId;			// 供应商外键
	private Integer materialVaild;			// 有效期
	private Double materialPrice;			// 价格
	private Integer visibles;	          	// 是否显示（1为默认 2不显示）
	private Integer warId;			   		// 仓库ID 外键 Warehouse_主键
	private String materialOne;		   		// 预留字段
	private Integer miNumber;				// 库存数量
	private Integer supplierId;				// 供应商ID
	private String supplierClassify; 		// 供应商分类
	private String supplierName; 			// 供应商名称
	private String supplierContact;			// 供应商联系电话
	private String supplierSite;			// 公司地址
	private String importTime;				// 导入时间
	private Integer prdId;					// 配方详情表Id
	private Integer rawMaterrialId;			// 外键	原材料表Id
	private Integer recipeId;				// 外键	配方表主键
	private Integer realityDosage;			// 毛用量
	private Integer trueDosage;				// 净用量
	private String Unit;					// 单位 g
	private String recipeDetailDes;			// 备注
	private String recipeStatues;			// 配方审核状态
	private Integer createEmpId;			// 配方审核人ID
	
	public Integer getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Integer materialId) {
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

	public Integer getSupplierInfoId() {
		return supplierInfoId;
	}

	public void setSupplierInfoId(Integer supplierInfoId) {
		this.supplierInfoId = supplierInfoId;
	}

	public Integer getMaterialVaild() {
		return materialVaild;
	}

	public void setMaterialVaild(Integer materialVaild) {
		this.materialVaild = materialVaild;
	}

	public Double getMaterialPrice() {
		return materialPrice;
	}

	public void setMaterialPrice(Double materialPrice) {
		this.materialPrice = materialPrice;
	}

	public Integer getVisibles() {
		return visibles;
	}

	public void setVisibles(Integer visibles) {
		this.visibles = visibles;
	}

	public Integer getWarId() {
		return warId;
	}

	public void setWarId(Integer warId) {
		this.warId = warId;
	}

	public String getMaterialOne() {
		return materialOne;
	}

	public void setMaterialOne(String materialOne) {
		this.materialOne = materialOne;
	}

	public Integer getMiNumber() {
		return miNumber;
	}

	public void setMiNumber(Integer miNumber) {
		this.miNumber = miNumber;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
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

	public Integer getPrdId() {
		return prdId;
	}

	public void setPrdId(Integer prdId) {
		this.prdId = prdId;
	}

	public Integer getRawMaterrialId() {
		return rawMaterrialId;
	}

	public void setRawMaterrialId(Integer rawMaterrialId) {
		this.rawMaterrialId = rawMaterrialId;
	}

	public Integer getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(Integer recipeId) {
		this.recipeId = recipeId;
	}

	public Integer getRealityDosage() {
		return realityDosage;
	}

	public void setRealityDosage(Integer realityDosage) {
		this.realityDosage = realityDosage;
	}

	public Integer getTrueDosage() {
		return trueDosage;
	}

	public void setTrueDosage(Integer trueDosage) {
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

	public Integer getCreateEmpId() {
		return createEmpId;
	}

	public void setCreateEmpId(Integer createEmpId) {
		this.createEmpId = createEmpId;
	}

	public ProductMaterial() {
		super();
	}
	
	
}
