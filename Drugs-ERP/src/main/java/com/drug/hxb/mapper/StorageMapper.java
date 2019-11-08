package com.drug.hxb.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.drug.dml.entity.ProductType;
import com.drug.hxb.entity.FinalGoodsInventory;
import com.drug.hxb.entity.MaterialInventory;
import com.drug.hxb.entity.Supplier;
import com.drug.hxb.entity.Warehouse;
import com.drug.hxb.entitytwo.GoodsInventory;
import com.drug.hxb.entitytwo.MaterialSelects;
import com.drug.hxb.entitytwo.Orderproduct;
import com.drug.hxb.entitytwo.QualityDetailshxb;
import com.drug.luobo.entity.Employee;

/**
 *  @描述:原料仓mapper接口类 
 *  @author hxb
 *	@datetime 2019年10月29日上午8:47:38
 * 	@version: 1.0
 */
@Repository
public interface StorageMapper{
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
	public int getMaterialInventoryCount(Map<String,Object> map);
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
	/**
	 * 查询药品库存的方法
	 * @param map条件集合
	 * @return
	 */
	public List<GoodsInventory> getGoodsInventory(Map<String,Object> map);
	/**
	 * 查询药品条数的方法
	 * @param map
	 * @return
	 */
	public int getGoodSselects(Map<String,Object> map);
	/**
	 * 查询药品种类的方法
	 * @return
	 */
	public List<ProductType> getGoodsType();
	/**
	 * 查询药品种类数量的方法
	 */
	public int getGoodsTypeCounts();
	/**
	 * 查询成品质检单的方法
	 * @return
	 */
	public List<QualityDetailshxb> getGoodsQuality(Map<String,Object> map);
	/**
	 * 查询质检单表数量
	 * @param orderId
	 * @return
	 */
	public int getGoodsQualityCount(Map<String,Object> map);
	/**
	 * 查询成品质检单详情表的方法
	 * @return
	 */
	public List<QualityDetailshxb> getGoodsQualityDetails(Map<String,Object> map);
	/**
	 * 查询详情表数量
	 * @param orderId
	 * @return
	 */
	public int getGoodsQualityDetailsCount(Map<String,Object> map);
	/**
	 * 新增入库表
	 * @return 新增结果
	 */
	public int addFinishedProductStorage(QualityDetailshxb qd);
	/**
	 * 新增入库详情表
	 * @param qd
	 * @return
	 */
	public int addFinishedProductStorageDetails(QualityDetailshxb qd);
	/**
	 * 修改订单状态的方法
	 * @return
	 */
	public int updateOrderproduct(Integer orderId);
	/**
	 * 库存入库的方法
	 * @param op
	 * @return
	 */
	public int addFStorage(QualityDetailshxb qd);
	/**
	 * 查询成品库存的方法
	 * @param proId
	 * @return
	 */
	public List<GoodsInventory> selInventory(int proId);
	/**
	 * 库存入库的方法
	 * @param qd
	 * @return
	 */
	public int insertStorage(QualityDetailshxb qd);
}
