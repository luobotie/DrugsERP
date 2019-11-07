package com.drug.shw.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.luobo.untils.WebUtils;
import com.drug.shw.biz.OrderBiz;
import com.drug.shw.entity.DailyPlanDetails;
import com.drug.shw.entity.Dailyplan;
import com.drug.shw.entity.orderproduct;

@Controller
public class ProduceOrder {
	@Autowired
private OrderBiz order;
	@RequestMapping("selectorder.do")
	@ResponseBody
	public HashMap<String, Object> selectorder(String page,String limit){
		return order.selectorderproduct(page,limit);
}
	@RequestMapping("updateorder.do")
	@ResponseBody
	public Integer updateorder(orderproduct orderproduct){
		return order.updateorderproduct(orderproduct);
}
	@RequestMapping("deleteorder.do")
	@ResponseBody
	public Integer deleteorder(String orderid){
		return order.deleteorderproduct(orderid);
}
	@RequestMapping("insertorderproduct.do")
	@ResponseBody
	public Integer deleteorder(Dailyplan dailyplan){
		return order.insertorderproduct(dailyplan);
}
	@RequestMapping("selectorderproductdetail.do")
	@ResponseBody
	public List<DailyPlanDetails> selectorderproductdetail(Integer dailyPlanid){
		return order.selectorderproductdetail(dailyPlanid);
}
	@RequestMapping("updateorderproduct.do")
	@ResponseBody
	public Integer updateorderproduct(Integer orderId){
		return order.updateorderproductauditState(orderId);
}
}
