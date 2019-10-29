package com.drug.dml.entity;

import org.springframework.stereotype.Component;

/**
 * 下拉框动态赋值实体类、产品表、配方表实体类
 * @author dml
 */
@Component
public class ProductInfo {
	private int proId;				// 药品id
	private String chineseName;		// 药品名称
	private int expirationdate;		// 保质期
	private int hqtId;				// 外键	生产厂家id(总店外键)
	private String specification;	// 规格（g）
	private String proImage;		// 成品外观图片
	private String proRecipe;		// 药品有无配方
	private double retailPrice;		// 销售价
	private String statues;  		// 药品审核状态
	private int visibles;			// 显示状态
	private int proTypeId;			// 外键	成品类型表Id
	private int recipeId;			// 外键	配方表id
	private String proDate;			// 药品制定时间
	private int proMan;				// 药品制定人
	private String recipeStatues;   // 配方审核状态
	private String createDate;		// 配方制定时间
	private int createEmpId;		// 配方制定人
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getChineseName() {
		return chineseName;
	}
	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	
	public int getExpirationdate() {
		return expirationdate;
	}
	public void setExpirationdate(int expirationdate) {
		this.expirationdate = expirationdate;
	}
	public int getHqtId() {
		return hqtId;
	}
	public void setHqtId(int hqtId) {
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
	public double getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}
	public String getStatues() {
		return statues;
	}
	public void setStatues(String statues) {
		this.statues = statues;
	}
	public int getVisibles() {
		return visibles;
	}
	public void setVisibles(int visibles) {
		this.visibles = visibles;
	}
	public int getProTypeId() {
		return proTypeId;
	}
	public void setProTypeId(int proTypeId) {
		this.proTypeId = proTypeId;
	}
	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public String getProDate() {
		return proDate;
	}
	public void setProDate(String proDate) {
		this.proDate = proDate;
	}
	public int getProMan() {
		return proMan;
	}
	public void setProMan(int proMan) {
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
	public int getCreateEmpId() {
		return createEmpId;
	}
	public void setCreateEmpId(int createEmpId) {
		this.createEmpId = createEmpId;
	}
	public ProductInfo(int proId, String chineseName, int expirationdate, int hqtId, String specification,
			String proImage, String proRecipe, double retailPrice, String statues, int visibles, int proTypeId,
			int recipeId, String proDate, int proMan, String recipeStatues, String createDate, int createEmpId) {
		super();
		this.proId = proId;
		this.chineseName = chineseName;
		this.expirationdate = expirationdate;
		this.hqtId = hqtId;
		this.specification = specification;
		this.proImage = proImage;
		this.proRecipe = proRecipe;
		this.retailPrice = retailPrice;
		this.statues = statues;
		this.visibles = visibles;
		this.proTypeId = proTypeId;
		this.recipeId = recipeId;
		this.proDate = proDate;
		this.proMan = proMan;
		this.recipeStatues = recipeStatues;
		this.createDate = createDate;
		this.createEmpId = createEmpId;
	}
	public ProductInfo(int proId, String chineseName) {
		super();
		this.proId = proId;
		this.chineseName = chineseName;
	}
	public ProductInfo() {
		super();
	}
	 
}
