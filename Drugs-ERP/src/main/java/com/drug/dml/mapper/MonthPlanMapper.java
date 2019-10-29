package com.drug.dml.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.drug.dml.entity.DrugsMonthPlan;
import com.drug.dml.entity.DrugsMonthPlanDetails;
import com.drug.dml.entity.MonthPlanId;
import com.drug.dml.entity.PlanDetails;
import com.drug.dml.entity.ProductInfo;

@Repository
public interface MonthPlanMapper {
	
	/**
	 * 分页查询查询月计划
	 * @param pageno    当前页数
	 * @param pageSize	每页包含的数据量
	 * @return  List<DrugsMonthPlan>集合
	 */
	@Select("select * from drugs_monthPlan limit #{pageno},#{pageSize}")
	List<DrugsMonthPlan> selectAllMonthPlan(@Param("pageno")Integer pageno,@Param("pageSize")Integer pageSize);
	
	/**
	 * 查询月计划的数量
	 * @return Integer
	 */
	@Select("select count(*) from drugs_monthPlan")
	Integer countAllMonthPlan();
	
	/**
	 * 多表查询获得该月计划的月计划详情
	 * @param monthPlanId
	 * @return List<PlanDetails>
	 */
	@Select("SELECT p_i.proId,p_i.chineseName,p_i.proImage,d_m_d.produceNum FROM drugs_monthPlan_details AS d_m_d,product_Info AS p_i WHERE d_m_d.proId = p_i.proId AND d_m_d.monthPlanId = #{monthPlanId}")
	List<PlanDetails> selectPlanDetails(Integer monthPlanId);
	
	/**
	 * 下拉框动态取值(药品名)
	 * @return List<ProductInfo>
	 */
	@Select("SELECT proId,chineseName FROM product_Info")
	List<ProductInfo> selectChineseName();
	
	/**
	 * 新增月计划详情
	 * @return Integer
	 */ 
	@Insert("INSERT INTO drugs_monthPlan_details(monthPlanId,proId,produceNum,remarks,spare1,spare2,spare3) VALUES(9999,#{proId},#{produceNum},'无','','','')")
	Integer insertMonthPlanDetails(PlanDetails planDetails);
	
	/**
	 * 查询月计划ID为9999并且产品Id为1001的月计划详情
	 * @param proId 产品ID
	 * @return List<PlanDetails>
	 */
	@Select("SELECT * FROM drugs_monthPlan_details WHERE monthPlanId = 9999 AND proId = #{proId}")
	List<PlanDetails> selectMonthPlanDetailsByProId(int proId);
	
	/**
	 * 多表联合查询月计划详情表、药品表得到月计划详情单
	 * @return List<PlanDetails>
	 */
	@Select("SELECT d_m_d.monthPlanDetailId,p_i.proId,p_i.chineseName,d_m_d.produceNum FROM drugs_monthPlan_details AS d_m_d,product_Info AS p_i WHERE d_m_d.proId = p_i.proId AND d_m_d.monthPlanId = 9999")
	List<PlanDetails> selectDrugsMonthPlanDetails();
	
	/**
	 * 更改月计划详情药品数量(药品id重复情况下)
	 * @return Integer
	 */
	@Update("UPDATE drugs_monthPlan_details SET produceNum = produceNum+#{produceNum} where monthPlanDetailId = #{monthPlanDetailId}")
	Integer updateProduceNum(@Param("produceNum")int produceNum,@Param("monthPlanDetailId")int monthPlanDetailId);
	
	/**
	 * 新增月计划
	 * @param drugsMonthPlan
	 * @return Integer
	 */
	@Insert("INSERT INTO drugs_monthPlan(monthPlanNum,monthPlanRealNum,monthStartTime,monthCompleteTime,monthApplicationTime,employeeId,reviewDate,Visibles,empId,spare1,spare2,spare3) VALUES(600,500,'','',#{monthApplicationTime},#{employeeId},'',1,0,'','','')")
	Integer insertMonthPlan(DrugsMonthPlan drugsMonthPlan);
	
