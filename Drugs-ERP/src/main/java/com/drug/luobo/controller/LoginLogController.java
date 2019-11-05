package com.drug.luobo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.luobo.biz.LoginLogBiz;
import com.drug.luobo.untils.LayuiTableData;
import com.drug.luobo.untils.LoginLogVo;
import com.drug.luobo.untils.ResultObj;

@Controller
public class LoginLogController {
	 @Autowired
	private LoginLogBiz biz;
	 
	@RequestMapping("/loadAllLogInfo.do")
	@ResponseBody
	public LayuiTableData loadAllLogInfo(LoginLogVo logVo){
		return biz.queryAllLogInfo(logVo);
	} 
	@RequestMapping("/deleteLogInfo.do")
	@ResponseBody
	public ResultObj deleteLogInfo(Integer id){
		try {
			this.biz.deleteLogInfo(id);
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELETE_ERROR;
		}
	}
	@RequestMapping("/deleteBatchLogInfo.do")
	@ResponseBody
	public ResultObj deleteBatchLogInfo(LoginLogVo logVo){
		try {
			this.biz.deleteBatchLogInfo(logVo.getIds());;
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELETE_ERROR;
		}
	}
}
