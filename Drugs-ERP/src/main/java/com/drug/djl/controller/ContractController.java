package com.drug.djl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drug.djl.biz.ContractBiz;
import com.drug.djl.entity.BranchStoreInfo;
import com.drug.djl.entity.Contract;

/**
 * 
 * 描述:合同管理的控制层
 * @author djl
 * 2019年10月28日下午4:43:29
 * version:1.0
 */
@RestController
public class ContractController {
	@Autowired
	private ContractBiz contractBiz;

	@RequestMapping("getAllContract.do")
	public Map<String, Object> getAllContract(int page,int limit) {
		//总行数
		int counts=contractBiz.countContract();
		//为分页查询创建map
		Map<String, Object> branchPage=new HashMap<>();
		branchPage.put("page", (page-1)*limit);//当前页数-1*每页显示数量
		branchPage.put("limit", limit);//每页显示数
		List<Contract> contracts=contractBiz.getAllContract(branchPage);
		//分页查询的Map
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("count", counts);
		map.put("data", contracts);
		return map;
	}
	
	@RequestMapping("addContract.do")
	public int addContract(Contract contract) {
		int row=contractBiz.addContract(contract);
		return row;
	}
}
