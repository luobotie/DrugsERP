package com.drug.djl.biz;

import java.util.List;
import java.util.Map;

import com.drug.djl.entity.Contract;

/**
 * 
 * 描述:合同管理的业务逻辑层
 * @author djl
 * 2019年10月28日下午4:26:24
 * version:1.0
 */
public interface ContractBiz {
	/**
	 * 
	 * 描述:合同表的总行数
	 * @return 总行数
	 * 2019年10月28日下午4:20:58
	 */
	int countContract(Map<String, Object> map);
	
	/**
	 * 
	 * 描述:所有合同表对象
	 * @return 合同表的对象集合
	 * 2019年10月28日下午4:21:51
	 */
	List<Contract> getAllContract(Map<String, Object> map);
	
	/**
	 * 
	 * 描述:添加新的合同
	 * @param contract
	 * @return 受影响行数
	 * 2019年10月29日下午3:19:57
	 */
	int addContract(Contract contract);
	
	/**
	 * 
	 * 描述:更改合同状态
	 * @param id
	 * @return 受影响行数
	 * 2019年10月29日下午4:05:05
	 */
	int lostContract(Map<String,Object> map);
	
	/**
	 * 
	 * 描述:彻底删除某个合同
	 * @param id
	 * @return
	 * 2019年10月30日上午10:33:58
	 */
	int delContract(Integer id);
	
	/**
	 * 
	 * 描述:修改某个合同
	 * @param id
	 * @return
	 * 2019年10月31日下午3:26:58
	 */
	int updateContract(Contract contract);
}
