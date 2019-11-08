package com.drug.hxb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drug.hxb.biz.StorageBiz;
import com.drug.hxb.biz.WarehouseBiz;
import com.drug.hxb.entity.MaterialInventory;
import com.drug.hxb.entity.PageLimit;
import com.drug.hxb.entity.Supplier;
import com.drug.hxb.entity.Warehouse;
import com.drug.hxb.entitytwo.MaterialSelects;
import com.drug.luobo.entity.Employee;

/**
 * 原料仓库
 * @author hxb
 *	@datetime 2019年10月29日上午8:39:00
 * 	@version: 1.0
 */
@RestController
public class StorageController {
	@Autowired
	private StorageBiz biz;
	@Autowired
	private WarehouseBiz wbiz;
	/**
	 * 获取原料库存的方法
	 * @return
	 */
	@RequestMapping("/getMaterialInventory")
	public Map<String,Object> getMaterialInventory(PageLimit pl,MaterialSelects ms){
		Map<String, Object> map=new HashMap<String,Object>();
		int begin=(pl.getPage()-1)*pl.getLimit();
		map.put("warId", ms.getWarId());
		map.put("supplierId", ms.getSupplierId());
		map.put("materialName", ms.getMaterialName());
		// TODO 调用查询原料总个数的方法
		int rows=biz.getMaterialInventoryCount(/*map*/);
		map.put("pages", begin);
		map.put("limits", pl.getLimit());
		//调用的查询库存的方法
		List<MaterialInventory> list=biz.getMaterialInventory(map);
		System.out.println(rows);
		//创建一个map集合装取库存对象
		Map<String, Object> map1=new HashMap<String,Object>();
		map1.put("code",0);
		map1.put("msg", "");
		map1.put("count", rows);
		map1.put("data",list);
		return map1;
	}
	/**
	 * 获取查询条件的方法
	 * @param pl
	 * @return
	 */
	@RequestMapping("/getWarehouseSelects")
	public Map<String,Object> getSelects(PageLimit pl){
		List<Warehouse> data =biz.getWarehouseSelects("原料仓库");
		int count=wbiz.getWarehouseCount();
		Map<String, Object> map2=new HashMap<String,Object>();
		map2.put("code",0);
		map2.put("msg", "");
		map2.put("count", count);
		map2.put("data",data);
		return map2;
	}
	/**
	 * 获取查询条件的方法
	 * @param pl
	 * @return
	 */
	@RequestMapping("/getSupplierSelects")
	public Map<String,Object> getSelects(){
		List<Supplier> data =biz.getSupplierSelects();
		int count=biz.getSupplierCounts();
		Map<String, Object> map2=new HashMap<String,Object>();
		map2.put("code",0);
		map2.put("msg", "");
		map2.put("count", count);
		map2.put("data",data);
		return map2;
	}
	/**
	 * 获取查询条件的方法
	 * @param pl
	 * @return
	 */
	@RequestMapping("/getEmployeeSelects")
	public Map<String,Object> getEmployeeSelects(){
		List<Employee> data =biz.getEmployeeSelects(2);
		int count=biz.getEmployeeCounts();
		Map<String, Object> map2=new HashMap<String,Object>();
		map2.put("code",0);
		map2.put("msg", "");
		map2.put("count", count);
		map2.put("data",data);
		return map2;
	}
}
