package com.drug.dml.biz;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.drug.dml.entity.DrugsMonthPlan;
import com.drug.dml.entity.DrugsMonthPlanDetails;
import com.drug.dml.entity.MonthPlanId;
import com.drug.dml.entity.PlanDetails;
import com.drug.dml.entity.ProductInfo;

@Repository
public interface MonthPlanBiz {
	
	/**
	 * 分页查询查询月计划
	 * @param page    当前页数
	 * @param limit	每页包含的数据量
	 * @return  List<DrugsMonthPlan>集合
	 */
	List<DrugsMonthPlan> selectAllMonthPlan(Integer page,Integer limit);
	
	/**
	 * 查询月计划的数量
	 * @return Integer
	 */
	Integer countAllMonthPlan();
	
	/**
	 * 多表查询获得该月计划的月计划详情
	 * @param monthPlanId
	 * @return List<PlanDetails>
	 */
	List<PlanDetails> selectPlanDetails(Integer monthPlanId);
	
	/**
	 * 下拉框动态取值(药品名)
	 * @return List<ProductInfo>
	 */
	List<ProductInfo> selectChineseName();
	
	/**
	 * 新增月计划详情
	 * @return Integer
	 */
	Integer insertMonthPlanDetails(PlanDetails planDetails);
	
	/**
	 * 查询月计划ID为9999并且产品Id为1001的月计划详情
	 * @param proId 产品ID
	 * @return List<PlanDetails>
	 */
	List<PlanDetails> selectMonthPlanDetailsByProId(int proId);
	
	/**
	 * 多表联合查询月计划详情表、药品表得到月计划详情单
	 * @return List<PlanDetails>
	 */
	List<PlanDetails> selectDrugsMonthPlanDetails();
	
	/**
	 * 更改月计划详情药品数量(药品id重复情况下)
	 * @return Integer
	 */
	Integer updateProduceNum(int produceNum,int monthPlanDetailId);
	
	/**
	 * 新增月计划
	 * @param drugsMonthPlan
	 * @return Integer
	 */
	Integer insertMonthPlan(DrugsMonthPlan drugsMonthPlan);
	
	/**
	 * 查询月计划降序第一位(返回一个monthPlanId)
	 * @return Integer
	 */
	Integer selectMonthPlanTop();
	
	/**
	 * 根据月计划ID修改月计划ID
	 * @param monthPlanId
	 * @return Integer
	 */
	Integer updateMonthPlanDetailsByMonthPlanId(int monthPlanId);
	
	/**
	 * 指定月计划查询编辑
	 * @param monthPlanId
	 * @return List<DrugsMonthPlan>
	 */
	List<DrugsMonthPlan> selectThisMonthPlan(int monthPlanId);
	
	/**
	 * 根据月计划ID修改月计划(开始时间、结束时间、实际生产数量)
	 * @return Integer
	 */
	Integer updateThisMonthPlan(DrugsMonthPlan drugsMonthPlan);
	
	/**
	 * 根据月计划ID修改月计划(审核状态、审核时间、审核人ID)
	 * @return Integer
	 */
	Integer updateThisMonthPlanReviewStatus(DrugsMonthPlan drugsMonthPlan);
	
	/**
	 * 根据月计划ID修改月计划(开始时间、结束时间、实际生产数量)的生产状态
	 * @return Integer
	 */
	Integer updateThisMonthPlanProState(int monthPlanId);
	
	/**
	 * 删除指定月计划
	 * @return Integer
	 */
	Integer deleteThisMonthPlan(int monthPlanId);
	
	/**
	 * 根据月计划ID删除月计划详情
	 * @param monthPlanId
	 * @return Integer
	 */
	Integer deleteThisMonthPlanAndMonthPlanDetail(int monthPlanId);
	
	/**
	 * 删除指定月计划详情
	 * @return Integer
	 */
	Integer deleteThisMonthPlanDetailId(int monthPlanDetailId);
	
	/**
	 * 多表联合查询月计划详情表、月计划表(获得该月计划中月计划详情所有药品的数量)
	 * @param monthPlanId
	 * @return Integer
	 */
	Integer selectMonPlanAndPlanDetails(int monthPlanId);
	
	/**
	 * 更新月计划总数量
	 * @return Integer
	 */
	Integer updateMonthPlan(int monthPlanNum,int monthPlanId);
	
	/**
	 * 用于验证商品是否为空
	 * @return Integer
	 */
	Integer selectMonthPlanDetailIfNull();
}
