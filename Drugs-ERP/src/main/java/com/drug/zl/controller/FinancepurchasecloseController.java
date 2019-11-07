package com.drug.zl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.zl.biz.FinancepurchasecloseBiz;
import com.drug.zl.entity.Financepurchaseclose;

@Controller
public class FinancepurchasecloseController {
	@Autowired
	private FinancepurchasecloseBiz fpcBiz;
	@RequestMapping("/addfpc.do")
	public @ResponseBody String addFinancepurchaseclose(Financepurchaseclose fpc){
		System.err.println("首付款" + fpc.getFirstMoney());
			//Financepurchaseclose fpc=new Financepurchaseclose(paidMoney, unPaidMoney, purchaseorderId, financeManId, closeTime, firstMoney, lastMoney, practicalPaidMoney, shouldPaidMoney, fPCRemark);
			int row=fpcBiz.addFinancepurchaseclose(fpc);
			if(row>0){
				System.err.println("新增成功");
			}
			return "<script type='text/javascript'>parent.location.reload();</script>";
		
	}
	@RequestMapping("/allfpc.do")
	public @ResponseBody Map<String,Object> showfpc(){
		List<Financepurchaseclose> list=fpcBiz.allFinancepurchaseclose();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("code", 0);
		map.put("msg","");
		map.put("count", list.size());
		map.put("data",list);
		return map;
	}
	@RequestMapping("/deletefpc.do")
	public @ResponseBody int deleteFinancepurchaseclose(int financePurchaseCloseId){
		int row=fpcBiz.deleteFinancepurchaseclose(financePurchaseCloseId);
		return row;
	}
	@RequestMapping("/updatefpc.do")
	public @ResponseBody String updateFinancepurchaseclose(Financepurchaseclose fpc){
		int row=fpcBiz.upadteFinancepurchaseclose(fpc);
		return "<script type='text/javascript'>window.location.href='/Drugs-ERP/admin/finance/showPay.jsp';</script>";
	}
}
