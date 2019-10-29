package com.drug.dml.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.dml.biz.ProductBiz;
import com.drug.dml.entity.ProductImage;
import com.drug.dml.entity.ProductInfo;
import com.drug.dml.entity.ProductMaterial;
import com.drug.dml.entity.ProductType;
import com.drug.dml.mapper.ProductMapper;

@Service
public class ProductBizImpl implements ProductBiz{

	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<ProductInfo> selectProuctInfo(Integer page, Integer limit) {
		Integer pageno=(page-1)*limit; 
		return productMapper.selectProuctInfo(pageno,limit);
	}

	@Override
	public Integer countAllProduct() {
		return productMapper.countAllProduct();
	}

	@Override
	public List<ProductMaterial> selectProductMaterial() {
		return productMapper.selectProductMaterial();
	}

	@Override
	public List<ProductMaterial> selectSupplier() {
		return productMapper.selectSupplier();
	}

	@Override
	public List<ProductMaterial> selectThisProductMaterial(Integer proId) {
		return productMapper.selectThisProductMaterial(proId);
	}

	@Override
	public Integer selectRecipeId(Integer proId) {
		return productMapper.selectRecipeId(proId);
	}

	@Override
	public Integer insertProductMaterial(Integer rawMaterrialId,Integer recipeId) {
		return productMapper.insertProductMaterial(rawMaterrialId,recipeId);
	}

	@Override
	public Integer deleteProductMaterialByPrdId(Integer prdId) {
		return productMapper.deleteProductMaterialByPrdId(prdId);
	}

	@Override
	public Integer updateProductInfo(ProductInfo productInfo) {
		return productMapper.updateProductInfo(productInfo);
	}

	@Override
	public Integer insertProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductImage> selectProImage() {
		return productMapper.selectProImage();
	}

	@Override
	public List<ProductType> selectProType() {
		return productMapper.selectProType();
	}
	
	
}
