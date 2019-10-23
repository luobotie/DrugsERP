package com.drug.djl.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.drug.djl.entity.BranchStoreInfo;

/**
 * 描述:分店信息管理表的Mapper映射接口（持久层）
 * @author djl
 * 2019年10月22日上午11:44:57
 * version:1.0
 */
public interface BranchStoreInfoMapper {
	
	/**
	 * 描述:查询所有分店信息的方法,分页查询
	 * @return 分店信息的集合
	 * 2019年10月23日上午11:06:22
	 */
	public List<BranchStoreInfo> selectAllBranchStore(Map<String , Object> branchPage);
	
	/**
	 * 
	 * 描述:分店信息表的行数
	 * @return
	 * 2019年10月23日上午11:06:08
	 */
	public Integer selectALLBranchStores();
}
