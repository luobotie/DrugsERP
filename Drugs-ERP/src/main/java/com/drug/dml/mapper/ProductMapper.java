package com.drug.dml.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.drug.dml.entity.ProductImage;
import com.drug.dml.entity.ProductInfo;
import com.drug.dml.entity.ProductMaterial;
import com.drug.dml.entity.ProductType;

@Repository
public interface ProductMapper {

	/**
	 * 联合查询药品表、配方表
	 * @return List<ProductInfo>
	 */
	@Select("SELECT * FROM product_Info AS p_i "
			+"JOIN product_Recipe AS p_r "
			+"ON p_i.`recipeId` = p_r.`recipeId` "
			/*+"JOIN  product_Recipe_Details AS p_r_d "
			+"ON p_r_d.`recipeId` = p_r.`recipeId` "*/
			+ "limit #{pageno},#{pageSize}")
	List<ProductInfo> selectProuctInfo(@Param("pageno")Integer pageno,@Param("pageSize")Integer pageSize);
	
	/**
	 * 查询产品数量
	 * @return Integer
	 */
	@Select("SELECT COUNT(*) FROM product_Info")
	Integer countAllProduct();
	 
	/**
	 * 下拉框赋值(原料名)
	 * @return List<ProductMaterial>
	 */
	@Select("SELECT materialId,materialName FROM material_Info")
	List<ProductMaterial> selectProductMaterial();
	
	/**
	 * 下拉框赋值(供应商)
	 * @return List<ProductMaterial>
	 */
	@Select("SELECT supplierId,supplierName FROM supplier")
	List<ProductMaterial> selectSupplier();
	
	/**
	 * 查询指定产品的配方详情
	 * @param proId
	 * @return List<ProductMaterial>
	 */
	@Select("SELECT * FROM product_Info AS p_i JOIN product_Recipe AS p_r "
				+"ON p_i.`recipeId` = p_r.`recipeId` "
				+"JOIN product_Recipe_Details AS p_r_d "
				+"ON p_r_d.`recipeId` = p_r.`recipeId` "
				+"JOIN material_Info AS m_i "
				+"ON m_i.materialId = p_r_d.`rawMaterrialId` "
				+"JOIN Material_Inventory AS ma_i "
				+"ON m_i.`materialId` = ma_i.`rawMaterialId` "
				+"JOIN Warehouse AS war "
				+"ON war.`warId` = ma_i.`warId` "
				+"WHERE p_i.`proId` = #{proId}")
	List<ProductMaterial> selectThisProductMaterial(Integer proId);
	
	/**
	 * 查询配方表ID
	 * @return Integer
	 */
	@Select("SELECT p_r.recipeId FROM product_Info AS p_i "
			+"LEFT JOIN product_Recipe AS p_r "
			+"ON p_i.`recipeId` = p_r.`recipeId` WHERE p_i.`proId` = #{proId}")
	Integer selectRecipeId(Integer proId);
	
	/**
	 * 新增配方详情
	 * @param rawMaterrialId 原材料ID
	 * @param recipeId 
	 * @return Integer
	 */
	@Insert("INSERT INTO product_Recipe_Details(rawMaterrialId,recipeId,realityDosage,trueDosage,recipeDetailDes) VALUES(#{rawMaterrialId},#{recipeId},0,0,'')")
	Integer insertProductMaterial(@Param("rawMaterrialId")Integer rawMaterrialId,@Param("recipeId")Integer recipeId);
	
	/**
	 * 根据配方详情ID删除指定配方详情
	 * @param prdId
	 * @return Integer
	 */
	@Delete("DELETE FROM product_Recipe_Details WHERE prdId = #{prdId}")
	Integer deleteProductMaterialByPrdId(Integer prdId);
	
	/**
	 * 修改产品信息
	 * @param productInfo 产品实体类
	 * @return Integer
	 */
	@Update("UPDATE product_Info SET chineseName = #{chineseName},retailPrice = #{retailPrice},proMan = #{proMan},proDate = #{proDate} where proId = #{proId}")
	Integer updateProductInfo(ProductInfo productInfo);
	
