package com.drug.djl.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drug.djl.biz.BranchStoreBiz;
import com.drug.djl.entity.BranchStoreInfo;
import com.drug.djl.entity.Contract;
import com.drug.djl.entity.LikeSelectBS;

/**
 * 
 * 描述:控制层
 * @author djl
 * 2019年10月23日上午9:33:28
 * version:1.0
 */
@RestController
public class BSController {
	@Autowired
	private BranchStoreBiz branchStoreBiz;
	
	/**
	 * 
	 * 描述:分页查询分店信息管理表
	 * @param page
	 * @param limit
	 * @return
	 * 2019年10月23日上午11:10:11
	 */
	@RequestMapping("selectAllBranchStore.do")
	public Map<String, Object> selectAllBranchStore(LikeSelectBS likeSelectBS) {
		System.out.println("模糊查询:"+likeSelectBS.getBsopendate());
		System.out.println("模糊查询:"+likeSelectBS.getBslocationCity());
		System.out.println("模糊查询:"+likeSelectBS.getBslocationPro());
		System.out.println("模糊查询:"+likeSelectBS.getLimit());
		//总行数
		int counts=branchStoreBiz.selectAllBranchStores(likeSelectBS);
		//为分页查询创建map
		Map<String, Object> branchPage=new HashMap<>();
		branchPage.put("page", (likeSelectBS.getPage()-1)*likeSelectBS.getLimit());//当前页数-1*每页显示数量
		branchPage.put("limit", likeSelectBS.getLimit());//每页显示数
		List<BranchStoreInfo> branchStores=branchStoreBiz.selectAllBranchStore(likeSelectBS);
		//分页查询的Map
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("count", counts);
		map.put("data", branchStores);
		return map;
	}
	
	/**
	 * 
	 * 描述:添加分店信息
	 * @param bStoreInfo
	 * @return
	 * 2019年10月25日上午10:11:24
	 */
	@RequestMapping("addBrachStore.do")
	public int addBrachStore(BranchStoreInfo bStoreInfo) {
		System.out.println(bStoreInfo.getBslocationPro());
		int row=branchStoreBiz.addBranchStore(bStoreInfo);
		return row;
	}
	
	
	@RequestMapping("deleteBranchStore.do")
	public int deleteBranchStore(int id) {
		int row=branchStoreBiz.deleteBranchStore(id);
		return row;
	}
	
	@RequestMapping("updateBranchStore.do")
	public int updateBranchStore(BranchStoreInfo bStoreInfo){
		int row=branchStoreBiz.updateBranchStore(bStoreInfo);
		return row;
	}
	
	@RequestMapping("getAllBSContract.do")
	public List<Contract> getAllBSContract() {
		List<Contract> bsContracts=branchStoreBiz.getAllBSContract();
		return bsContracts;
	}
	
}
