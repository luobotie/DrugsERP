package com.drug.shw.mapper;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.drug.shw.entity.DailyPlanDetails;
import com.drug.shw.entity.Dailyplan;
import com.drug.shw.entity.Drug;

public interface DailyPlanDao {
	Integer insertDailyplan(Dailyplan dailplan);
	List<Dailyplan> selectDailyplan(HashMap<String, Integer> map);
	Integer selectrowfromDailyplan();
	Integer updateDailyplanauditingStatue(Map<String,Object> map);
	List<Drug> selectdrugsmonthPlandetails(Integer monthPlanId);
	Integer insertdailyPlanDetails(DailyPlanDetails dailyPlanDetails);
	Integer updateDailyplan(Map<String, Object> map);
	ArrayList<DailyPlanDetails> selectdailyPlanDetails(Integer dpid);
	Integer updateDailyPlanDetails(DailyPlanDetails dailyPlanDetails);
}       

