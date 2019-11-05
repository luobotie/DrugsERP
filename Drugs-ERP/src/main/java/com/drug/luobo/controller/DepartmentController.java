package com.drug.luobo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.luobo.biz.DepartmentBiz;
import com.drug.luobo.entity.Department;
import com.drug.luobo.untils.DepartmentVo;
import com.drug.luobo.untils.LayuiTableData;
import com.drug.luobo.untils.ResultObj;
@Controller
public class DepartmentController {
	@Autowired
	private DepartmentBiz dao;

	@RequestMapping("/loadAllDepartment.do")
	@ResponseBody
	public LayuiTableData loadAllDepartment(DepartmentVo pVo){
		if(pVo.getDepName()!=null && pVo.getDepName()!=""){
			pVo.setDepName(pVo.getDepName().trim());
		}
	    pVo.setPage((pVo.getPage()-1)*pVo.getLimit());
		LayuiTableData layuiTableData=new LayuiTableData();
		List<Department> list = dao.queryAllDepartment(pVo);
		Long count = dao.getCount(pVo);
		layuiTableData.setCount(count);
		layuiTableData.setData(list);
		return layuiTableData;
	}
	
	@RequestMapping("/queryDepNum.do")
	@ResponseBody
	public Integer queryDepNum(Department department){
              return dao.queryDepNum(department);
	}
	
	  @RequestMapping("/addDepartment")
	    @ResponseBody
	    public ResultObj addDepartment(Department department){
	    	try {
				this.dao.addDepartment(department);
				return ResultObj.ADD_SUCCESS;
			} catch (Exception e) {
				e.printStackTrace();
				return ResultObj.ADD_ERROR;
			}
	    	
	    }
	  @RequestMapping("/updateDepartment.do")
		@ResponseBody
		public ResultObj updateDepartment(Department department) {
			try {
				this.dao.updateDepartment(department);
				return ResultObj.UPDATE_SUCCESS;
			} catch (Exception e) {
				e.printStackTrace();
				return ResultObj.UPDATE_ERROR;
			}
		}
	  
	  /**
	     * 功能：检测新增菜单名是否重复
	     * @param layuiPage
	     * @return
	     */
	    @RequestMapping("/checkDepName.do")
	    @ResponseBody
	    public boolean  checkDepName(Department department){
	    	 Department checkDepName = dao.checkDepName(department);
	    	if(checkDepName!=null){
	    		return true;
	    	}else{
	    		return false;
	    	}
	    }
	    /**
	     * 功能：检测修改菜单名是否重复
	     * @param layuiPage
	     * @return
	     */
	    @RequestMapping("/checkUpdateDepName.do")
	    @ResponseBody
	    public  boolean checkUpdateTitle(Department department){
	    	 Department checkUpdateDepName = dao.checkUpdateDepName(department);
	    	if(checkUpdateDepName!=null){
	    		return true;
	    	}else{
	    		return false;
	    	}
	    }
	    @RequestMapping("/getAllDepAndvisibles.do")
	    @ResponseBody
	    public List<Department> getAllDepAndvisibles(){
	    	return dao.getAllDepAndvisibles();
	    }
	    @RequestMapping("/queryDepNameBydepId.do")
	    @ResponseBody
	    public Department queryDepNameBydepId(Integer depId){
	    	Department department = dao.queryDepNameBydepId(depId);
	    		return department;
	    }
}
