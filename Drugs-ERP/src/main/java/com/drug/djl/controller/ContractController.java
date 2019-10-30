package com.drug.djl.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;

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
	
	/**
	 * 
	 * 描述:分页查询合同
	 * @param page
	 * @param limit
	 * @return
	 * 2019年10月29日下午4:06:09
	 */
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
	
	/**
	 * 
	 * 描述:添加合同
	 * @param contract
	 * @return
	 * 2019年10月29日下午4:07:07
	 */
	@RequestMapping("addContract.do")
	public int addContract(Contract contract) {
		int row=contractBiz.addContract(contract);
		return row;
	}
	/**
	 * 
	 * 描述:失效合同
	 * @param id
	 * @return
	 * 2019年10月29日下午4:08:09
	 */
	@RequestMapping("lostContract.do")
	public int lostContract(Integer id){
		Map<String, Object> map=new HashMap<>();
		Date date = new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String lostTime=format.format(date);
		//失效时间
		map.put("lost", "失效");
		map.put("lostTime", lostTime);
		map.put("id", id);
		int row=contractBiz.lostContract(map);
		return row;
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMDDHHmmssSS");
		String dates=format.format(date);
		System.out.println(dates);
		
	}
}
