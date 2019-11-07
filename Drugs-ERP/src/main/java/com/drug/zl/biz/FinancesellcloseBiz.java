package com.drug.zl.biz;

import java.util.List;

import com.drug.zl.entity.Financesellclose;

public interface FinancesellcloseBiz {
	/**
	 * 新增销售结算单
	 * @param prc
	 * @return
	 */
	public int addFinancesellclose(Financesellclose fsc);
	/**
	 * 删除销售结算单
	 * @param purchasereturncloseId
	 * @return
	 */
	public int deleteFinancesellclose(int financeSellCloseId);
	/**
	 * 修改销售结算单
	 * @param prc
	 * @return
	 */
	public int upadteFinancesellclose(Financesellclose fsc);
	/**
	 * 遍销售结算遍历单
	 * @return
	 */
	public List<Financesellclose> allFinancesellclose();
}
