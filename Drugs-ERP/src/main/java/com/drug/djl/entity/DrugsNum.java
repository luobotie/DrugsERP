package com.drug.djl.entity;

import org.springframework.stereotype.Component;

/**
 * 
 * 描述:发送给分店的药品名称及数量
 * @author djl
 * 2019年11月6日上午9:55:43
 * version:1.0
 */
@Component
public class DrugsNum {
	private String chineseName;//药品名称
	private int fginumber;//药品数量
	public String getChineseName() {
		return chineseName;
	}
	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	public int getFginumber() {
		return fginumber;
	}
	public void setFginumber(int fginumber) {
		this.fginumber = fginumber;
	}
	
}
