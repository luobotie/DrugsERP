package com.drug.shw.impl;

import java.text.SimpleDateFormat;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.luobo.entity.Employee;
import com.drug.luobo.untils.WebUtils;
import com.drug.shw.biz.DailyPlanBiz;
import com.drug.shw.entity.DailyPlanDetails;
import com.drug.shw.entity.Dailyplan;
import com.drug.shw.entity.Drug;
import com.drug.shw.entity.FinalGoodsInventoryshw;
import com.drug.shw.entity.orderproduct;
import com.drug.shw.mapper.DailyPlanDao;
@Service
public class DailyPlanImpl implements DailyPlanBiz {
	@Autowired
	private DailyPlanDao dailyPlandao;
	@Override
	public Integer insertDailyplanid(String monthPlanId,String monthPlanNum) {
		Integer monthPlanId2=Integer.parseInt(monthPlanId);
		Integer monthPlanNum2=Integer.parseInt(monthPlanNum);
		List<Drug> listdrug=dailyPlandao.selectdrugsmonthPlandetails(monthPlanId2);
		ArrayList<Dailyplan> list=new ArrayList<Dailyplan>();
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar c=Calendar.getInstance();
		int d=c.getActualMaximum(Calendar.DAY_OF_MONTH);
		int now=c.get(Calendar.DAY_OF_MONTH);
		int producetime=d-now+1;
		for(int i=now;i<=d;i++){
			Dailyplan dailyplan=new Dailyplan();
			dailyplan.setAuditingStatue("未审核");
			dailyplan.setPlanId(monthPlanId2);
			String time=sf.format(c.getTime());
			dailyplan.setProductDate(time);
			c.add(c.DAY_OF_MONTH,1);
		if(monthPlanNum2%producetime==0){
			dailyplan.setProductionQuantity(monthPlanNum2/producetime);
			}
		else{
			if(i==d){
			dailyplan.setProductionQuantity(monthPlanNum2-(monthPlanNum2/producetime)*(d-now));	
			}
			else{
			dailyplan.setProductionQuantity(monthPlanNum2/producetime);
			}
		}
		list.add(dailyplan);
		}
		int i=0;
		for(Dailyplan o:list){
			HashMap<String,Object> map=new HashMap<String,Object>();
			dailyPlandao.insertDailyplan(o);
			i++;
			int sum=0;
			for(Drug drug:listdrug){
				DailyPlanDetails dPlanDetails=new DailyPlanDetails();
				dPlanDetails.setDpId(o.getDailyPlanid());
				dPlanDetails.setProId(drug.getProId());
				if(drug.getProduceNum()%list.size()==0){
					dPlanDetails.setProductionQuantity(drug.getProduceNum()/list.size());
					}
				else{
					dPlanDetails.setProductionQuantity(drug.getProduceNum()/list.size());
					if(i==list.size()){
						dPlanDetails.setProductionQuantity(drug.getProduceNum()-(drug.getProduceNum()/list.size())*(list.size()-1));	
					}
				}
				dailyPlandao.insertdailyPlanDetails(dPlanDetails);
				sum+=dPlanDetails.getProductionQuantity();
			}
			map.put("sum",sum);
			map.put("did",o.getDailyPlanid());
			dailyPlandao.updateDailyplan(map);
		}
		return list.size();
	}
	@Override
	public HashMap<String, Object> selectDailyplan(String page, String limit) {
		int page2=Integer.parseInt(page);
		System.out.println(page2);
		int limit2=Integer.parseInt(limit);
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		int d=(page2-1)*limit2;
		System.err.println(d);
		map.put("begin",d);
		map.put("end", limit2);
		List<Dailyplan> list=dailyPlandao.selectDailyplan(map);
		System.out.println(list);
		HashMap<String, Object> map2=new HashMap<String, Object>();
		int row=dailyPlandao.selectrowfromDailyplan();
		map2.put("msg", "");
		map2.put("code", 0);
		map2.put("count", row);
		map2.put("data", list);
		System.out.println("sasa"+map2);
		return map2;
		
	}
	@Override
	public Integer updateDailyplanauditingStatue(Integer dailyPlanid) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		Date date=new Date();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		String date2=simpleDateFormat.format(date);
		Employee e=(Employee)WebUtils.getHttpSession().getAttribute("employee");
		map.put("name", e.getEmployeeName());
		map.put("date", date);
		map.put("dailyPlanid",dailyPlanid);
		map.put("statue","已审核");
		return dailyPlandao.updateDailyplanauditingStatue(map);
	}
	@Override
	public ArrayList<DailyPlanDetails> selectdailyPlanDetails(Integer dpid) {
		return dailyPlandao.selectdailyPlanDetails(dpid);
	}
	@Override
	public Integer updatedailyPlanDetails(DailyPlanDetails dailyPlanDetails) {
		
		return dailyPlandao.updateDailyPlanDetails(dailyPlanDetails);
	}
	@Override
	public ArrayList<FinalGoodsInventoryshw> selectFinalGoodsInventory() {
		
		return dailyPlandao.selectFinalGoodsInventory();
	}

}
