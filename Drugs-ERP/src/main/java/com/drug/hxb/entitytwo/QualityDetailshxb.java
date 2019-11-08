package com.drug.hxb.entitytwo;
/**
 * 描述:入库单实体类
 * @author hxb
 * @datetime 2019年11月5日下午10:57:28
 * @version 1.0
 */
public class QualityDetailshxb {
	private int proId;				//药品ID
	private int podId;				//
	private int orderId;			//订单ID
	private String qualitystatus;	//质检状态
	private String statusMan;		//质检人
	private String statustime;		//质检时间
	private String chineseName;		//药品名
	private String packaging;		//包装
	private double retailPrice;		//价格
	private int finishNumber;		//订单数量
	private int productionQuantity;			//药品明细数量
	private int produceMoney;		//订单金额
	
	private int warId;				//仓库ID
	private int employeeId;			//管理员ID
	private int fpsId;				//成品入库单
	private String fpsTime;			//入库时间
	private String remark;			//备注
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public int getPodId() {
		return podId;
	}
	public void setPodId(int podId) {
		this.podId = podId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getQualitystatus() {
		return qualitystatus;
	}
	public void setQualitystatus(String qualitystatus) {
		this.qualitystatus = qualitystatus;
	}
	public String getStatusMan() {
		return statusMan;
	}
	public void setStatusMan(String statusMan) {
		this.statusMan = statusMan;
	}
	public String getStatustime() {
		return statustime;
	}
	public void setStatustime(String statustime) {
		this.statustime = statustime;
	}
	public String getChineseName() {
		return chineseName;
	}
	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	public String getPackaging() {
		return packaging;
	}
	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}
	public double getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}
	public int getFinishNumber() {
		return finishNumber;
	}
	public void setFinishNumber(int finishNumber) {
		this.finishNumber = finishNumber;
	}
	public int getWarId() {
		return warId;
	}
	public void setWarId(int warId) {
		this.warId = warId;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFpsTime() {
		return fpsTime;
	}
	public void setFpsTime(String fpsTime) {
		this.fpsTime = fpsTime;
	}
	public int getFpsId() {
		return fpsId;
	}
	public void setFpsId(int fpsId) {
		this.fpsId = fpsId;
	}
	public int getProductionQuantity() {
		return productionQuantity;
	}
	public void setProductionQuantity(int productionQuantity) {
		this.productionQuantity = productionQuantity;
	}
	public int getProduceMoney() {
		return produceMoney;
	}
	public void setProduceMoney(int produceMoney) {
		this.produceMoney = produceMoney;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
