package com.drug.dml.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.drug.dml.entity.CheckProduct;

@Repository
public interface CheckProductMapper {
	
	/**
	 * 分页查询所有质检单
	 * @param pageno   当前页数
	 * @param pageSize 每页显示数
	 * @return List<CheckProduct> 
	 */
	@Select("SELECT * FROM check_Product limit #{pageno},#{pageSize}")
	List<CheckProduct> selectAllCheckProduct(@Param("pageno")Integer pageno,@Param("pageSize")Integer pageSize);
	
	/**
	 * 得到所有质检单数量
	 * @return Integer
	 */
	@Select("select count(*) from check_Product")
	Integer countCheckProduct();
	
	/**
	 * 查看指定质检单的详情
	 * @return List<CheckProduct>
	 */
	@Select("SELECT d_p.`dailyPlanid`,p_i.`proId`,p_i.`chineseName`,d_p_d.`productionQuantity`,d_p_d.`daypracticalQuantity` FROM check_Product AS c_p "
			+"JOIN orderproduct AS o_p "
			+"ON c_p.`orderId` = o_p.`orderId` "
			+"JOIN Dailyplan AS d_p "				
			+"ON o_p.`dayPlanId` = d_p.`dailyPlanid` "	
			+"JOIN dailyPlanDetails AS d_p_d "		
			+"ON d_p.`dailyPlanid` = d_p_d.`dpId` "	
			+"JOIN product_Info AS p_i "	
			+"ON p_i.`proId` = d_p_d.`proId` "	
			/*+"JOIN product_Recipe AS p_r "		
			+"ON p_r.`recipeId` = p_i.`recipeId` "	
			+"JOIN product_Recipe_Details AS p_r_d	"
			+"ON p_r_d.`recipeId`= p_r.`recipeId` "	
			+"JOIN material_Info AS m_i	"	
			+"ON m_i.materialId = p_r_d.`rawMaterrialId` "*/		
			+"WHERE c_p.`podId` = #{podId}")
	List<CheckProduct> getThisCheckProductInfo(Integer podId);
	
	/**
	 * 修改质检状态
	 * @param checkProduct 质检实体类
	 * @return Integer
	 */
	@Update("update check_Product set qualitystatus = #{qualitystatus},statusMan = 1,statustime = #{statustime} where podId = #{podId}")
	Integer updateThisCheckProductStatus(CheckProduct checkProduct);
	
	/**
	 * 删除指定质检单
	 * @param podId
	 * @return Integer
	 */
	@Delete("delete from check_Product where podId = #{podId}")
	Integer deleteCheckProductByPodId(Integer podId);
	
	/**
	 * 模糊查询
	 * @param qualitystatus 质检状态
	 * @param pageno		当前页数
	 * @param pageSize		每页显示数
	 * @return List<CheckProduct>
	 */
	@Select("SELECT * FROM check_Product WHERE qualitystatus = #{qualitystatus} limit #{pageno},#{pageSize}")
	List<CheckProduct> getCheckProductWithStatus(@Param("qualitystatus")String qualitystatus,@Param("pageno")Integer pageno,@Param("pageSize")Integer pageSize);
	
	/**
	 * 查询指定状态的质检单数量
	 * @param qualitystatus  质检状态
	 * @return Integer
	 */
	@Select("select count(*) from check_Product where qualitystatus = #{qualitystatus}")
	Integer countCheckProductWithStatus(String qualitystatus);
	
	/**
	 * 修改实际生产数量
	 * @param checkProduct 质检实体类
	 * @return Integer
	 */
	@Update("UPDATE dailyPlanDetails SET daypracticalQuantity = #{daypracticalQuantity} WHERE dpId = #{dpId} AND proId = #{proId}")
	Integer updateRealNum(CheckProduct checkProduct);
	
	/**
	 * 查询实际数量总和
	 * @param checkProduct
	 * @return
	 */
	@Select("SELECT SUM(daypracticalQuantity) FROM dailyPlanDetails WHERE dpId = #{dpId}")
	Integer getDayPracticalQuantitySum(CheckProduct checkProduct);
	
	@Update("update orderproduct set finishNumber = #{finishNumber} where dayPlanId= #{dayPlanId}")
	Integer updateFinishNumber(@Param("finishNumber")Integer sum,@Param("dayPlanId")Integer dpId);
}
