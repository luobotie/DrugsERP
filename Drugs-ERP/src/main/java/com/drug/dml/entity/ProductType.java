package com.drug.dml.entity;

import org.springframework.stereotype.Component;

/**
 * 产品类型实体类
 * @author dml
 */
@Component
public class ProductType {
	private Integer proTypeId;				// 主键
	private String proTypeName;			// 类型名称
	private String productTypeDes;		// 描述
	private String Visibles;			// 显示状态
	
	public Integer getProTypeId() {
		return proTypeId;
	}

	public void setProTypeId(Integer proTypeId) {
		this.proTypeId = proTypeId;
	}

	public String getProTypeName() {
		return proTypeName;
	}

	public void setProTypeName(String proTypeName) {
		this.proTypeName = proTypeName;
	}

	public String getProductTypeDes() {
		return productTypeDes;
	}

	public void setProductTypeDes(String productTypeDes) {
		this.productTypeDes = productTypeDes;
	}

	public String getVisibles() {
		return Visibles;
	}

	public void setVisibles(String visibles) {
		Visibles = visibles;
	}

	public ProductType() {
		super();
	}
	
}
