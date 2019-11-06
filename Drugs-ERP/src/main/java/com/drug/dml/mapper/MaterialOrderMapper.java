package com.drug.dml.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.drug.dml.entity.DrugsMonthPlan;
import com.drug.dml.entity.MaterialOrder;

@Repository
public interface MaterialOrderMapper {

	/**
	 * 分页查询所有领料单
	 * @param pageno 当前页数
	 * @param pageSize 每页包含书
	 * @return List<materialOrder> 
	 */
	@Select("select * from materialOrder limit #{pageno},#{pageSize}")
	List<MaterialOrder> selectAllMaterialOrder(@Param("pageno")Integer pageno,@Param("pageSize")Integer pageSize);
	
	/**
	 * 查询所有领料单总数
	 * @return Integer
	 */
	@Select("select count(*) from materialOrder")
	Integer countAllMaterialOrder();
	
	/**
	 * 查询指定领料单详情(具体使用了哪些原材料)
	 * @param orderId 订单ID
	 * @return List<materialOrder> 
	 */
	@Select("SELECT m_i.`materialId`,m_i.`materialName`,d_p_d.`productionQuantity` FROM materialOrder AS m_o "
			+"JOIN orderproduct AS o_p "
			+"ON m_o.`orderId` = o_p.`orderId` "
			+"JOIN Dailyplan AS d_p "				
			+"ON o_p.`dayPlanId` = d_p.`dailyPlanid` "	
			+"JOIN dailyPlanDetails AS d_p_d "		
			+"ON d_p.`dailyPlanid` = d_p_d.`dpId` " 	
			+"JOIN product_Info AS p_i "
			+"ON p_i.`proId` = d_p_d.`proId` "	
			+"JOIN product_Recipe AS p_r " 		
			+"ON p_r.`recipeId` = p_i.`recipeId` "
			+"JOIN product_Recipe_Details AS p_r_d "
			+"ON p_r_d.`recipeId`= p_r.`recipeId` "
			+"JOIN material_Info AS m_i	"	
			+"ON m_i.materialId = p_r_d.`rawMaterrialId` "	
			+"WHERE o_p.`orderId` = #{orderId} AND m_o.`moId` = #{moId}")
	List<MaterialOrder> selectMaterialInfo(@Param("orderId")Integer orderId,@Param("moId")Integer moId);
	
	/**
	 * 新增出库表
	 * @return Integer
	 */
	@Insert("INSERT INTO RawMaterial_Outbound(moId,rmoTime,warId,Employeeid,storageRemarks) VALUES (#{moId},now(),1,1,'')")
	Integer insertRawMaterialOutbound(Integer moId);
	
	/**
	 *	查询新增出库表倒序第一位Id
	 * @return Integer
	 */
	@Select("SELECT rmoId FROM RawMaterial_Outbound ORDER BY rmoId DESC LIMIT 1")
	Integer selectRmoIdTop();
	
	/**
	 * 查询出库状态
	 * @param rmoId 出库表ID
	 * @return String
	 */
	@Select("SELECT rmoStatus FROM RawMaterial_Outbound WHERE rmoId = #{rmoId}")
	String selectRmoStatusByRmoId(Integer rmoId);
	
	/**
	 * 修改领料单出库状态
	 * @param moId 领料单ID
	 * @return Integer
	 */
	@Update("update materialOrder set warehouseStatus = '已出库' where moId = #{moId}")
	Integer updateMaterialOrderStatus(Integer moId);
	
	/**
	 * 查询领料单ID(验证出库表中是否存在)
	 * @return List<materialOrder>
	 */
	@Select("select * from RawMaterial_Outbound where moId = #{moId}")
	List<MaterialOrder> selectMoId(Integer moId);
	
	/**
	 * 根据领料单ID修改月计划(审核状态、审核时间、审核人ID)
	 * @return Integer
	 */
	@Update("UPDATE materialOrder SET auditingdate = #{auditingdate},moStatus = '已审核',auditorId = 1 where moId = #{moId}")
	Integer updateThisMaterialOrderStatus(MaterialOrder materialOrder);
	
	
}
