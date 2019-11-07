package com.drug.zl.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.zl.biz.FinancepurchasecloseBiz;
import com.drug.zl.entity.Financepurchaseclose;
import com.drug.zl.mapper.FinancepurchasecloseMapper;
@Service
public class FinancepurchasecloseBizImpl implements FinancepurchasecloseBiz{
	@Autowired
	private FinancepurchasecloseMapper fpcMapper;
	@Override
	public int addFinancepurchaseclose(Financepurchaseclose fpc) {
		
		return fpcMapper.addFinancepurchaseclose(fpc);
	}

	@Override
	public int deleteFinancepurchaseclose(int financePurchaseCloseId) {
		return fpcMapper.deleteFinancepurchaseclose(financePurchaseCloseId);
	}

	@Override
	public int upadteFinancepurchaseclose(Financepurchaseclose fpc) {
		return fpcMapper.upadteFinancepurchaseclose(fpc);
	}

	@Override
	public List<Financepurchaseclose> allFinancepurchaseclose() {
		return fpcMapper.allFinancepurchaseclose();
	}

}
