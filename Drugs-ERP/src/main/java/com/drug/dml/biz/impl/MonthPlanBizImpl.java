package com.drug.dml.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.dml.biz.MonthPlanBiz;
import com.drug.dml.entity.DrugsMonthPlan;
import com.drug.dml.mapper.MonthPlanMapper;

@Service
public class MonthPlanBizImpl implements MonthPlanBiz{
	
	@Autowired
	private MonthPlanMapper monthPlanMapper;

	@Override
	public List<DrugsMonthPlan> selectAllMonthPlan(Integer page,Integer limit) {
		Integer pageno=page*limit;
		Integer pageSize=(page-1)*limit;
		return monthPlanMapper.selectAllMonthPlan(pageno,pageSize);
	}

	@Override
	public Integer countAllMonthPlan() {
		return monthPlanMapper.countAllMonthPlan();
	}
	
	
}
