package com.drug.djl.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.drug.djl.entity.BranchStoreInfo;

/**
 * 
 * 描述:分店信息业务逻辑层接口
 * @author djl
 * 2019年10月17日
 * version:1.0
 */
public interface BranchStoreBiz {
	/**
	 * 
	 * 描述:查询所有分店信息的方法
	 * @return 分店信息的集合
	 * 2019年10月23日
	 */
	public List<BranchStoreInfo> selectAllBranchStore(Map<String , Object> page);
	
	/**
	 * 
	 * 描述:分店信息表的行数
	 * @return
	 * 2019年10月23日上午11:06:08
	 */
	public Integer selectAllBranchStores();
}
