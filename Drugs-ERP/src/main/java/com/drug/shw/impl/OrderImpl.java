package com.drug.shw.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.luobo.entity.Employee;
import com.drug.luobo.untils.WebUtils;
import com.drug.shw.biz.OrderBiz;
import com.drug.shw.entity.DailyPlanDetails;
import com.drug.shw.entity.Dailyplan;
import com.drug.shw.entity.orderproduct;
import com.drug.shw.mapper.DailyPlanDao;
import com.drug.shw.mapper.OrderDao;
@Service
public class OrderImpl implements OrderBiz{
	@Autowired
    private OrderDao orderDao;
	@Autowired
	private DailyPlanDao dailyPlanDao;
	@Override
	public HashMap<String,Object> selectorderproduct(String page,String limit) {
		int page2=Integer.parseInt(page);
		int limit2=Integer.parseInt(limit);
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		map.put("begin",(page2-1)*limit2);
		map.put("end", limit2);
		List<orderproduct> list=orderDao.selectorderproduct(map);
		HashMap<String, Object> map2=new HashMap<String, Object>();
		int row=orderDao.selectrowfromorderproduct();
		map2.put("msg", "");
		map2.put("code", 0);
		map2.put("count", row);
		map2.put("data", list);
		return map2;
	}
	@Override
	public Integer updateorderproduct(orderproduct orderproduct) {
		return orderDao.updateorderproduct(orderproduct);
	}
	@Override
	public Integer deleteorderproduct(String orderid) {
		
		Integer orderid2=Integer.parseInt(orderid);
		return orderDao.deleteorderproduct(orderid2);
	}
	@Override
	public Integer insertorderproduct(Dailyplan dailyplan){
		orderproduct orderproduct=new orderproduct();
		orderproduct.setProduceNumber(dailyplan.getProductionQuantity());
		Employee employee=(Employee)WebUtils.getHttpSession().getAttribute("employee");
		orderproduct.setEmployName(employee.getEmployeeName());
		Date date=new Date();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		String orderDate=simpleDateFormat.format(date);
		orderproduct.setOrderDate(orderDate);
		orderproduct.setAuditState("未审核");
		orderproduct.setMaterialState("未领料");
		orderproduct.setProduceState("未完成");
		orderproduct.setDayPlanId(dailyplan.getDailyPlanid());
		orderDao.insertorderproduct(orderproduct);
		ArrayList<DailyPlanDetails> list=dailyPlanDao.selectdailyPlanDetails(dailyplan.getDailyPlanid());
		for(DailyPlanDetails d:list){
			orderDao.insertorderproductdetail(d);
		}
		return list.size();
	}
	@Override
	public List<DailyPlanDetails> selectorderproductdetail(Integer id) {
		return orderDao.selectorderproductdetail(id);
	}
	@Override
	public Integer updateorderproductauditState(Integer orderId) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		Date date=new Date();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		String date2=simpleDateFormat.format(date);
		Employee e=(Employee)WebUtils.getHttpSession().getAttribute("employee");
		
		map.put("orderId",orderId);
		map.put("auditState","已审核");
		return orderDao.updateorderproductauditState(map);
	}

}
