package com.drug.dml.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.drug.dml.entity.CheckProduct;

@Repository
public interface CheckProductBiz {

	List<CheckProduct> selectAllCheckProduct(Integer pageno,Integer pageSize);
	
	Integer countCheckProduct();
	
	List<CheckProduct> getThisCheckProductInfo(Integer podId);
	
	Integer updateThisCheckProductStatus(CheckProduct checkProduct);
	
	Integer deleteCheckProductByPodId(Integer podId);
	
	List<CheckProduct> getCheckProductWithStatus(String qualitystatus,Integer pageno,Integer pageSize);
	
	Integer countCheckProductWithStatus(String qualitystatus);
	
	Integer updateRealNum(CheckProduct checkProduct);
	
	Integer getDayPracticalQuantitySum(CheckProduct checkProduct);
	
	Integer updateFinishNumber(Integer sum,Integer dpId);
}
