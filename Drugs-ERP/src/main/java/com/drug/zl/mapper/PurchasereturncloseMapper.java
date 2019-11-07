package com.drug.zl.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.drug.zl.entity.Purchasereturnclose;
@Repository
public interface PurchasereturncloseMapper {
	/**
	 * 新增采购退货结算单
	 * @param prc
	 * @return
	 */
	public int addPurchasereturnclose(Purchasereturnclose prc);
	/**
	 * 删除采购退货结算单
	 * @param purchasereturncloseId
	 * @return
	 */
	public int deletePurchasereturnclose(int purchasereturncloseId);
	/**
	 * 修改采购退货结算单
	 * @param prc
	 * @return
	 */
	public int upadtePurchasereturnclose(Purchasereturnclose prc);
	/**
	 * 遍历采购退货结算单
	 * @return
	 */
	public List<Purchasereturnclose> allPurchasereturncloses();
}
