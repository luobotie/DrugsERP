package com.drug.luobo.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.luobo.biz.LoginLogBiz;
import com.drug.luobo.entity.LoginLog;
import com.drug.luobo.mapper.LoginLogMapper;
import com.drug.luobo.untils.LayuiTableData;
import com.drug.luobo.untils.LoginLogVo;
@Service
public class LoginLogBizImpl implements LoginLogBiz {
    @Autowired
	private LoginLogMapper mapper;

	@Override
	public LayuiTableData queryAllLogInfo(LoginLogVo logVo) {
		LayuiTableData lTableData=new LayuiTableData();
		if(logVo.getStartTime()!=null && logVo.getStartTime()!=""){
			String[] split = logVo.getStartTime().split("~");
			logVo.setStartTime(split[0]);
			logVo.setEndTime(split[1]);
		}
		if(logVo.getLoginname()!=null && logVo.getLoginname()!=""){
		    logVo.setLoginname(logVo.getLoginname().trim());
		}
		if(logVo.getLoginip()!=null && logVo.getLoginip()!=""){
		    logVo.setLoginip(logVo.getLoginip().trim());
		}
		logVo.setPage((logVo.getPage()-1)*logVo.getLimit());
		List<LoginLog> list = mapper.queryAllLogInfo(logVo);
		Long count = mapper.getCount(logVo);
		lTableData.setData(list);
		lTableData.setCount(count);
		return lTableData;
	}

	@Override
	public void addLogInfo(LoginLogVo logVo) {
		mapper.insertLoginLog(logVo);
	}

	@Override
	public void deleteLogInfo(Integer logInfoid) {
		mapper.deleteLoginLogById(logInfoid);
		
	}

	@Override
	public void deleteBatchLogInfo(Integer[] ids) {
		for(Integer id:ids){
			deleteLogInfo(id);
		}
		
	}
   
	
}
