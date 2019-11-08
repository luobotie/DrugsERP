package com.drug.hxb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drug.dml.entity.ProductType;
import com.drug.hxb.biz.StorageBiz;
import com.drug.hxb.biz.WarehouseBiz;
import com.drug.hxb.entity.MaterialInventory;
import com.drug.hxb.entity.PageLimit;
import com.drug.hxb.entity.Supplier;
import com.drug.hxb.entity.Warehouse;
import com.drug.hxb.entitytwo.GoodsInventory;
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
		int rows=biz.getMaterialInventoryCount(map);
		map.put("pages", begin);
		map.put("limits", pl.getLimit());
		//调用的查询库存的方法
		List<MaterialInventory> list=biz.getMaterialInventory(map);
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
	public Map<String,Object> getSelects(String warType){
		System.out.println(warType);
		List<Warehouse> data =biz.getWarehouseSelects(warType);
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
	public Map<String,Object> getEmployeeSelects(HttpServletRequest request){
		//List<Employee> data =biz.getEmployeeSelects(2);
		HttpSession session = request.getSession();
		Employee emp=(Employee) session.getAttribute("employee");
		List<Employee> list=new ArrayList<Employee>();
		System.out.println(emp.getEmployeeName());
		list.add(emp);
		//int count=biz.getEmployeeCounts();
		int count=list.size();
		Map<String, Object> map2=new HashMap<String,Object>();
		map2.put("code",0);
		map2.put("msg", "");
		map2.put("count", count);
		map2.put("data",list);
		return map2;
	}
	/**
	 * 查询成品库存的方法
	 * @return 成品json
	 */
	@RequestMapping("/getGoodsInventory")
	public Map<String,Object> getGoodsInventory(PageLimit pl,MaterialSelects ms){
		Map<String, Object> map=new HashMap<String,Object>();
		int begin=(pl.getPage()-1)*pl.getLimit();
		map.put("warId", ms.getWarId());
		
		String mName=ms.getMaterialName();
		if(mName.equals("")){
			mName=null;
		}
		map.put("proTypeId", ms.getProTypeId());
		map.put("materialName", mName);
		// TODO 调用查询药品总个数的方法
		int rows=biz.getGoodSselects(map);
		map.put("pages", begin);
		map.put("limits", pl.getLimit());
		//调用的查询库存的方法
		List<GoodsInventory> list=biz.getGoodsInventory(map);
		//创建一个map集合装取库存对象
		Map<String, Object> map1=new HashMap<String,Object>();
		map1.put("code",0);
		map1.put("msg", "");
		map1.put("count", rows);
		map1.put("data",list);
		return map1;
	}
	/**
	 * 查询药品种类的方法
	 * @return
	 */
	@RequestMapping("/getGoodsType")
	public Map<String,Object> getGoodsType(){
		List<ProductType> list=biz.getGoodsType();
		int rows=biz.getGoodsTypeCounts();
		Map<String, Object> map1=new HashMap<String,Object>();
		map1.put("code",0);
		map1.put("msg", "");
		map1.put("count", rows);
		map1.put("data",list);
		return map1;
	}
}
