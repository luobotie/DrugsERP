package com.drug.dml.biz;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.drug.dml.entity.DrugsMonthPlan;

@Repository
public interface MonthPlanBiz {
	
	List<DrugsMonthPlan> selectAllMonthPlan(Integer page,Integer limit);
	
	Integer countAllMonthPlan();
}
