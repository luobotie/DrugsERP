package com.drug.zl.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.zl.biz.PurchasereturncloseBiz;
import com.drug.zl.entity.Purchasereturnclose;
import com.drug.zl.mapper.PurchasereturncloseMapper;
@Service
public class PurchasereturncloseBizImpl implements PurchasereturncloseBiz{
	@Autowired
	private PurchasereturncloseMapper prcMapper;
	@Override
	public int addPurchasereturnclose(Purchasereturnclose prc) {
		
		return prcMapper.addPurchasereturnclose(prc);
	}

	@Override
	public int deletePurchasereturnclose(int purchasereturncloseId) {
		return prcMapper.deletePurchasereturnclose(purchasereturncloseId);
	}

	@Override
	public int upadtePurchasereturnclose(Purchasereturnclose prc) {
		return prcMapper.upadtePurchasereturnclose(prc);
	}

	@Override
	public List<Purchasereturnclose> allPurchasereturncloses() {
		
		return prcMapper.allPurchasereturncloses();
	}

}
