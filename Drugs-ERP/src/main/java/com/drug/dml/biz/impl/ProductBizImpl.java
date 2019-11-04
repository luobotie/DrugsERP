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
	public Integer insertProduct(ProductInfo productInfo) {
		return productMapper.insertProduct(productInfo);
	}

	@Override
	public List<ProductImage> selectProImage() {
		return productMapper.selectProImage();
	}

	@Override
	public List<ProductType> selectProType() {
		return productMapper.selectProType();
	}

	@Override
	public Integer insertProductRecipe(String recipeName) {
		return productMapper.insertProductRecipe(recipeName);
	}

	@Override
	public Integer seletctProductRecipeTop() {
		return productMapper.seletctProductRecipeTop();
	}

	@Override
	public Integer updateProductByProId(Integer recipeId,Integer proId) {
		return productMapper.updateProductByProId(recipeId,proId);
	}

	@Override
	public Integer seletctProductInfoTop() {
		return productMapper.seletctProductInfoTop();
	}

	@Override
	public Integer updateProduct(String proStaData, Integer proId) {
		return productMapper.updateProduct(proStaData, proId);
	}

	@Override
	public Integer updateProductRecipeStatues(Integer recipeId) {
		return productMapper.updateProductRecipeStatues(recipeId);
	}

	@Override
	public Integer updateProductRecipeStatuesAgain(Integer recipeId) {
		return productMapper.updateProductRecipeStatuesAgain(recipeId);
	}

	@Override
	public Integer selectRecipeIdByProId(Integer proId) {
		return productMapper.selectRecipeIdByProId(proId);
	}

	@Override
	public Integer selectRecipeIdByPrdId(Integer prdId) {
		return productMapper.selectRecipeIdByPrdId(prdId);
	}
	
	
}
