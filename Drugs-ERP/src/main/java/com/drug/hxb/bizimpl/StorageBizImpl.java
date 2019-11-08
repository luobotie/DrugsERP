package com.drug.hxb.bizimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.hxb.biz.StorageBiz;
import com.drug.hxb.entity.MaterialInventory;
import com.drug.hxb.entity.Supplier;
import com.drug.hxb.entity.Warehouse;
import com.drug.hxb.entitytwo.MaterialSelects;
import com.drug.hxb.mapper.StorageMapper;
import com.drug.luobo.entity.Employee;

/**
 *  @描述: 原料仓
 *  @author hxb
 *	@datetime 2019年10月29日上午8:45:35
 * 	@version: 1.0
 */
@Service
public class StorageBizImpl implements StorageBiz{
	@Autowired
	private StorageMapper mapper;
	@Override
	public List<MaterialInventory> getMaterialInventory(Map<String, Object> map) {
		return mapper.getMaterialInventory(map);
	}
	@Override
	public int getMaterialInventoryCount() {
		return mapper.getMaterialInventoryCount();
	}
	
	@Override
	public List<Warehouse> getWarehouseSelects(String warType) {
		return mapper.getWarehouseSelects(warType);
	}
	@Override
	public List<Employee> getEmployeeSelects(int roleId) {
		return mapper.getEmployeeSelects(roleId);
	}
	@Override
	public List<Supplier> getSupplierSelects() {
		return mapper.getSupplierSelects();
	}
	@Override
	public int getSupplierCounts() {
		return mapper.getSupplierCounts();
	}
	@Override
	public int getEmployeeCounts() {
		return mapper.getEmployeeCounts();
	}
}
