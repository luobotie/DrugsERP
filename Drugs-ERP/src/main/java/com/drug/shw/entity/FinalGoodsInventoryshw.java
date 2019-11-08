package com.drug.shw.entity;

public class FinalGoodsInventoryshw {
private Integer  proId;
private Integer fgiNumber;
private String chineseName;
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
public String getChineseName() {
	return chineseName;
}
public void setChineseName(String chineseName) {
	this.chineseName = chineseName;
}
public FinalGoodsInventoryshw(Integer proId, Integer fgiNumber, String chineseName) {
	super();
	this.proId = proId;
	this.fgiNumber = fgiNumber;
	this.chineseName = chineseName;
}
public FinalGoodsInventoryshw() {
	super();
}

}
