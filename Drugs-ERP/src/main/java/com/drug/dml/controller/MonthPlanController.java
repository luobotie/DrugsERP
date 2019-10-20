package com.drug.dml.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.dml.biz.MonthPlanBiz;
import com.drug.dml.entity.DrugsMonthPlan;

@Controller
public class MonthPlanController {
	
	@Autowired
	private MonthPlanBiz monthPlanBiz;
	
	@RequestMapping("/getAllMonthPlan.do")
	@ResponseBody
	public Map<String, Object> getAllMonthPlan(Integer page,Integer limit){
		List<DrugsMonthPlan> list = monthPlanBiz.selectAllMonthPlan(page, limit);
		int count = monthPlanBiz.countAllMonthPlan();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("code", 0);
		map.put("count", count);
		map.put("data", list);
		return map;
	}
}
