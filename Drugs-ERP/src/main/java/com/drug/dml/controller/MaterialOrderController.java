package com.drug.dml.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drug.dml.biz.MaterialOrderBiz;
import com.drug.dml.entity.MaterialOrder;

@RestController
public class MaterialOrderController {
	
	@Autowired
	private MaterialOrderBiz materialOrderBiz;
	
	/**
	 * 分页查询所有领料单
	 * @param page  当前页数
	 * @param limit 每页包含数
	 * @return map
	 */
	@RequestMapping("/getAllMaterialOrder.do")
	public Map<String, Object> getAllMaterialOrder(Integer page,Integer limit){
		//分页查询
		List<MaterialOrder> list = materialOrderBiz.selectAllMaterialOrder(page, limit);
		//查询获取月计划总数
		int count = materialOrderBiz.countAllMaterialOrder();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("code", 0);
		map.put("count", count);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 查询指定领料单详情(具体使用了哪些原材料)
	 * @param orderId 生产订单ID
	 * @param moId 领料单ID
	 * @return map
	 */
	@RequestMapping("/getMaterialInfo.do")
	public Map<String, Object> getMaterialInfo(Integer orderId,Integer moId){
		//分页查询
		List<MaterialOrder> list = materialOrderBiz.selectMaterialInfo(orderId, moId);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("code", 0);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 新增出库单
	 * @param moId 领料单Id
	 * @return
	 */
	@RequestMapping("/insertRawMaterialOutbound.do")
	public Integer insertRawMaterialOutbound(Integer moId){
		int count = 0;
		List<MaterialOrder> list = materialOrderBiz.selectMoId(moId);
		if (list.size() > 0) {
			System.out.println("进来了...");
			count = 0;
		}else{
			count = materialOrderBiz.insertRawMaterialOutbound(moId);
		}
		return count;
	}
	
	/**
	 * 刷新出库状态
	 * @param moId 领料单Id
	 * @return count
	 */
	@RequestMapping("/selectRawMaterialOutbound.do")
	public Integer selectRawMaterialOutbound(Integer moId){
		int count = 0;
		List<MaterialOrder> list = materialOrderBiz.selectMoId(moId);
		if (list.size() > 0) {
			Integer rmoId = materialOrderBiz.selectRmoIdTop();
			String rmoStatus = materialOrderBiz.selectRmoStatusByRmoId(rmoId);
			System.out.println(rmoStatus);
			if ("已出库".equals(rmoStatus)) {
				System.out.println("进来了...");
				count = materialOrderBiz.updateMaterialOrderStatus(moId);
			}else{
				count = 0;
			}
		}else{
			System.out.println("未提交数据");
			count = 0;
		}
		return count;
	}
	
	/**
	 * 修改领料单审核状态
	 * @param materialOrder 
	 * @return
	 */
	@RequestMapping("/updateThisMaterialOrderStatus.do")
	public Integer updateThisMaterialOrderStatus(MaterialOrder materialOrder){
		int count = materialOrderBiz.updateThisMaterialOrderStatus(materialOrder);
		return count;
	}
	
}
