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
	 /**
	  * 功能：查询所有的日志文件
	  * @param logVo 用于模糊查询
	  * @return  日志对象的集合
	  */
	@RequestMapping("/loadAllLogInfo.do")
	@ResponseBody
	public LayuiTableData loadAllLogInfo(LoginLogVo logVo){
		return biz.queryAllLogInfo(logVo);
	} 
	/**
	 * 功能：根据日志id删除日志
	 * @param id  日志id
	 * @return  ResultObj
	 */
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
	/**
	 * 功能：批量删除日志文件
	 * @param logVo  日志对象
	 * @return  ResultObj
	 */
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
