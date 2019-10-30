package com.drug.dml.biz;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.drug.dml.entity.ProductImage;
import com.drug.dml.entity.ProductInfo;
import com.drug.dml.entity.ProductMaterial;
import com.drug.dml.entity.ProductType;

@Repository
public interface ProductBiz {

	List<ProductInfo> selectProuctInfo(Integer page,Integer limit);
	
	Integer countAllProduct();
	
	List<ProductMaterial> selectProductMaterial();
	
	List<ProductMaterial> selectSupplier();
	
	List<ProductMaterial> selectThisProductMaterial(Integer proId);
	
	Integer selectRecipeId(Integer proId);
	
	Integer insertProductMaterial(Integer rawMaterrialId,Integer recipeId);
	
	Integer deleteProductMaterialByPrdId(Integer prdId);
	
	Integer updateProductInfo(ProductInfo productInfo);
	
	Integer insertProduct();
	
	List<ProductImage> selectProImage();
	
	List<ProductType> selectProType();
}
