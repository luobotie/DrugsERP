package com.drug.dml.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drug.dml.biz.ProductBiz;
import com.drug.dml.entity.DrugsMonthPlan;
import com.drug.dml.entity.PlanDetails;
import com.drug.dml.entity.ProductImage;
import com.drug.dml.entity.ProductInfo;
import com.drug.dml.entity.ProductMaterial;
import com.drug.dml.entity.ProductType;

@RestController
public class ProductController {

	@Autowired
	private ProductBiz productBiz;
	
	@RequestMapping("/getAllProduct.do")
	public Map<String, Object> getAllProduct(Integer page,Integer limit){
		//分页查询
		List<ProductInfo> list = productBiz.selectProuctInfo(page, limit);
		//查询获取月计划总数
		int count = productBiz.countAllProduct();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("code", 0);
		map.put("count", count);
		map.put("data", list);
		return map;
	}
	
	@RequestMapping("/getMaterialName.do")
	public List<ProductMaterial> getMaterialName(){
		//查询原材料表返回所有的原材料名
		List<ProductMaterial> list = productBiz.selectProductMaterial();
		return list;
	}
	
	@RequestMapping("/getSuppliere.do")
	public List<ProductMaterial> getSuppliere(){
		//查询供应商表返回所有的供应商名
		List<ProductMaterial> list = productBiz.selectSupplier();
		return list;
	}
	
	@RequestMapping("/getThisProductMaterial.do")
	public List<ProductMaterial> getThisProductMaterial(Integer proId){
		//查询供应商表返回所有的供应商名
		List<ProductMaterial> list = productBiz.selectThisProductMaterial(proId);
		return list;
	}
	
	/**
	 * 查询指定产品的配方
	 * @param proId
	 * @return map
	 */
	@RequestMapping("/selectThisProductMaterial.do")
	public Map<String, Object> selectThisProductMaterial(Integer proId){
		List<ProductMaterial> list = productBiz.selectThisProductMaterial(proId);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("code", 0);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 新增配方详情(结合原材料表)
	 * @param productMaterial
	 * @param proId
	 * @return count
	 */
	@RequestMapping("/insertProductMaterial.do")
	public int insertProductMaterial(ProductMaterial productMaterial,Integer proId){
		//此处要进行判断,配方表是否存在
		int recipeId = productBiz.selectRecipeId(proId);
		int rawMaterrialId = productMaterial.getMaterialId();
		System.out.println(rawMaterrialId);
		int count = productBiz.insertProductMaterial(rawMaterrialId,recipeId);
		return count;
	}
	
	@RequestMapping("/deleteProductMaterialByPrdId.do")
	public int deleteProductMaterialByPrdId(Integer prdId){
		int count = productBiz.deleteProductMaterialByPrdId(prdId);
		return count;
	}
	
	@RequestMapping("/updateProductInfo.do")
	public int updateProductInfo(ProductInfo productInfo){
		int count = productBiz.updateProductInfo(productInfo);
		return count;
	}
	
	
	/**
	 * 下拉框赋值(药品图片)
	 * @return list
	 */
	@RequestMapping("/selectProImage.do")
	public List<ProductImage> selectProImage(){
		//查询图片表返回所有的图片
		List<ProductImage> list = productBiz.selectProImage();
		return list;
	}
	
	/**
	 * 下拉框赋值(药品图片)
	 * @return list
	 */
	@RequestMapping("/selectProType.do")
	public List<ProductType> selectProType(){
		//查询产品类型表返回所有的产品类型
		List<ProductType> list = productBiz.selectProType();
		return list;
	}
	
	
	
	
	
	
}
