package com.drug.dml.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.dml.biz.CheckProductBiz;
import com.drug.dml.entity.CheckProduct;
import com.drug.dml.mapper.CheckProductMapper;

@Service
public class CheckProductBizImpl implements CheckProductBiz{

	@Autowired
	private CheckProductMapper checkProductMapper;

	@Override
	public List<CheckProduct> selectAllCheckProduct(Integer page,Integer limit) {
		Integer pageno = (page-1) * limit;
		return checkProductMapper.selectAllCheckProduct(pageno, limit);
	}

	@Override
	public Integer countCheckProduct() {
		return checkProductMapper.countCheckProduct();
	}

	@Override
	public List<CheckProduct> getThisCheckProductInfo(Integer podId) {
		return checkProductMapper.getThisCheckProductInfo(podId);
	}

	@Override
	public Integer updateThisCheckProductStatus(CheckProduct checkProduct) {
		return checkProductMapper.updateThisCheckProductStatus(checkProduct);
	}

	@Override
	public Integer deleteCheckProductByPodId(Integer podId) {
		return checkProductMapper.deleteCheckProductByPodId(podId);
	}

	@Override
	public List<CheckProduct> getCheckProductWithStatus(String qualitystatus, Integer page, Integer limit) {
		Integer pageno = (page - 1) * limit;
		return checkProductMapper.getCheckProductWithStatus(qualitystatus, pageno, limit);
	}

	@Override
	public Integer countCheckProductWithStatus(String qualitystatus) {
		return checkProductMapper.countCheckProductWithStatus(qualitystatus);
	}

	@Override
	public Integer updateRealNum(CheckProduct checkProduct) {
		return checkProductMapper.updateRealNum(checkProduct);
	}

	@Override
	public Integer getDayPracticalQuantitySum(CheckProduct checkProduct) {
		return checkProductMapper.getDayPracticalQuantitySum(checkProduct);
	}

	@Override
	public Integer updateFinishNumber(Integer sum, Integer dpId) {
		return checkProductMapper.updateFinishNumber(sum, dpId);
	}

}
