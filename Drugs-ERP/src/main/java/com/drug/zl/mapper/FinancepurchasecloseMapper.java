package com.drug.zl.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.drug.zl.entity.Financepurchaseclose;
@Repository
public interface FinancepurchasecloseMapper {
	/**
	 * 新增采购结算单
	 * @param prc
	 * @return
	 */
	public int addFinancepurchaseclose(Financepurchaseclose fpc);
	/**
	 * 删除采购算单
	 * @param purchasereturncloseId
	 * @return
	 */
	public int deleteFinancepurchaseclose(int financePurchaseCloseId);
	/**
	 * 修改采购结算单
	 * @param prc
	 * @return
	 */
	public int upadteFinancepurchaseclose(Financepurchaseclose fpc);
	/**
	 * 遍历采购退货结算单
	 * @return
	 */
	public List<Financepurchaseclose> allFinancepurchaseclose();
}
