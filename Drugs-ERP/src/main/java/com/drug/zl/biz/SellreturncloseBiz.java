package com.drug.zl.biz;

import java.util.List;

import com.drug.zl.entity.Sellreturnclose;

public interface SellreturncloseBiz {
	/**
	 * 新增销售退货结算单
	 * @param 
	 * @return
	 */
	public int addSellreturnclose(Sellreturnclose src);
	/**
	 * 删除销售退货结算单
	 * @param 
	 * @return
	 */
	public int deleteSellreturnclose(int sellReturnCloseId);
	/**
	 * 修改采销售退货结算单
	 * @param 
	 * @return
	 */
	public int upadteSellreturnclose(Sellreturnclose src);
	/**
	 * 遍历销售退货结算单
	 * @return
	 */
	public List<Sellreturnclose> allSellreturnclose();
}
