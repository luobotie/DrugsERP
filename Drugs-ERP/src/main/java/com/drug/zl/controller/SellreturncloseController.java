package com.drug.zl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.zl.biz.SellreturncloseBiz;
import com.drug.zl.entity.Purchasereturnclose;
import com.drug.zl.entity.Sellreturnclose;

@Controller
public class SellreturncloseController {
	@Autowired
	private SellreturncloseBiz srcBiz;
	@RequestMapping("/allsrc.do")
	public @ResponseBody Map<String,Object> allSellreturnclose(){
		List<Sellreturnclose> list=srcBiz.allSellreturnclose();
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg","");
		map.put("count", list.size());
		map.put("data",list);
		return map;
	}
	@RequestMapping("/deletesrc.do")
	public @ResponseBody int deleteSellreturnclose(int sellReturnCloseId){
		int row=srcBiz.deleteSellreturnclose(sellReturnCloseId);
		return row;
	}
	@RequestMapping("/addsrc.do")
	public @ResponseBody String addSellreturnclose(Sellreturnclose src){
		System.err.println("经办人" + src.getFinanceManId());
			//Financepurchaseclose fpc=new Financepurchaseclose(paidMoney, unPaidMoney, purchaseorderId, financeManId, closeTime, firstMoney, lastMoney, practicalPaidMoney, shouldPaidMoney, fPCRemark);
			int row=srcBiz.addSellreturnclose(src);
			if(row>0){
				System.err.println("新增成功");
			}
			return "<script type='text/javascript'>parent.location.reload();</script>";
		
	}
	@RequestMapping("/updatesrc.do")
	public @ResponseBody String updateSellreturnclose(Sellreturnclose src){
		int row=srcBiz.upadteSellreturnclose(src);
		return "<script type='text/javascript'>window.location.href='/Drugs-ERP/admin/finance/showPay.jsp';</script>";
	}
}
