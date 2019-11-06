package com.drug.shw.mapper;


import java.util.HashMap;
import java.util.List;

import com.drug.shw.entity.DailyPlanDetails;
import com.drug.shw.entity.orderproduct;

public interface OrderDao {
  List<orderproduct> selectorderproduct(HashMap<String, Integer> map);
  Integer selectrowfromorderproduct();
  Integer updateorderproduct(orderproduct orderproduct);
  Integer deleteorderproduct(Integer orderid);
  Integer insertorderproduct(orderproduct orderproduct);
  Integer insertorderproductdetail(DailyPlanDetails dailyPlanDetails);
  List<DailyPlanDetails> selectorderproductdetail(Integer id);
}
