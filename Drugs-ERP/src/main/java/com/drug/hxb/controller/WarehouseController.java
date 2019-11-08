package com.drug.hxb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.drug.hxb.biz.WarehouseBiz;
import com.drug.hxb.entity.PageLimit;
import com.drug.hxb.entity.Warehouse;

/**
 * @说明:仓库后台控制器
 * @author hxb
 * @datetime 2019年10月21日下午4:30:52
 * @version 1.0
 */
@Controller
public class WarehouseController {
	@Autowired
	private WarehouseBiz biz;
	/**
	 * 新增仓库的方法
	 * @param warehouse 仓库对象
	 * @return 新增结果
	 */
	@RequestMapping("/addWarehouse")
	@ResponseBody
	public int addWarehouse(Warehouse warehouse) {
		System.out.println("进入了后台新增方法");
		//调用新增的方法
		int row=biz.addWarehouse(warehouse);
		return row;
	}
	/**
	 * 查询仓库的方法
	 * @param pl 分页条件
	 * @return 仓库集合的json对象
	 */
	@RequestMapping("/getWarehouse")
	@ResponseBody
	public Map<String,Object> getWarehouse(PageLimit pl,String warType){
		//创建一个map集合装取查询条件
		Map<String, Object> map=new HashMap<String,Object>();
		//计算分页的开始位置
		int page=pl.getLimit()*(pl.getPage()-1);
		//将pages装入map集合
		map.put("pages", page);
		//将limits装入map集合
		map.put("limits", pl.getLimit());
		//判断前台的仓库类型字符为空
		if(warType.equals("")){
			warType=null;
		}
		//将仓库类型装入map集合
		map.put("warType", warType);
		//调用查询仓库的方法
		List<Warehouse> list=biz.getWarehouse(map);
		//调用仓库总数的方法
		int rows=biz.getWarehouseCount();
		//创建一个map集合装取对象
		Map<String, Object> maps=new HashMap<String,Object>();
		maps.put("code", 0);
		maps.put("msg", "");
		maps.put("count", rows);
		maps.put("data", list);
		//返回map集合
		return maps;
	}
	/**
	 * 删除仓库的方法
	 * @param warId 仓库ID
	 * @return 删除的结果
	 */
	@RequestMapping("/delWarehouse")
	@ResponseBody
	public int delWarehouse(String warId){
		//定义一个变量
		int id=0;
		//判断仓库ID是不是有效
		if(warId!=null||!"".equals(warId)){
			//将字符串类型转换成int类型
			id=Integer.parseInt(warId);
		}
		//调用删除仓库的方法
		int row=biz.delWarehouse(id);
		return row;
	}
	@RequestMapping("/upWarehouse")
	@ResponseBody
	public int upWarehouse(Warehouse warehouse){
		System.out.println("进入修改后台");
		int rows=3;
		System.out.println(warehouse.getWarId());
		int row=biz.upWarehouse(warehouse);
		if(row==1){
			rows=2;
		}
		return rows;
	}
}