	/**
	 * 查询月计划降序第一位(返回一个monthPlanId)
	 * @return Integer
	 */
	@Select("SELECT monthPlanId FROM drugs_monthPlan ORDER BY monthPlanId DESC LIMIT 1")
	Integer selectMonthPlanTop();
	
	/**
	 * 根据月计划ID修改月计划ID
	 * @param monthPlanId
	 * @return Integer
	 */
	@Update("UPDATE drugs_monthPlan_details SET monthPlanId = #{monthPlanId} where monthPlanId = 9999")
	Integer updateMonthPlanDetailsByMonthPlanId(int monthPlanId);
	
	/**
	 * 指定月计划查询编辑
	 * @param monthPlanId
	 * @return List<DrugsMonthPlan>
	 */
	@Select("select * from drugs_monthPlan where monthPlanId = #{monthPlanId}")
	List<DrugsMonthPlan> selectThisMonthPlan(int monthPlanId);
	
	/**
	 * 根据月计划ID修改月计划(开始时间、结束时间、实际生产数量)
	 * @return Integer
	 */
	@Update("UPDATE drugs_monthPlan SET monthPlanRealNum = #{monthPlanRealNum},monthStartTime = #{monthStartTime},monthCompleteTime = #{monthCompleteTime} where monthPlanId = #{monthPlanId}")
	Integer updateThisMonthPlan(DrugsMonthPlan drugsMonthPlan);
	
	/**
	 * 根据月计划ID修改月计划(审核状态、审核时间、审核人ID)
	 * @return Integer
	 */
	@Update("UPDATE drugs_monthPlan SET reviewDate = #{reviewDate},reviewStatus = '已审核',empId = 1 where monthPlanId = #{monthPlanId}")
	Integer updateThisMonthPlanReviewStatus(DrugsMonthPlan drugsMonthPlan);
	
	/**
	 * 根据月计划ID修改月计划(开始时间、结束时间、实际生产数量)的生产状态
	 * @return Integer
	 */
	@Update("UPDATE drugs_monthPlan SET proState = '已生产' where monthPlanId = #{monthPlanId}")
	Integer updateThisMonthPlanProState(int monthPlanId);
	
	/**
	 * 删除指定月计划
	 * @return Integer
	 */
	@Delete("delete from drugs_monthPlan where monthPlanId = #{monthPlanId}")
	Integer deleteThisMonthPlan(int monthPlanId);
	
	/**
	 * 根据月计划ID删除月计划详情
	 * @param monthPlanId
	 * @return Integer
	 */
	@Delete("DELETE FROM drugs_monthPlan_details WHERE monthPlanId = #{monthPlanId}")
	Integer deleteThisMonthPlanAndMonthPlanDetail(int monthPlanId);
	
	/**
	 * 删除指定月计划详情
	 * @return Integer
	 */
	@Delete("delete from drugs_monthPlan_details where monthPlanDetailId = #{monthPlanDetailId}")
	Integer deleteThisMonthPlanDetailId(int monthPlanDetailId);
	
	/**
	 * 多表联合查询月计划详情表、月计划表(获得该月计划中月计划详情所有药品的数量)
	 * @param monthPlanId
	 * @return Integer
	 */
	@Select("SELECT SUM(produceNum) FROM drugs_monthPlan_details AS d_m_d JOIN drugs_monthPlan AS d_m ON d_m_d.monthPlanId = d_m.monthPlanId WHERE d_m.monthPlanId=#{monthPlanId}")
	Integer selectMonPlanAndPlanDetails(int monthPlanId);
	
	/**
	 * 更新月计划总数量
	 * @return Integer
	 */
	@Update("UPDATE drugs_monthPlan SET monthPlanNum = #{monthPlanNum} where monthPlanId = #{monthPlanId}")
	Integer updateMonthPlan(@Param("monthPlanNum")int monthPlanNum,@Param("monthPlanId")int monthPlanId);
	
	/**
	 * 用于验证商品是否为空
	 * @return Integer
	 */
	@Select("SELECT COUNT(*) FROM drugs_monthPlan_details WHERE monthPlanId = 9999")
	Integer selectMonthPlanDetailIfNull();
	
}
