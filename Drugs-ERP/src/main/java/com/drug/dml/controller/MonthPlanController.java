package com.drug.dml.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.drug.dml.biz.MonthPlanBiz;
import com.drug.dml.entity.DrugsMonthPlan;
import com.drug.dml.entity.DrugsMonthPlanDetails;
import com.drug.dml.entity.MonthPlanId;
import com.drug.dml.entity.PlanDetails;
import com.drug.dml.entity.ProductInfo;
import com.fasterxml.jackson.databind.node.IntNode;

@RestController
public class MonthPlanController {
	
	@Autowired
	private MonthPlanBiz monthPlanBiz;
	
	/**
	 * 查询月计划
	 * @param page	当前页数
	 * @param limit	当前页数显示数
	 * @return map
	 */
	@RequestMapping("/getAllMonthPlan.do")
	public Map<String, Object> getAllMonthPlan(Integer page,Integer limit){
		//分页查询
		List<DrugsMonthPlan> list = monthPlanBiz.selectAllMonthPlan(page, limit);
		//查询获取月计划总数
		int count = monthPlanBiz.countAllMonthPlan();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("code", 0);
		map.put("count", count);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 查询月计划详情
	 * @param monthPlanId 月计划ID
	 * @return map
	 */
	@RequestMapping("/getPlanDetails.do")
	public Map<String, Object> getPlanDetails(Integer monthPlanId){
		//根据月计划ID查询该月的月计划详情
		List<PlanDetails> list = monthPlanBiz.selectPlanDetails(monthPlanId);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("code", 0);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 下拉框动态传值
	 * @return list
	 */
	@RequestMapping("/getChineseName.do")
	public List<ProductInfo> getChineseName(){
		//查询药品表返回所有的药品名
		List<ProductInfo> list = monthPlanBiz.selectChineseName();
		return list;
	}
	
	/**
	 * 新增月计划详情
	 * @param planDetails 多表查询获得该月计划的月计划详情实体类
	 * @return count
	 */
	@RequestMapping("/insertMonthPlanDetails.do")
	public int insertMonthPlanDetails(PlanDetails planDetails){
		int count = 0;
		int produceNum = planDetails.getProduceNum();
		//查询月计划ID为9999的所有月计划详情(多表联合查询月计划详情表、药品表得到月计划详情单)
		List<PlanDetails> list = monthPlanBiz.selectDrugsMonthPlanDetails();
		if(list.size()>0){
			boolean flag = true;
			for (PlanDetails p : list) {
				if(p.getProId().equals(planDetails.getProId())){
					//更新月计划详情相同药药品的数量
					count = monthPlanBiz.updateProduceNum(produceNum,p.getMonthPlanDetailId());
					flag = false;
				}
			}
			//这里如果执行的话代表 详情表里没有这个药
			if(flag){
				//(给月计划ID为9999的月计划)新增月计划详情
				count = monthPlanBiz.insertMonthPlanDetails(planDetails);
			}
		}else {
			//(给月计划ID为9999的月计划)新增月计划详情
			count = monthPlanBiz.insertMonthPlanDetails(planDetails);
		}
		return count;
	}
	
	/**
	 * 查询月计划详情
	 * @return map
	 */
	@RequestMapping("/selectMonthPlanDetails.do")
	public Map<String, Object> selectMonthPlanDetails(){
		//查询月计划ID为9999的所有月计划详情(多表联合查询月计划详情表、药品表得到月计划详情单)
		List<PlanDetails> list = monthPlanBiz.selectDrugsMonthPlanDetails();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("code", 0);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 新增然后修改月计划
	 * @param drugsMonthPlan 月计划对象
	 * @return count
	 */
	@RequestMapping("/insertAndUpdate.do")
	public int insertAndUpdate(DrugsMonthPlan drugsMonthPlan){
		//新增一条月计划
		int count = monthPlanBiz.insertMonthPlan(drugsMonthPlan);
		//倒序获得最新的月计划ID
		int monthPlanId = monthPlanBiz.selectMonthPlanTop(); 
		System.out.println("月计划Id:"+monthPlanId);
		//将ID为9999的月计划改为倒序获得的最新月计划ID
		monthPlanBiz.updateMonthPlanDetailsByMonthPlanId(monthPlanId);
		//查询当月的所有月计划详情商品数量的总和并返回
		int monthPlanNum = monthPlanBiz.selectMonPlanAndPlanDetails(monthPlanId);
		System.out.println("月计划Id:"+monthPlanNum);
		//根据月计划ID以及获得的月计划详情商品数量的总和,更新月计划生产总数
		monthPlanBiz.updateMonthPlan(monthPlanNum,monthPlanId);
		return count;
	}
	
	/**
	 * 指定月计划查询编辑
	 * @param monthPlanId 月计划ID
	 * @return map
	 */
	@RequestMapping("/selectThisMonthPlan.do")
	public Map<String, Object> selectThisMonthPlan(Integer monthPlanId){
		//根据月计划ID查询月计划(编辑操作)
		List<DrugsMonthPlan> list = monthPlanBiz.selectThisMonthPlan(monthPlanId);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("code", 0);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 修改指定月计划(开始时间、结束时间、实际生产数量)的生产状态
	 * @param drugsMonthPlan 月计划对象
	 * @return count
	 */
	@RequestMapping("/updateThisMonthPlan.do")
	public int updateThisMonthPlan(DrugsMonthPlan drugsMonthPlan){
		//获得月计划ID
		int monthPlanId  = drugsMonthPlan.getMonthPlanId();
		//根据月计划ID查询该月月计划(第一次查询)
		List<DrugsMonthPlan> list = monthPlanBiz.selectThisMonthPlan(monthPlanId);
		//根据获得的月计划对象修改开始时间、结束时间、实际生产数量
		int count = monthPlanBiz.updateThisMonthPlan(drugsMonthPlan);
		for (DrugsMonthPlan d : list) {
			//根据月计划ID查询该月月计划(第二次查询)
			List<DrugsMonthPlan> list2 = monthPlanBiz.selectThisMonthPlan(monthPlanId);
			for (DrugsMonthPlan dr : list2) {
				//判断两次查询的月计划开始时间是否一致(月计划开始时间在插入时默认为空,修改月计划生产状态是根据月计划开始时间是否变更)
				if (!d.getMonthStartTime().equals(dr.getMonthStartTime())) {
						//根据月计划ID修改生产状态
						monthPlanBiz.updateThisMonthPlanProState(monthPlanId);
					}
				}
		}
		return count;
	}
	
	/**
	 * 修改指定月计划(审核状态、审核时间、审核人ID)
	 * @param drugsMonthPlan 月计划对象
	 * @return count
	 */
	@RequestMapping("/updateThisMonthPlanReviewStatus.do")
	public int updateThisMonthPlanReviewStatus(DrugsMonthPlan drugsMonthPlan){
		//修改指定月计划的审核状态、审核时间、审核人ID
		int count = monthPlanBiz.updateThisMonthPlanReviewStatus(drugsMonthPlan);
		return count;
	}
	
	/**
	 * 删除指定月计划
	 * @param monthPlanId 月计划ID
	 * @return count
	 */
	@RequestMapping("/deleteThisMonthPlan.do")
	public int deleteThisMonthPlan(Integer monthPlanId){
		//根据月计划ID删除指定月计划
		int count = monthPlanBiz.deleteThisMonthPlan(monthPlanId);
		//根据月计划ID删除指定月计划的月计划详情
		int counts = monthPlanBiz.deleteThisMonthPlanAndMonthPlanDetail(monthPlanId);
		return count;
	}
	
	
	/**
	 * 删除指定月计划详情
	 * @param monthPlanDetailId 月计划详情ID
	 * @return count
	 */
	@RequestMapping("/deleteThisMonthPlanDetailId.do")
	public Integer deleteThisMonthPlanDetailId(Integer monthPlanDetailId,Integer monthPlanId){
		//删除月计划ID为9999的月计划详情(根据月计划详情ID进行删除)
		int count = monthPlanBiz.deleteThisMonthPlanDetailId(monthPlanDetailId);
		int x = monthPlanBiz.updateThisMonthPlanStatus(monthPlanId);
		System.out.println("删除后..修改成功:"+x);
		return count;
	}
	
	/**
	 * 用于验证商品是否为空
	 * @return count
	 */
	@RequestMapping("/selectMonthPlanDetailIfNull.do")
	public int selectMonthPlanDetailIfNull(){
		//查询月计划ID为9999月计划详情总数(用于验证商品是否为空)
		int count = monthPlanBiz.selectMonthPlanDetailIfNull();
		return count;
	}
	
	/**
	 * 用于验证商品是否为空
	 * @return count
	 */
	@RequestMapping("/selectMonthPlanDetailIfNullAgain.do")
	public int selectMonthPlanDetailIfNullAgain(Integer monthPlanId){
		//查询月计划ID为9999月计划详情总数(用于验证商品是否为空)
		int count = monthPlanBiz.selectMonthPlanDetailIfNullAgain(monthPlanId);
		return count;
	}
	
	/**
	 * 新增月计划详情(修改月计划详情)
	 * @param planDetails 多表查询获得该月计划的月计划详情实体类
	 * @return count
	 */
	@RequestMapping("/insertMonthPlanDetailsAgain.do")
	public int insertMonthPlanDetailsAgain(Integer monthPlanId,Integer proId,Integer produceNum){
		int count = 0;
		//查询指定月计划的所有月计划详情(多表联合查询月计划详情表、药品表得到月计划详情单)
		List<PlanDetails> list = monthPlanBiz.selectDrugsMonthPlanDetailsAgain(monthPlanId);
		if(list.size()>0){
			boolean flag = true;
			for (PlanDetails p : list) {
				if(p.getProId().equals(proId)){
					//更新月计划详情相同药药品的数量
					count = monthPlanBiz.updateProduceNum(produceNum,p.getMonthPlanDetailId());
					int z = monthPlanBiz.updateThisMonthPlanStatus(monthPlanId);
					System.out.println("修改成功4:"+z);
					flag = false;
				}
			}
			//这里如果执行的话代表 详情表里没有这个药
			if(flag){
				//给指定月计划ID新增月计划详情
				count = monthPlanBiz.insertMonthPlanDetailsAgain(monthPlanId,proId,produceNum);
				int x = monthPlanBiz.updateThisMonthPlanStatus(monthPlanId);
				System.out.println("修改成功2:"+x);
			}
		}else {
			//给指定月计划ID新增月计划详情
			count = monthPlanBiz.insertMonthPlanDetailsAgain(monthPlanId,proId,produceNum);
			int c = monthPlanBiz.updateThisMonthPlanStatus(monthPlanId);
			System.out.println("修改成功3:"+c);
		}
		return count;
	}
	
	/**
	 * 查询月计划详情(修改月计划详情操作)
	 * @return map
	 */
	@RequestMapping("/selectMonthPlanDetailsAgain.do")
	public Map<String, Object> selectMonthPlanDetailsAgain(Integer monthPlanId){
		//查询月计划ID为9999的所有月计划详情(多表联合查询月计划详情表、药品表得到月计划详情单)
		List<PlanDetails> list = monthPlanBiz.selectDrugsMonthPlanDetailsAgain(monthPlanId);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("code", 0);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 新增然后修改月计划(修改月计划)
	 * @param drugsMonthPlan 月计划对象
	 * @return count
	 */
	@RequestMapping("/insertAndUpdateAgain.do")
	public int insertAndUpdateAgain(DrugsMonthPlan drugsMonthPlan,Integer monthPlanId){
		/*//新增一条月计划
		int count = monthPlanBiz.insertMonthPlan(drugsMonthPlan);
		//倒序获得最新的月计划ID
		int monthPlanId = monthPlanBiz.selectMonthPlanTop(); */
		//将ID为9999的月计划改为倒序获得的最新月计划ID
		//monthPlanBiz.updateMonthPlanDetailsByMonthPlanId(drugsMonthPlan.getMonthPlanId());
		//查询当月的所有月计划详情商品数量的总和并返回
		Integer monthPlanNum = monthPlanBiz.selectMonPlanAndPlanDetails(monthPlanId);
		System.out.println("生产总数:"+monthPlanNum);
		int x = monthPlanBiz.updateThisMonthPlanStatus(monthPlanId);
		System.out.println("修改成功:"+x);
		//根据月计划ID以及获得的月计划详情商品数量的总和,更新月计划生产总数
		int count =monthPlanBiz.updateMonthPlan(monthPlanNum,monthPlanId);
		return count;
	}
}
