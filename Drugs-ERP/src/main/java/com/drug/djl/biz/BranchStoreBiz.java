package com.drug.djl.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.drug.djl.entity.BranchStoreInfo;
import com.drug.djl.entity.Contract;
import com.drug.djl.entity.LikeSelectBS;

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
	List<BranchStoreInfo> selectAllBranchStore(LikeSelectBS likeSelectBS);
	
	/**
	 * 
	 * 描述:分店信息表的行数
	 * @return
	 * 2019年10月23日上午11:06:08
	 */
	Integer selectAllBranchStores(LikeSelectBS likeSelectBS);
	
	/**
	 * 描述:添加分店信息表
	 * @return 影响行数
	 * 2019年10月23日下午2:41:22
	 */
	int addBranchStore(BranchStoreInfo bStoreInfo) ;
	
	/**
	 * 
	 * 描述:删除分店信息表
	 * @param id
	 * @return
	 * 2019年10月25日上午10:09:05
	 */
	int deleteBranchStore(int id);
	
	/**
	 * 
	 * 描述:修改分店信息表
	 * @param id
	 * @return 受影响行数
	 * 2019年10月25日下午5:01:58
	 */
	int updateBranchStore(BranchStoreInfo bStoreInfo);
	
	/**
	 * 
	 * 描述:得到所有已签合同的分店
	 * @return 已签合同的分店
	 * 2019年11月1日上午9:15:45
	 */
	List<Contract> getAllBSContract();
}
