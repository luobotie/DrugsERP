package com.drug.dml.biz.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.dml.biz.MonthPlanBiz;
import com.drug.dml.entity.DrugsMonthPlan;
import com.drug.dml.entity.DrugsMonthPlanDetails;
import com.drug.dml.entity.MonthPlanId;
import com.drug.dml.entity.PlanDetails;
import com.drug.dml.entity.ProductInfo;
import com.drug.dml.mapper.MonthPlanMapper;

@Service
public class MonthPlanBizImpl implements MonthPlanBiz{
	
	@Autowired
	private MonthPlanMapper monthPlanMapper;

	/**
	 * 分页查询查询月计划
	 */
	@Override
	public List<DrugsMonthPlan> selectAllMonthPlan(Integer page,Integer limit) {
		Integer pageno=(page-1)*limit; 
		return monthPlanMapper.selectAllMonthPlan(pageno,limit);
	}

	/**
	 * 查询月计划的数量
	 */
	@Override
	public Integer countAllMonthPlan() {
		return monthPlanMapper.countAllMonthPlan();
	}

	/**
	 * 多表查询获得该月计划的月计划详情
	 */
	@Override
	public List<PlanDetails> selectPlanDetails(Integer monthPlanId) {
		return monthPlanMapper.selectPlanDetails(monthPlanId);
	}

	/**
	 * 下拉框动态取值(药品名)
	 */
	@Override
	public List<ProductInfo> selectChineseName() {
		return monthPlanMapper.selectChineseName();
	}

	/**
	 * 新增月计划详情
	 */
	@Override
	public Integer insertMonthPlanDetails(PlanDetails planDetails) {
		return monthPlanMapper.insertMonthPlanDetails(planDetails);
	}

	/**
	 * 查询月计划ID为9999并且产品Id为1001的月计划详情
	 */
	@Override
	public List<PlanDetails> selectMonthPlanDetailsByProId(Integer proId) {
		return monthPlanMapper.selectMonthPlanDetailsByProId(proId);
	}
	
	/**
	 * 多表联合查询月计划详情表、药品表得到月计划详情单
	 */
	@Override
	public List<PlanDetails> selectDrugsMonthPlanDetails() {
		return monthPlanMapper.selectDrugsMonthPlanDetails();
	}

	/**
	 * 更改月计划详情药品数量(药品id重复情况下)
	 */
	@Override
	public Integer updateProduceNum(Integer produceNum,Integer monthPlanDetailId) {
		return monthPlanMapper.updateProduceNum(produceNum,monthPlanDetailId);
	}
	
	/**
	 * 新增月计划
	 */
	@Override
	public Integer insertMonthPlan(DrugsMonthPlan drugsMonthPlan) {
		return monthPlanMapper.insertMonthPlan(drugsMonthPlan);
	}

	/**
	 * 查询月计划降序第一位(返回一个monthPlanId)
	 */
	@Override
	public Integer selectMonthPlanTop() {
		return monthPlanMapper.selectMonthPlanTop();
	}
	
	/**
	 * 根据月计划ID修改月计划ID
	 */
	@Override
	public Integer updateMonthPlanDetailsByMonthPlanId(Integer monthPlanId) {
		return monthPlanMapper.updateMonthPlanDetailsByMonthPlanId(monthPlanId);
	}

	/**
	 * 指定月计划查询编辑
	 */
	@Override
	public List<DrugsMonthPlan> selectThisMonthPlan(Integer monthPlanId) {
		return monthPlanMapper.selectThisMonthPlan(monthPlanId);
	}

	/**
	 * 根据月计划ID修改月计划(开始时间、结束时间、实际生产数量)
	 */
	@Override
	public Integer updateThisMonthPlan(DrugsMonthPlan drugsMonthPlan) {
		return monthPlanMapper.updateThisMonthPlan(drugsMonthPlan);
	}

	/**
	 * 根据月计划ID修改月计划(审核状态、审核时间、审核人ID)
	 */
	@Override
	public Integer updateThisMonthPlanReviewStatus(DrugsMonthPlan drugsMonthPlan) {
		return monthPlanMapper.updateThisMonthPlanReviewStatus(drugsMonthPlan);
	}
	
	/**
	 * 根据月计划ID修改月计划(开始时间、结束时间、实际生产数量)的生产状态
	 */
	@Override
	public Integer updateThisMonthPlanProState(Integer monthPlanId) {
		return monthPlanMapper.updateThisMonthPlanProState(monthPlanId);
	}
	
	/**
	 * 删除指定月计划
	 */
	@Override
	public Integer deleteThisMonthPlan(Integer monthPlanId) {
		return monthPlanMapper.deleteThisMonthPlan(monthPlanId);
	}
	
	/**
	 * 根据月计划ID删除月计划详情
	 */
	@Override
	public Integer deleteThisMonthPlanAndMonthPlanDetail(Integer monthPlanId) {
		return monthPlanMapper.deleteThisMonthPlanAndMonthPlanDetail(monthPlanId);
	}

	/**
	 * 删除指定月计划详情
	 */
	@Override
	public Integer deleteThisMonthPlanDetailId(Integer monthPlanDetailId) {
		return monthPlanMapper.deleteThisMonthPlanDetailId(monthPlanDetailId);
	}

	/**
	 * 根据月计划ID修改月计划(审核状态、审核时间、审核人ID)(修改月计划)
	 */
	@Override
	public Integer updateThisMonthPlanStatus(Integer monthPlanId) {
		return monthPlanMapper.updateThisMonthPlanStatus(monthPlanId);
	}
	
	/**
	 * 多表联合查询月计划详情表、月计划表(获得该月计划中月计划详情所有药品的数量)
	 */
	@Override
	public Integer selectMonPlanAndPlanDetails(Integer monthPlanId) {
		return monthPlanMapper.selectMonPlanAndPlanDetails(monthPlanId);
	}

	/**
	 * 更新月计划总数量
	 */
	@Override
	public Integer updateMonthPlan(Integer monthPlanNum,Integer monthPlanId) {
		return monthPlanMapper.updateMonthPlan(monthPlanNum,monthPlanId);
	}

	/**
	 * 用于验证商品是否为空
	 */
	@Override
	public Integer selectMonthPlanDetailIfNull() {
		return monthPlanMapper.selectMonthPlanDetailIfNull();
	}
	
	/**
	 * 修改月计划用于验证商品是否为空
	 */
	@Override
	public Integer selectMonthPlanDetailIfNullAgain(Integer monthPlanId) {
		return monthPlanMapper.selectMonthPlanDetailIfNullAgain(monthPlanId);
	}

	@Override
	public List<PlanDetails> selectDrugsMonthPlanDetailsAgain(Integer monthPlanId) {
		return monthPlanMapper.selectDrugsMonthPlanDetailsAgain(monthPlanId);
	}

	@Override
	public Integer insertMonthPlanDetailsAgain(Integer monthPlanId,Integer proId,Integer produceNum) {
		return monthPlanMapper.insertMonthPlanDetailsAgain(monthPlanId,proId,produceNum);
	}

	
}
