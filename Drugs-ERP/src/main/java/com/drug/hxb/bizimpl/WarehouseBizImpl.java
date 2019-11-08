package com.drug.hxb.bizimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.hxb.biz.WarehouseBiz;
import com.drug.hxb.entity.Warehouse;
import com.drug.hxb.mapper.WarehouseMapper;

/**
 * @说明:仓库biz实现类
 * @author hxb
 * @datetime 2019年10月21日下午4:12:28
 * @version 1.0
 */
@Service
public class WarehouseBizImpl implements WarehouseBiz{
	@Autowired
	private WarehouseMapper mapper;
	@Override
	public int addWarehouse(Warehouse warehouse) {
		return mapper.addWarehouse(warehouse);
	}
	@Override
	public List<Warehouse> getWarehouse(Map<String, Object> map) {
		List<Warehouse>	list=mapper.getWarehouse(map);
		if(list.size()==0) {
			System.out.println("没有找到仓库!");
		}
		return list;
	}
	@Override
	public int delWarehouse(int warId) {
		return mapper.delWarehouse(warId);
	}
	@Override
	public int upWarehouse(Warehouse warehouse) {
		return mapper.upWarehouse(warehouse);
	}
	@Override
	public int getWarehouseCount() {
		return mapper.getWarehouseCount();
	}
	
}
