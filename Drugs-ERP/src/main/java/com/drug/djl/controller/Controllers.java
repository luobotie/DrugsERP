package com.drug.djl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drug.djl.biz.BranchStoreBiz;
import com.drug.djl.biz.impl.BranchStoreBizImpl;
import com.drug.djl.entity.BranchStoreInfo;

/**
 * 
 * 描述:控制层
 * @author djl
 * 2019年10月23日上午9:33:28
 * version:1.0
 */
@Controller
@RestController
public class Controllers {
	@Autowired
	private BranchStoreBizImpl branchStoreBiz;
	
	/**
	 * 
	 * 描述:前台接受页数跟每页显示数
	 * @param page
	 * @param limit
	 * @return
	 * 2019年10月23日上午11:10:11
	 */
	@RequestMapping("selectAllBranchStore.do")
	public Map<String, Object> selectAllBranchStore(int page,int limit) {
		System.out.println(page);
		//为分页查询创建map
		Map<String, Object> branchPage=new HashMap<>();
		branchPage.put("page", (page-1)*limit);//当前页数*每页显示数量
		branchPage.put("limit", limit);//每页显示数
		List<BranchStoreInfo> branchStores=branchStoreBiz.selectAllBranchStore(branchPage);
		//总页数
		int counts=branchStoreBiz.selectAllBranchStores();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("count", counts);
		map.put("data", branchStores);
		return map;
	}
}
