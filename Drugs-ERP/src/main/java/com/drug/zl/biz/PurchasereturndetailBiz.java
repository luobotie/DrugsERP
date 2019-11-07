package com.drug.zl.biz;

import java.util.List;

import com.drug.zl.entity.Purchasereturndetail;

public interface PurchasereturndetailBiz {
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
