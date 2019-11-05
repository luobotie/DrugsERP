package com.drug.luobo.biz;

import com.drug.luobo.untils.LayuiTableData;
import com.drug.luobo.untils.LoginLogVo;

public interface LoginLogBiz {

	/**
	 * 查询所有日志
	 * @param logInfoVo
	 * @return
	 */
	public LayuiTableData queryAllLogInfo(LoginLogVo logVo);
	/**
	 * 添加日志
	 * @param logInfoVo
	 */
	public void addLogInfo(LoginLogVo logVo);
	/**
	 * 根据id删除日志
	 * @param logInfoid
	 */
	public void deleteLogInfo(Integer logInfoid);
	/**
	 * 批量删除日志
	 * @param logInfoVo
	 */
	public void deleteBatchLogInfo(Integer [] ids);
}
