package com.drug.hxb.bizimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.dml.entity.ProductType;
import com.drug.hxb.biz.StorageBiz;
import com.drug.hxb.entity.MaterialInventory;
import com.drug.hxb.entity.Supplier;
import com.drug.hxb.entity.Warehouse;
import com.drug.hxb.entitytwo.GoodsInventory;
import com.drug.hxb.entitytwo.MaterialSelects;
import com.drug.hxb.entitytwo.Orderproduct;
import com.drug.hxb.entitytwo.QualityDetailshxb;
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
	public int getMaterialInventoryCount(Map<String,Object> map) {
		return mapper.getMaterialInventoryCount(map);
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
	@Override
	public List<GoodsInventory> getGoodsInventory(Map<String, Object> map) {
		return mapper.getGoodsInventory(map);
	}
	@Override
	public int getGoodSselects(Map<String, Object> map) {
		return mapper.getGoodSselects(map);
	}
	@Override
	public List<ProductType> getGoodsType() {
		return mapper.getGoodsType();
	}
	@Override
	public int getGoodsTypeCounts() {
		return mapper.getGoodsTypeCounts();
	}
	@Override
	public List<QualityDetailshxb> getGoodsQualityDetails(Map<String,Object> map) {
		return mapper.getGoodsQualityDetails(map);
	}
	@Override
	public int addFinishedProductStorage(QualityDetailshxb qd) {
		return mapper.addFinishedProductStorage(qd);
	}
	@Override
	public int addFinishedProductStorageDetails(QualityDetailshxb qd) {
		return mapper.addFinishedProductStorageDetails(qd);
	}
	@Override
	public List<QualityDetailshxb> getGoodsQuality(Map<String, Object> map) {
		return mapper.getGoodsQuality(map);
	}
	@Override
	public int getGoodsQualityCount(Map<String,Object> map) {
		return mapper.getGoodsQualityCount(map);
	}
	@Override
	public int getGoodsQualityDetailsCount(Map<String,Object> map) {
		return mapper.getGoodsQualityDetailsCount(map);
	}
	@Override
	public int updateOrderproduct(Integer orderId) {
		return mapper.updateOrderproduct(orderId);
	}
	@Override
	public int addFStorage(QualityDetailshxb dp) {
		return mapper.addFStorage(dp);
	}
	@Override
	public List<GoodsInventory> selInventory(int proId) {
		return mapper.selInventory(proId);
	}
	@Override
	public int insertStorage(QualityDetailshxb qd) {
		return mapper.insertStorage(qd);
	}
}
