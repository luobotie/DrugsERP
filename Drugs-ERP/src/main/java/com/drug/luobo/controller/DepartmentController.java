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
    /**
     * 功能：查询所有的部门
     * @param pVo
     * @return layui数据表格的格式
     */
	@RequestMapping("/loadAllDepartment.do")
	@ResponseBody
	public LayuiTableData loadAllDepartment(DepartmentVo pVo){
		if(pVo.getDepName()!=null && pVo.getDepName()!=""){
			pVo.setDepName(pVo.getDepName().trim());
		}
		//设置分页的信息
	    pVo.setPage((pVo.getPage()-1)*pVo.getLimit());
	    //新建一个layui数据表格的对象
		LayuiTableData layuiTableData=new LayuiTableData();
		//获取分页的数据集合
		List<Department> list = dao.queryAllDepartment(pVo);
		//获取查询的总个数
		Long count = dao.getCount(pVo);
		layuiTableData.setCount(count);
		layuiTableData.setData(list);
		return layuiTableData;
	}
	/**
	 * 功能：求该部门的员工人数
	 * @param department 部门对象
	 * @return  人数
	 */
	@RequestMapping("/queryDepNum.do")
	@ResponseBody
	public Integer queryDepNum(Department department){
              return dao.queryDepNum(department);
	}
	   /**
	    * 新增一个部门
	    * @param department 对象
	    * @return   ResultObj
	    */
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
	    /**
	     * 修改部门信息 
	     * @param department 对象 
	     * @return ResultObj
	     */
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
	    /**
	     * 功能：查询所有可用的部门
	     * @return 部门对象的集合
	     */
	    @RequestMapping("/getAllDepAndvisibles.do")
	    @ResponseBody
	    public List<Department> getAllDepAndvisibles(){
	    	return dao.getAllDepAndvisibles();
	    }
	    /**
	     * 功能：根据部门id查询该部门对象
	     * @param depId 部门id
	     * @return  部门对象
	     */
	    @RequestMapping("/queryDepNameBydepId.do")
	    @ResponseBody
	    public Department queryDepNameBydepId(Integer depId){
	    	Department department = dao.queryDepNameBydepId(depId);
	    		return department;
	    }
	    
	      /**
	       * 根据部门id删除部门
	       * @param depId
	       * @return
	       */
	    @RequestMapping("/deleteDepartment.do")
		@ResponseBody
		public ResultObj  deleteDepartment(Integer depId) {
			try {
				this.dao.deleteDepartment(depId);
				return ResultObj.DELETE_SUCCESS;
			} catch (Exception e) {
				e.printStackTrace();
				return ResultObj.DELETE_ERROR;
			}
		}
}
