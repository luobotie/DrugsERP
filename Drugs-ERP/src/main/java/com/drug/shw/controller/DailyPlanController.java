package com.drug.shw.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.shw.biz.DailyPlanBiz;
import com.drug.shw.entity.DailyPlanDetails;
import com.drug.shw.entity.FinalGoodsInventoryshw;

@Controller
public class DailyPlanController {
	@Autowired
	private DailyPlanBiz dailyPlanBiz;
	@RequestMapping("insertDailyplan.do")
	@ResponseBody
public Integer insertDailyplan(String monthPlanId,String monthPlanNum){
		return  dailyPlanBiz.insertDailyplanid(monthPlanId, monthPlanNum);
	}
	@RequestMapping("selectDailyplan.do")
	@ResponseBody
	public HashMap<String, Object> selectDailyplan(String page,String limit){
		return dailyPlanBiz.selectDailyplan(page,limit);
	}
	@RequestMapping("updateDailyplanauditingStatue.do")
	@ResponseBody
	public Integer updateDailyplanauditingStatue(Integer dailyPlanid){
		return dailyPlanBiz.updateDailyplanauditingStatue(dailyPlanid);
	}
	@RequestMapping("selectDailyPlanDetails.do")
	@ResponseBody
	public ArrayList<DailyPlanDetails> selectDailyPlanDetails(Integer dailyPlanid){
		System.err.println(dailyPlanid);
		return dailyPlanBiz.selectdailyPlanDetails(dailyPlanid);
	}
	@RequestMapping("updatedailyPlanDetails.do")
	@ResponseBody
	public Integer updatedailyPlanDetails(DailyPlanDetails dailyPlanDetails){
		return dailyPlanBiz.updatedailyPlanDetails(dailyPlanDetails);
	}
	@RequestMapping("selcetFinalGoodsInventory.do")
	@ResponseBody
	public ArrayList<FinalGoodsInventoryshw> selcetFinalGoodsInventory(DailyPlanDetails dailyPlanDetails){
		ArrayList<FinalGoodsInventoryshw> list = dailyPlanBiz.selectFinalGoodsInventory();
		for (FinalGoodsInventoryshw o: list) {
			System.err.println("chineseName = " + o.getChineseName());
		}
		return list;
	}
}
