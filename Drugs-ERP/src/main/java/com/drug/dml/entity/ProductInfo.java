package com.drug.dml.entity;

import org.springframework.stereotype.Component;

/**
 * 下拉框动态赋值实体类、产品表、配方表实体类
 * @author dml
 */
@Component
public class ProductInfo {
	private Integer proId;				// 药品id
	private String chineseName;		// 药品名称
	private String imgName; 		//图片名
	private Integer expirationdate;		// 保质期
	private Integer hqtId;				// 外键	生产厂家id(总店外键)
	private String specification;	// 规格（g）
	private String proImage;		// 成品外观图片
	private String proRecipe;		// 药品有无配方
	private Double retailPrice;		// 销售价
	private String statues;  		// 药品审核状态
	private String proStaData;  		// 药品审核时间
	private Integer visibles;			// 显示状态
	private Integer proTypeId;			// 外键	成品类型表Id
	private Integer recipeId;			// 外键	配方表id
	private String proDate;			// 药品制定时间
	private Integer proMan;				// 药品制定人
	private String recipeStatues;   // 配方审核状态
	private String createDate;		// 配方制定时间
	private Integer createEmpId;		// 配方审核人
	private Integer prdId;			//配方详情ID
	public Integer getProId() {
		return proId;
	}
	public void setProId(Integer proId) {
		this.proId = proId;
	}
	public String getChineseName() {
		return chineseName;
	}
	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public Integer getExpirationdate() {
		return expirationdate;
	}
	public void setExpirationdate(Integer expirationdate) {
		this.expirationdate = expirationdate;
	}
	public Integer getHqtId() {
		return hqtId;
	}
	public void setHqtId(Integer hqtId) {
		this.hqtId = hqtId;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getProImage() {
		return proImage;
	}
	public void setProImage(String proImage) {
		this.proImage = proImage;
	}
	public String getProRecipe() {
		return proRecipe;
	}
	public void setProRecipe(String proRecipe) {
		this.proRecipe = proRecipe;
	}
	public Double getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}
	public String getStatues() {
		return statues;
	}
	public void setStatues(String statues) {
		this.statues = statues;
	}
	public String getProStaData() {
		return proStaData;
	}
	public void setProStaData(String proStaData) {
		this.proStaData = proStaData;
	}
	public Integer getVisibles() {
		return visibles;
	}
	public void setVisibles(Integer visibles) {
		this.visibles = visibles;
	}
	public Integer getProTypeId() {
		return proTypeId;
	}
	public void setProTypeId(Integer proTypeId) {
		this.proTypeId = proTypeId;
	}
	public Integer getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(Integer recipeId) {
		this.recipeId = recipeId;
	}
	public String getProDate() {
		return proDate;
	}
	public void setProDate(String proDate) {
		this.proDate = proDate;
	}
	public Integer getProMan() {
		return proMan;
	}
	public void setProMan(Integer proMan) {
		this.proMan = proMan;
	}
	public String getRecipeStatues() {
		return recipeStatues;
	}
	public void setRecipeStatues(String recipeStatues) {
		this.recipeStatues = recipeStatues;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public Integer getCreateEmpId() {
		return createEmpId;
	}
	public void setCreateEmpId(Integer createEmpId) {
		this.createEmpId = createEmpId;
	}
	public Integer getPrdId() {
		return prdId;
	}
	public void setPrdId(Integer prdId) {
		this.prdId = prdId;
	}
	
}
