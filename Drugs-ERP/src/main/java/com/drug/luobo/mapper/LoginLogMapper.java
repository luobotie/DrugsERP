package com.drug.luobo.mapper;

import java.util.List;

import com.drug.luobo.entity.LoginLog;
import com.drug.luobo.untils.LoginLogVo;


public interface LoginLogMapper {
	 /**
     * 查询日志
     */
    List<LoginLog> queryAllLogInfo(LoginLogVo logVo);
    
    Integer insertLoginLog(LoginLogVo logVo);
    
    Integer deleteLoginLogById(Integer id);
    
    Long getCount(LoginLogVo logVo);
     
}
