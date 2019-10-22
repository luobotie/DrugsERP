package com.drug.hxb.mapper;

import org.springframework.stereotype.Repository;

import com.drug.hxb.entity.Warehouse;

/**
 * @说明:仓库接口
 * @author hxb
 * @datetime 2019年10月21日下午3:50:01
 * @version 1.0
 */
@Repository
public interface Warehousemapper {
	/**
	 * 新增仓库
	 * @param warehouse 仓库对象
	 * @return 新增的结果
	 */
	public int addWarehouse(Warehouse warehouse);
}
