package com.drug.dml.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drug.dml.biz.CheckProductBiz;
import com.drug.dml.entity.CheckProduct;

@RestController
public class CheckProductConterller {

	@Autowired
	private CheckProductBiz checkProductBiz;
	
	/**
	 * 分页查询所有领料单
	 * @param page  当前页数
	 * @param limit 每页包含数o
	 * @return map
	 */
	@RequestMapping("/getAllCheckProduct.do")
	public Map<String, Object> getAllCheckProduct(Integer page,Integer limit){
		//分页查询
		List<CheckProduct> list = checkProductBiz.selectAllCheckProduct(page, limit);
		//查询获取月计划总数
		int count = checkProductBiz.countCheckProduct();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("code", 0);
		map.put("count", count);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 查询指定领料单的详情
	 * @param podId 领料单id
	 * @return map
	 */
	@RequestMapping("/getThisCheckProductInfo.do")
	public Map<String, Object> getThisCheckProductInfo(Integer podId){
		List<CheckProduct> list = checkProductBiz.getThisCheckProductInfo(podId);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("code", 0);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 修改质检状态
	 * @param checkProduct
	 * @return count
	 */
	@RequestMapping("/updateThisCheckProductStatus.do")
	public Integer updateThisCheckProductStatus(CheckProduct checkProduct){
		int count = checkProductBiz.updateThisCheckProductStatus(checkProduct);
		return count;
	}
	
	/**
	 * 删除指定质检单
	 * @param podId
	 * @return count
	 */
	@RequestMapping("/deleteCheckProductByPodId.do")
	public Integer deleteCheckProductByPodId(Integer podId){
		int count = checkProductBiz.deleteCheckProductByPodId(podId);
		return count;
	}
	
	/**
	 * 分页查询所有领料单
	 * @param page  当前页数
	 * @param limit 每页包含数o
	 * @return map
	 */
	@RequestMapping("/getCheckProductWithStatus.do")
	public Map<String, Object> getCheckProductWithStatus(String qualitystatus,Integer page,Integer limit){
		Map<String, Object> map=null;
		if ("-1".equals(qualitystatus)) {
			map = getAllCheckProduct(page,limit);
		}else{
			//分页查询
			List<CheckProduct> list = checkProductBiz.getCheckProductWithStatus(qualitystatus,page, limit);
			//查询获取月计划总数
			int count = checkProductBiz.countCheckProductWithStatus(qualitystatus);
			map=new HashMap<String, Object>();
			map.put("code", 0);
			map.put("count", count);
			map.put("data", list);
		}
		return map;
	}
	
	/**
	 * 查询指定状态的质检单数量
	 * @param qualitystatus  质检状态
	 * @return count
	 */
	@RequestMapping("/updateRealNum.do")
	public Integer updateRealNum(CheckProduct checkProduct){
		System.out.println("修改数量进来了...");
		Integer dpId = checkProduct.getDailyPlanid();
		System.out.println(dpId);
		int count = checkProductBiz.updateRealNum(checkProduct);
		Integer sum = checkProductBiz.getDayPracticalQuantitySum(checkProduct);
		System.out.println("数量:"+sum);
		checkProductBiz.updateFinishNumber(sum, dpId);
		return count;
	}
}
