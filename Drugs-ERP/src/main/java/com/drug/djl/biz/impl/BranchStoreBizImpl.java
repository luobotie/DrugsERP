package com.drug.djl.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.djl.biz.BranchStoreBiz;
import com.drug.djl.entity.BranchStoreInfo;
import com.drug.djl.mapper.BranchStoreInfoMapper;

/**
 * 
 * 描述:店铺业务逻辑层service层的实现类
 * @author djl
 * 2019年10月23日上午9:32:35
 * version:1.0
 */
@Service
public class BranchStoreBizImpl implements BranchStoreBiz {
	@Autowired
	private BranchStoreInfoMapper branchInfoMapper;
	
	@Override
	public List<BranchStoreInfo> selectAllBranchStore(Map<String , Object> branchPage) {
		return branchInfoMapper.selectAllBranchStore(branchPage);
	}

	@Override
	public Integer selectAllBranchStores() {
		return branchInfoMapper.selectALLBranchStores();
	}

	@Override
	public int addBranchStore() {
		return branchInfoMapper.addBranchStore();
	}

}
