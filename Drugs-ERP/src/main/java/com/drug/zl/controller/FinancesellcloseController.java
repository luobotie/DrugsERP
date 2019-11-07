package com.drug.zl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.zl.biz.FinancesellcloseBiz;
import com.drug.zl.entity.Financesellclose;

@Controller
public class FinancesellcloseController {
	@Autowired
	private FinancesellcloseBiz fscBiz;
	@RequestMapping("/allfsc.do")
	public @ResponseBody Map<String,Object> allFinancesellclose(){
		List<Financesellclose> list=fscBiz.allFinancesellclose();
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg","");
		map.put("count", list.size());
		map.put("data",list);
		return map;
	}
	@RequestMapping("/deletefsc.do")
	public int deleteFinancesellclose(int financeSellCloseId){
		int row=fscBiz.deleteFinancesellclose(financeSellCloseId);
		return row;
	}
	@RequestMapping("/addfsc.do")
	public @ResponseBody String addFinancesellclose(Financesellclose fsc){
		System.err.println("经办人"+fsc.getFinanceManId());
		int row=fscBiz.addFinancesellclose(fsc);
		if(row>0){
			System.err.println("新增成功");
		}

		return "<script type='text/javascript'>parent.location.reload();</script>";
	}
	@RequestMapping("/updatefsc.do")
	public @ResponseBody String updateFinancesellclose(Financesellclose fsc){
		int row=fscBiz.upadteFinancesellclose(fsc);
		return "<script type='text/javascript'>window.location.href='/Drugs-ERP/admin/finance/receipt.jsp';</script>";
	}
}
