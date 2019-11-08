package com.drug.hxb.entitytwo;
/**
 * 描述:质检单实体类
 * @author hxb
 * @datetime 2019年11月5日下午10:47:03
 * @version 1.0
 */
public class Quality {
	/**
	 * 生产订单ID
	 */
	private int orderId;
	/**
	 * 质检单ID
	 */
	private int podId;
	/**
	 * 成品ID
	 */
	private int proId;
	/**
	 * 质检状态
	 */
	private String qualitystatus;
	/**
	 * 质检人
	 */
	private String statusMan;
	/**
	 * 质检时间
	 */
	private String statusTime;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getPodId() {
		return podId;
	}
	public void setPodId(int podId) {
		this.podId = podId;
	}
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
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
	public String getStatusTime() {
		return statusTime;
	}
	public void setStatusTime(String statusTime) {
		this.statusTime = statusTime;
	}
	
	
}
