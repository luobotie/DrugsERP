package com.drug.zl.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.drug.zl.entity.Purchasereturndetail;
@Repository
public interface PurchasereturndetailMapper {
	/**
	 * 新增
	 * @param prd
	 * @return
	 */
	public int addPurchasereturndetail(Purchasereturndetail prd);
	/**
	 * 删除
	 * @param purchasereturndetailId
	 * @return
	 */
	public int deletePurchasereturndetail(int purchasereturndetailId);
	/**
	 * 修改
	 * @param prd
	 * @return
	 */
	public int updatePurchasereturndetail(Purchasereturndetail prd);
	/**
	 * 遍历
	 * @return
	 */
	public List<Purchasereturndetail> allPurchasereturndetails();
}
