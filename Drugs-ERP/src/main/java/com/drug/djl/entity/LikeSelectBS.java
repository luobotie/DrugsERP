package com.drug.djl.entity;

import org.springframework.stereotype.Component;

/**
 * 
 * 描述:分店信息查询的模糊查询实体类
 * @author djl
 * 2019年11月4日上午9:03:23
 * version:1.0
 */
@Component
public class LikeSelectBS {
	private String bsName;//分店名称
	private String bslocationPro ;// 所在省
	private String bslocationCity ;//所在市
	private String bsopendate; //开业时
	private Integer page;//分页查询的当前页
	private Integer limit;//每页显示数
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public String getBsName() {
		return bsName;
	}
	public void setBsName(String bsName) {
		this.bsName = bsName;
	}
	public String getBslocationPro() {
		return bslocationPro;
	}
	public void setBslocationPro(String bslocationPro) {
		this.bslocationPro = bslocationPro;
	}
	public String getBslocationCity() {
		return bslocationCity;
	}
	public void setBslocationCity(String bslocationCity) {
		this.bslocationCity = bslocationCity;
	}
	public String getBsopendate() {
		return bsopendate;
	}
	public void setBsopendate(String bsopendate) {
		this.bsopendate = bsopendate;
	}
	
	
}
