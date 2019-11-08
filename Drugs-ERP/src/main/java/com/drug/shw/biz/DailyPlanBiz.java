package com.drug.shw.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.drug.shw.entity.DailyPlanDetails;
import com.drug.shw.entity.Dailyplan;
import com.drug.shw.entity.FinalGoodsInventoryshw;

public interface DailyPlanBiz {
	Integer insertDailyplanid(String monthPlanId,String monthPlanNum);
	HashMap<String, Object> selectDailyplan(String page,String limit);
	Integer updateDailyplanauditingStatue(Integer dailyPlanid);
	ArrayList<DailyPlanDetails> selectdailyPlanDetails(Integer dpid);
	Integer updatedailyPlanDetails(DailyPlanDetails dailyPlanDetails);
	ArrayList<FinalGoodsInventoryshw> selectFinalGoodsInventory();
}
