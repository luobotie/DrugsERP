package com.drug.hxb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.drug.hxb.biz.WarehouseBiz;
import com.drug.hxb.entity.Warehouse;

/**
 * @说明:仓库后台控制器
 * @author hxb
 * @datetime 2019年10月21日下午4:30:52
 * @version 1.0
 */
@RestController
public class WarehouseController {
	@Autowired
	private WarehouseBiz biz;
	/**
	 * 新增仓库的方法
	 * @param warehouse 仓库对象
	 * @return 新增结果
	 */
	@RequestMapping("/addWarehouse")
	public int addWarehouse(Warehouse warehouse) {
		//调用新增的方法
		int row=biz.addWarehouse(warehouse);
		return row;
	}
}
