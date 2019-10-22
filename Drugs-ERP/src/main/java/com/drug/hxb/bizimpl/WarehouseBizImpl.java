package com.drug.hxb.bizimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.hxb.biz.WarehouseBiz;
import com.drug.hxb.entity.Warehouse;
import com.drug.hxb.mapper.Warehousemapper;

/**
 * @说明:仓库biz实现类
 * @author hxb
 * @datetime 2019年10月21日下午4:12:28
 * @version 1.0
 */
@Service
public class WarehouseBizImpl implements WarehouseBiz{
	@Autowired
	private Warehousemapper map;
	@Override
	public int addWarehouse(Warehouse warehouse) {
		return map.addWarehouse(warehouse);
	}
	
}
