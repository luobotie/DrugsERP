package com.drug.dml.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.drug.dml.entity.CheckProduct;
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
	@Select("SELECT m_i.`materialId`,m_i.`materialName`,d_p_d.`productionQuantity`,p_i.`proId` FROM materialOrder AS m_o "
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
	
	/**
	 * 根据领料单ID删除领料信息
	 * @param moId 领料单ID
	 * @return  Integer
	 */
	@Delete("delete from materialOrder where moId = #{moId}")
	Integer deleteMaterialOrderByMoId(Integer moId);
	
	/**
	 * 在生产订单页面发送请求,新增领料单
	 * @return Integer
	 */
	@Insert("INSERT INTO materialOrder(orderId,applydate,proposerId,auditingdate,auditorId,materialOrderdes) VALUES "
			+ "(#{orderId},#{applydate},#{proposerId},'1900-01-01 00:00:00',0,'')")
	Integer insertMaterialOrder(MaterialOrder materialOrder);
	
	/**
	 * 在生产订单页面发送请求,新增质检单
	 * @return Integer
	 */
	@Insert("INSERT INTO check_Product(orderId,statusMan,statustime) VALUES(#{orderId},0,'1900-01-01 00:00:00');")
	Integer insertCheckProduct(CheckProduct checkProduct);
	
	
	@Select("select moStatus from materialOrder where orderId = #{orderId}")
	String selectMaterialOrderStatus(Integer orderId);
	
	@Select("select warehouseStatus from materialOrder where orderId = #{orderId}")
	String selectMaterialOrderWarStatus(Integer orderId);
	
	/**
	 * 修改订单表领料状态
	 * @param orderId  订单表ID
	 * @return Integer
	 */
	@Update("update orderproduct set materialState = '已领料' where orderId = #{orderId}")
	Integer updateOrderProductStatus(Integer orderId);
	
	@Select("select qualitystatus from check_Product where orderId = #{orderId}")
	String selectCheckProductStatus(Integer orderId);
	
	/**
	 * 修改订单表生产状态
	 * @param orderId 订单表ID
	 * @return Integer
	 */
	@Update("update orderproduct set produceState = '已完成' where orderId = #{orderId}")
	Integer updateOrderProductProStatus(Integer orderId);
	
}
