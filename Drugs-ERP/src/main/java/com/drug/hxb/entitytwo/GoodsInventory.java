package com.drug.hxb.entitytwo;
/**
 * 描述:成品库存查询实体类
 * @author hxb
 * @datetime 2019年11月4日下午3:15:14
 * @version 1.0
 */
public class GoodsInventory {
	private int warId;              //仓库ID
	private String warName;         //仓库名
	private int fgiNumber;			//库存数量
	private int fgiMax;				//最大数量
	private String proTypeName;		//药品类别
	
	private String packaging;		//包装
	private int proId;				// 药品id
	private String chineseName;		// 药品名称
	private int expirationdate;		// 保质期
	private String specification;	// 规格（g）
	private String proImage;		// 成品外观图片
	private String proRecipe;		// 药品有无配方
	private double costPice;		// 成本价
	private double retailPrice;		// 销售价
	private String statues;  		// 药品审核状态
	private int proTypeId;			// 外键	成品类型表Id
	private int recipeId;			// 外键	配方表id
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
	public int getFgiNumber() {
		return fgiNumber;
	}
	public void setFgiNumber(int fgiNumber) {
		this.fgiNumber = fgiNumber;
	}
	public int getFgiMax() {
		return fgiMax;
	}
	public void setFgiMax(int fgiMax) {
		this.fgiMax = fgiMax;
	}
	public String getProTypeName() {
		return proTypeName;
	}
	public void setProTypeName(String proTypeName) {
		this.proTypeName = proTypeName;
	}
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
	
	public double getCostPice() {
		return costPice;
	}
	public void setCostPice(double costPice) {
		this.costPice = costPice;
	}
	public String getPackaging() {
		return packaging;
	}
	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}
	
	
}
