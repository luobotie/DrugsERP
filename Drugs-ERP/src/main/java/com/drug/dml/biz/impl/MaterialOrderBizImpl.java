package com.drug.dml.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.dml.biz.MaterialOrderBiz;
import com.drug.dml.entity.CheckProduct;
import com.drug.dml.entity.MaterialOrder;
import com.drug.dml.mapper.MaterialOrderMapper;

@Service
public class MaterialOrderBizImpl implements MaterialOrderBiz{
	
	@Autowired
	private MaterialOrderMapper materialOrderMapper;

	@Override
	public List<MaterialOrder> selectAllMaterialOrder(Integer page,Integer limit) {
		Integer pageno=(page-1)*limit; 
		return materialOrderMapper.selectAllMaterialOrder(pageno,limit);
	}

	@Override
	public Integer countAllMaterialOrder() {
		return materialOrderMapper.countAllMaterialOrder();
	}

	@Override
	public List<MaterialOrder> selectMaterialInfo(Integer orderId, Integer moId) {
		return materialOrderMapper.selectMaterialInfo(orderId, moId);
	}

	@Override
	public Integer insertRawMaterialOutbound(Integer moId) {
		return materialOrderMapper.insertRawMaterialOutbound(moId);
	}

	@Override
	public Integer selectRmoIdTop() {
		return materialOrderMapper.selectRmoIdTop();
	}

	@Override
	public String selectRmoStatusByRmoId(Integer rmoId) {
		return materialOrderMapper.selectRmoStatusByRmoId(rmoId);
	}

	@Override
	public Integer updateMaterialOrderStatus(Integer moId) {
		return materialOrderMapper.updateMaterialOrderStatus(moId);
	}

	@Override
	public List<MaterialOrder> selectMoId(Integer moId) {
		return materialOrderMapper.selectMoId(moId);
	}

	@Override
	public Integer updateThisMaterialOrderStatus(MaterialOrder materialOrder) {
		return materialOrderMapper.updateThisMaterialOrderStatus(materialOrder);
	}

	@Override
	public Integer deleteMaterialOrderByMoId(Integer moId) {
		return materialOrderMapper.deleteMaterialOrderByMoId(moId);
	}

	@Override
	public Integer insertMaterialOrder(MaterialOrder materialOrder) {
		return materialOrderMapper.insertMaterialOrder(materialOrder);
	}

	@Override
	public Integer insertCheckProduct(CheckProduct checkProduct) {
		return materialOrderMapper.insertCheckProduct(checkProduct);
	}

	@Override
	public String selectMaterialOrderStatus(Integer orderId) {
		return materialOrderMapper.selectMaterialOrderStatus(orderId);
	}

	@Override
	public String selectMaterialOrderWarStatus(Integer orderId) {
		return materialOrderMapper.selectMaterialOrderWarStatus(orderId);
	}

	@Override
	public Integer updateOrderProductStatus(Integer orderId) {
		return materialOrderMapper.updateOrderProductStatus(orderId);
	}
	
	@Override
	public String selectCheckProductStatus(Integer orderId) {
		return materialOrderMapper.selectCheckProductStatus(orderId);
	}

	@Override
	public Integer updateOrderProductProStatus(Integer orderId) {
		return materialOrderMapper.updateOrderProductProStatus(orderId);
	}

	

}
