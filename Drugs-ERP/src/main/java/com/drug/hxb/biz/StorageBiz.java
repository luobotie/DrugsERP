package com.drug.hxb.biz;

import java.util.List;
import java.util.Map;

import com.drug.hxb.entity.MaterialInventory;
import com.drug.hxb.entity.Supplier;
import com.drug.hxb.entity.Warehouse;
import com.drug.hxb.entitytwo.MaterialSelects;
import com.drug.luobo.entity.Employee;

/**
 *  @描述: 原料仓的biz
 *  @author hxb
 *	@datetime 2019年10月29日上午8:43:08
 * 	@version: 1.0
 */
public interface StorageBiz {
	/**
	 * 查询原料库存的的方法
	 * @param map 条件集合
	 * @return 原料库存集合
	 */
	public List<MaterialInventory> getMaterialInventory(Map<String, Object> map);
	/**
	 * 查询原料总行数的方法
	 * @return 原料总个数
	 */
	public int getMaterialInventoryCount();
	/**
	 * 查询原料仓库的方法
	 * @return 仓库集合
	 */
	public List<Warehouse> getWarehouseSelects(String warType);
	/**
	 * 查询员工的方法
	 */
	public List<Employee> getEmployeeSelects(int roleId);
	/**
	 * 查询员工数量
	 * @return
	 */
	public int getEmployeeCounts();
	/**
	 * 查询供应商的方法
	 * @return
	 */
	public List<Supplier> getSupplierSelects();
	/**
	 * 查询供应商数量
	 * @return
	 */
	public int getSupplierCounts();
}
