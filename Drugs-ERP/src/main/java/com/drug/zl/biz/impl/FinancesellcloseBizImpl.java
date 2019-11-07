package com.drug.zl.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.zl.biz.FinancesellcloseBiz;
import com.drug.zl.entity.Financesellclose;
import com.drug.zl.mapper.FinancesellcloseMapper;
@Service
public class FinancesellcloseBizImpl implements FinancesellcloseBiz{
	@Autowired
	private FinancesellcloseMapper fscMapper;
	@Override
	public int addFinancesellclose(Financesellclose fsc) {
		return fscMapper.addFinancesellclose(fsc);
	}

	@Override
	public int deleteFinancesellclose(int financeSellCloseId) {
		return fscMapper.deleteFinancesellclose(financeSellCloseId);
	}

	@Override
	public int upadteFinancesellclose(Financesellclose fsc) {
		return fscMapper.upadteFinancesellclose(fsc);
	}

	@Override
	public List<Financesellclose> allFinancesellclose() {
		return fscMapper.allFinancesellclose();
	}
	
}
