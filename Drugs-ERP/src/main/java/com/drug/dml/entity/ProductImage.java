package com.drug.dml.entity;

import org.springframework.stereotype.Component;

@Component
public class ProductImage {
	private Integer imgId; 			// 图片主键
	private String imgName;		// 图片名
	private String imgUrl;		// 图片路径
	
	public Integer getImgId() {
		return imgId;
	}

	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public ProductImage() {
		super();
	}
	
}
