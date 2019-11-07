package com.drug.zl.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.zl.biz.SellreturncloseBiz;
import com.drug.zl.entity.Sellreturnclose;
import com.drug.zl.mapper.SellreturncloseMapper;
@Service
public class SellreturncloseBizImpl implements SellreturncloseBiz{
	@Autowired
	private SellreturncloseMapper srcMapper;
	@Override
	public int addSellreturnclose(Sellreturnclose src) {
		
		return srcMapper.addSellreturnclose(src);
	}

	@Override
	public int deleteSellreturnclose(int sellReturnCloseId) {
		return srcMapper.deleteSellreturnclose(sellReturnCloseId);
	}

	@Override
	public int upadteSellreturnclose(Sellreturnclose src) {
		return srcMapper.upadteSellreturnclose(src);
	}

	@Override
	public List<Sellreturnclose> allSellreturnclose() {
		return srcMapper.allSellreturnclose();
	}

}
