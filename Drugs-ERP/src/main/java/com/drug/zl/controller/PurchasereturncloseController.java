package com.drug.zl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.zl.biz.PurchasereturncloseBiz;
import com.drug.zl.entity.Financepurchaseclose;
import com.drug.zl.entity.Financesellclose;
import com.drug.zl.entity.Purchasereturnclose;

@Controller
public class PurchasereturncloseController {
	@Autowired
	private PurchasereturncloseBiz prcBiz;
	@RequestMapping("/allprc.do")
	public @ResponseBody Map<String,Object> allPurchasereturnclose(){
		List<Purchasereturnclose> list=prcBiz.allPurchasereturncloses();
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg","");
		map.put("count", list.size());
		map.put("data",list);
		return map;
	}
	@RequestMapping("/deleteprc.do")
	public @ResponseBody int deletePurchasereturnclose(int purchasereturncloseId){
		int row=prcBiz.deletePurchasereturnclose(purchasereturncloseId);
		return row;
	}
	@RequestMapping("/addprc.do")
	public @ResponseBody String addPurchasereturnclose(Purchasereturnclose prc){
		System.err.println("经办人" + prc.getFinanceManId());
			//Financepurchaseclose fpc=new Financepurchaseclose(paidMoney, unPaidMoney, purchaseorderId, financeManId, closeTime, firstMoney, lastMoney, practicalPaidMoney, shouldPaidMoney, fPCRemark);
			int row=prcBiz.addPurchasereturnclose(prc);
			if(row>0){
				System.err.println("新增成功");
			}

			return "<script type='text/javascript'>parent.location.reload();</script>";
		
	}
	@RequestMapping("/updateprc.do")
	public @ResponseBody String updatePurchasereturnclose(Purchasereturnclose prc){
		int row=prcBiz.upadtePurchasereturnclose(prc);
		return "<script type='text/javascript'>window.location.href='/Drugs-ERP/admin/finance/receipt.jsp';</script>";
	}
}
