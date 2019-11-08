package com.drug.hxb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drug.hxb.biz.StorageBiz;
import com.drug.hxb.biz.WarehouseBiz;
import com.drug.hxb.entity.PageLimit;
import com.drug.hxb.entitytwo.GoodsInventory;
import com.drug.hxb.entitytwo.QualityDetailshxb;

/**
 * 描述:成品入库controller
 * @author hxb
 * @datetime 2019年11月6日上午10:29:35
 * @version 1.0
 */
@RestController
public class EnterhouseController {
	@Autowired
	private StorageBiz biz;
	@Autowired
	private WarehouseBiz wbiz;
	/**
	 * 获取质检单的方法
	 * @param pl
	 * @param orderId
	 * @return
	 */
	@RequestMapping("/getQualityhxb")
	public Map<String,Object> getQualityhxb(PageLimit pl,String orderIds){
		int orderId=0;
		if(orderIds !=null){
			orderId=Integer.parseInt(orderIds);
		}
		Map<String, Object> map1=new HashMap<String,Object>();
		map1.put("pages", (pl.getPage()-1)*pl.getLimit());
		map1.put("limits", pl.getLimit());
		map1.put("orderId", orderId);
		int count=biz.getGoodsQualityCount(map1);
		//获取质检单
		List<QualityDetailshxb> list=biz.getGoodsQuality(map1);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg","");
		map.put("count",count);
		map.put("data", list);
		return map;
	}
	/**
	 * 获取质检详情单表的方法
	 * @param pl
	 * @param orderId
	 * @return
	 */
	@RequestMapping("/getQualityDetailshxb")
	public Map<String,Object> getQualityDetailshxb(PageLimit pl,QualityDetailshxb qd){
		int orderId=qd.getOrderId();
		Map<String, Object> map1=new HashMap<String,Object>();
		map1.put("pages", (pl.getPage()-1)*pl.getLimit());
		map1.put("limits", pl.getLimit());
		map1.put("orderId", orderId);
		//获取药品列数
		int count=biz.getGoodsQualityDetailsCount(map1);
		//获取质检单详情表
		List<QualityDetailshxb> list=biz.getGoodsQualityDetails(map1);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg","");
		map.put("count",count);
		map.put("data", list);
		return map;
	}
	/**
	 * 成品入库的方法
	 * @param qd
	 * @return
	 */
	@RequestMapping("/addFinishedGoodswarehouse")
	public int addFinishedGoodswarehouse(QualityDetailshxb qd){
		int row=0;
		//调用插入入库表的方法
		int result=biz.addFinishedProductStorage(qd);
		System.out.println(result);
		System.out.println(qd.getFpsId());
		if(result!=0){
			//创建map集合装取查询条件
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("pages", 0);
			map.put("limits", 0);
			map.put("orderId", qd.getOrderId());
			int rows=0;
			//调用orderId查询出质检单/生产订单详情表
			List<QualityDetailshxb> qd1=biz.getGoodsQualityDetails(map);
			System.out.println(qd1.size());
			for(QualityDetailshxb qdh:qd1){
				qdh.setFpsId(qd.getFpsId());
				qdh.setWarId(qd.getWarId());
				System.out.println("药品名:"+qdh.getChineseName());
				//调用新增入库详情的方法
				int resultd=biz.addFinishedProductStorageDetails(qdh);
				System.out.println("入库详情新增结果"+resultd);
				if(resultd!=0){
					//调用查询库存中有无商品库存记录的方法
					List<GoodsInventory> git=biz.selInventory(qdh.getProId());
					int resultdw=0;
					if(git.size()!=0){
						//调用修改入库的方法
						resultdw=biz.addFStorage(qdh);
					}else{
						//调用新增入库的方法
						resultdw=biz.insertStorage(qdh);
					}
					System.out.println("仓库ID"+qdh.getWarId());
					System.out.println("入库结果"+resultdw);
					if(resultdw!=0){
						//调用修改订单状态的方法
						int resultdo=biz.updateOrderproduct(qd.getOrderId());
						if(resultdo!=0){
							rows=1;
						}
					}
				}
			}
			if(rows!=0){
				row=1;
			}
		}
		return row;
	}
}
