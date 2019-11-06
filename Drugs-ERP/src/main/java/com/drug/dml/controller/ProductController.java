package com.drug.dml.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	/**
	 * 分页查询产品
	 * @param page  当前页数
	 * @param limit 每页显示数
	 * @return map
	 */
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
	
	/**
	 * 下拉框取值(原材料名)
	 * @return list
	 */
	@RequestMapping("/getMaterialName.do")
	public List<ProductMaterial> getMaterialName(){
		//查询原材料表返回所有的原材料名
		List<ProductMaterial> list = productBiz.selectProductMaterial();
		return list;
	}
	
	/**
	 * 下拉框取值(供应商)
	 * @return list
	 */
	@RequestMapping("/getSuppliere.do")
	public List<ProductMaterial> getSuppliere(){
		//查询供应商表返回所有的供应商名
		List<ProductMaterial> list = productBiz.selectSupplier();
		return list;
	}
	
	/**
	 * 得到指定产品的配方详情
	 * @param proId 产品ID
	 * @return list
	 */
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
		System.out.println("产品表id"+proId);
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
		//添加产品后的配方表ID值为0,新增一个配方表(),倒序获得最新配方表ID,然后添加原材料(在配方详情表中),
		//倒序查询配方表第一个ID
		int recipeId = productBiz.selectRecipeIdByProId(proId);
		System.out.println("配方表ID:"+recipeId);
		int rawMaterrialId = productMaterial.getMaterialId();
		int count = productBiz.insertProductMaterial(rawMaterrialId,recipeId);
		productBiz.updateProductRecipeStatuesAgain(recipeId);
		return count;
	}
	
	/**
	 * 根据配方详情表ID删除配方详情
	 * @param prdId 配方详情表ID
	 * @return count
	 */
	@RequestMapping("/deleteProductMaterialByPrdId.do")
	public int deleteProductMaterialByPrdId(Integer prdId){
		int recipeId = productBiz.selectRecipeIdByPrdId(prdId);
		int count = productBiz.deleteProductMaterialByPrdId(prdId);
		System.out.println(recipeId);
		/*//查询指定产品的配方
		int recipeId = productBiz.selectRecipeId(proId);*/
		//修改配方审核状态(删除某一个配方详情后)
		productBiz.updateProductRecipeStatuesAgain(recipeId);
		System.out.println("进来了...");
		return count;
	}
	
	/**
	 * 修改产品信息
	 * @param productInfo
	 * @return count
	 */
	@RequestMapping("/updateProductInfo.do")
	public int updateProductInfo(ProductInfo productInfo){
		int count = productBiz.updateProductInfo(productInfo);
		return count;
	}
	
	/**
	 * 新增产品
	 * @param productInfo
	 * @return count
	 */
	@RequestMapping("/insertProduct.do")
	public int insertProduct(ProductInfo productInfo){
		//获取产品名从而作为配方名
		String recipeName = productInfo.getChineseName();
		//新增产品
		int count = productBiz.insertProduct(productInfo);
		//新增配方
		productBiz.insertProductRecipe(recipeName);
		int proId = productBiz.seletctProductInfoTop();
		System.out.println("倒序查询出的产品表ID:"+proId);
		//倒序查询配方表第一个ID
		int recipeId = productBiz.seletctProductRecipeTop();
		System.out.println("倒序查询出的配方表ID:"+recipeId);
		productBiz.updateProductByProId(recipeId,proId);
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
	 * 下拉框赋值(药品类型)
	 * @return list
	 */
	@RequestMapping("/selectProType.do")
	public List<ProductType> selectProType(){
		//查询产品类型表返回所有的产品类型
		List<ProductType> list = productBiz.selectProType();
		return list;
	}
	
	
	/**
	 * 修改产品审核状态及审核时间
	 * @param proStaData 产品审核时间
	 * @param proId 产品ID
	 * @return count
	 */
	@RequestMapping("/updateProductStatues.do")
	public int updateProductStatues(String proStaData, Integer proId){
		int count = productBiz.updateProduct(proStaData,proId);
		return count;
	}
	
	/**
	 * 修改配方审核状态 
	 * @param proId 产品ID
	 * @param recipeId 配方ID
	 * @return count
	 */
	@RequestMapping("/updateProductRecipeStatues.do")
	public int updateProductRecipeStatues(Integer proId){
		//查询指定产品的配方
		int recipeId = productBiz.selectRecipeId(proId);
		int count = productBiz.updateProductRecipeStatues(recipeId);
		return count;
	}
	
	
	
	
	
}
