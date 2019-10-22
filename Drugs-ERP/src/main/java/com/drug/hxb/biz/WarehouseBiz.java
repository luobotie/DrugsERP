package com.drug.hxb.biz;

import com.drug.hxb.entity.Warehouse;

/**
 * @说明:仓库biz
 * @author hxb
 * @datetime 2019年10月21日下午4:09:54
 * @version 1.0
 */
public interface WarehouseBiz {
	/**
	 * 新增仓库的方法
	 * @param warehouse 仓库对象
	 * @return 新增结果
	 */
	public int addWarehouse(Warehouse warehouse);
}
