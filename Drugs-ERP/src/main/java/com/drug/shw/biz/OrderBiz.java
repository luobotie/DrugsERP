package com.drug.shw.biz;

import java.util.HashMap;
import java.util.List;

import com.drug.shw.entity.DailyPlanDetails;
import com.drug.shw.entity.Dailyplan;
import com.drug.shw.entity.orderproduct;

public interface OrderBiz{
	HashMap<String, Object>selectorderproduct(String page,String limit);
	Integer updateorderproduct(orderproduct orderproduct);
	Integer deleteorderproduct(String orderid);
	Integer insertorderproduct(Dailyplan dailyplan);
	List<DailyPlanDetails> selectorderproductdetail(Integer id);
}