	/**
	 * 新增产品
	 * @param productInfo
	 * @return
	 */
	@Insert("INSERT INTO product_Info(chineseName,expirationdate,hqtId,specification,proImage,retailPrice,proTypeId,recipeId,proDate,proMan) VALUES "
			+"(#{chineseName},#{expirationdate},#{hqtId},#{specification},#{proImage},#{retailPrice},#{proTypeId},#{recipeId},#{proDate},#{proMan})")
	Integer insertProduct(ProductInfo productInfo);
	
	/**
	 * 下拉框赋值(药品图片)
	 * @return List<ProductImage>
	 */
	@Select("SELECT imgName,imgUrl FROM productImg")
	List<ProductImage> selectProImage();
	
	/**
	 * 下拉框赋值(药品类型)
	 * @return List<ProductType>
	 */
	@Select("SELECT proTypeId,proTypeName FROM product_Type")
	List<ProductType> selectProType();
	
	/**
	 * 新增配方表
	 * @return Integer
	 */
	@Insert("INSERT INTO product_Recipe(recipeName,createDate,recipeDes) VALUES(#{recipeName},NOW(),'配方')")
	Integer insertProductRecipe(String recipeName);
	
	/**
	 * 倒序查询配方表第一位并返回
	 * @return Integer
	 */
	@Select("SELECT recipeId FROM product_Recipe ORDER BY recipeId DESC LIMIT 1")
	Integer seletctProductRecipeTop();
	
	/**
	 * 根据倒序查询出来的配方表ID 修改产品表的ID
	 * @param proId产品表的ID
	 * @return Integer
	 */
	@Update("UPDATE product_Info SET recipeId = #{recipeId} where  proId = #{proId}")
	Integer updateProductByProId(@Param("recipeId")Integer recipeId,@Param("proId")Integer proId);
	
	/**
	 * 倒序查询产品表第一位并返回
	 * @return Integer
	 */
	@Select("SELECT proId FROM product_Info ORDER BY proId DESC LIMIT 1")
	Integer seletctProductInfoTop();
	
	/**
	 * 修改药品审核状态
	 * @param proStaData 药品审核时间
	 * @param proId	药品ID
	 * @return Integer
	 */
	@Update("UPDATE product_Info SET statues = '已审核',proStaData=#{proStaData} where proId = #{proId}")
	Integer updateProduct(@Param("proStaData")String proStaData,@Param("proId")Integer proId);
	
	/**
	 * 修改配方审核状态
	 * @param recipeId 配方ID
	 * @return Integer
	 */
	@Update("UPDATE product_Recipe SET recipeStatues = '已审核',createEmpId = 1 where recipeId = #{recipeId}")
	Integer updateProductRecipeStatues(Integer recipeId);
	
	/**
	 * 修改配方审核状态(删除某一个配方详情后)
	 * @param recipeId 配方ID
	 * @return Integer
	 */
	@Update("UPDATE product_Recipe SET recipeStatues = '未审核',createEmpId = 0 where recipeId = #{recipeId}")
	Integer updateProductRecipeStatuesAgain(Integer recipeId);
	
	/**
	 * 联合查询根据产品ID找到配方ID
	 * @param proId 产品ID
	 * @return Integer
	 */
	@Select("SELECT p_r.`recipeId` FROM product_Info AS p_i "
			+"JOIN product_Recipe AS p_r "
			+"ON p_i.`recipeId` = p_r.`recipeId` "
			+"WHERE p_i.`proId` = #{proId}")
	Integer selectRecipeIdByProId(Integer proId);
	
	@Select("SELECT recipeId FROM product_Recipe_Details WHERE prdId=#{prdId}")
	Integer selectRecipeIdByPrdId(Integer prdId);
	
	
	
	
	
	
	
	
	
}
