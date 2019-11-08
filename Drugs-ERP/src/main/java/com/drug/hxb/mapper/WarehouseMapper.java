package com.drug.hxb.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.drug.hxb.entity.Warehouse;

/**
 * @说明:仓库接口
 * @author hxb
 * @datetime 2019年10月21日下午3:50:01
 * @version 1.0
 */
@Repository
public interface WarehouseMapper {
	/**
	 * 新增仓库
	 * @param warehouse 仓库对象
	 * @return 新增的结果
	 */
	public int addWarehouse(Warehouse warehouse);
	/**
	 * 获取仓库的方法
	 * @param map 查询条件map集合
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
	 * @param warid 仓库ID
	 * @return 删除结果
	 */
	public int delWarehouse(int warid);
	/**
	 * 修改仓库信息的方法
	 * @param warehouse 仓库对象
	 * @return 修改结果
	 */
	public int upWarehouse(Warehouse warehouse);
}
