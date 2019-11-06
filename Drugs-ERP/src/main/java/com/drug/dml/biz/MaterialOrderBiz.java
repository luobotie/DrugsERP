package com.drug.dml.biz;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.drug.dml.entity.MaterialOrder;

@Repository
public interface MaterialOrderBiz {

	List<MaterialOrder> selectAllMaterialOrder(Integer pageno,Integer pageSize);

	Integer countAllMaterialOrder();
	
	List<MaterialOrder> selectMaterialInfo(Integer orderId,Integer moId);
	
	Integer insertRawMaterialOutbound(Integer moId);
	
	Integer selectRmoIdTop();
	
	String selectRmoStatusByRmoId(Integer rmoId);
	
	Integer updateMaterialOrderStatus(Integer moId);
	
	List<MaterialOrder> selectMoId(Integer moId);
	
	Integer updateThisMaterialOrderStatus(MaterialOrder materialOrder);
}