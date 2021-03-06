package com.drug.hxb.biz;

import java.util.List;
import java.util.Map;

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
	/**
	 * 获取仓库的方法
	 * @param map 查询的仓库条件
	 * @return 仓库集合
	 */
	public List<Warehouse> getWarehouse(Map<String, Object> map);
	/**
	 * 获取仓库总数量的方法
	 * @return 仓库总数
	 */
	public int getWarehouseCount();
	/**
	 * 删除仓库的方法
	 * @param warId 仓库ID
	 * @return 删除结果
	 */
	public int delWarehouse(int warId);
	/**
	 * 修改仓库信息的方法
	 * @param warehouse 仓库对象
	 * @return 修改结果
	 */
	public int upWarehouse(Warehouse warehouse);
}
