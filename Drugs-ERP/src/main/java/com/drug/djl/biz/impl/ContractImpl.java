package com.drug.djl.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.djl.biz.ContractBiz;
import com.drug.djl.entity.Contract;
import com.drug.djl.mapper.ContractMapper;

/**
 * 
 * 描述:合同管理biz接口的实现类
 * @author djl
 * 2019年10月28日下午4:33:01
 * version:1.0
 */
@Service
public class ContractImpl implements ContractBiz{
	//注入Mapper接口
	@Autowired
	private ContractMapper contractMapper;
	@Override
	public int countContract() {
		return contractMapper.countContract();
	}

	@Override
	public List<Contract> getAllContract(Map<String, Object> map) {
		return contractMapper.getAllContract(map);
	}

	@Override
	public int addContract(Contract contract) {
		int row=contractMapper.addContract(contract);
		if (row == 1 ) {
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}
		return row;
	}
	
}
