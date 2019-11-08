package com.drug.luobo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/**
 * 功能：角色控制器
 * @author 罗波
 *
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.luobo.biz.RoleBiz;
import com.drug.luobo.entity.Role;
import com.drug.luobo.untils.LayuiTableData;
import com.drug.luobo.untils.ResultObj;
import com.drug.luobo.untils.RoleVo;
@Controller
public class RoleController {
    @Autowired
	private RoleBiz dao;
    
    /**
	 * 加载角色列表返回LayuiTableData
	 */
	@RequestMapping("/loadAllRole.do")
	@ResponseBody
	public LayuiTableData loadAllRole(RoleVo roleVo) {
		if(roleVo.getRolename()!=null && roleVo.getRolename()!=""){
			roleVo.setRolename(roleVo.getRolename().trim());
    	}
		if(roleVo.getRoledesc()!=null && roleVo.getRoledesc()!=""){
			roleVo.setRoledesc(roleVo.getRoledesc().trim());
    	}
		roleVo.setPage((roleVo.getPage()-1)*roleVo.getLimit());
		Long count=dao.getCount(roleVo);
		List<Role> list = dao.queryAllRole(roleVo);
		LayuiTableData lTableData=new LayuiTableData();
		lTableData.setCount(count);
		lTableData.setData(list);
		return  lTableData;
	}
	/**
	 * 新增角色
	 * @param role
	 * @return
	 */
	@RequestMapping("/addRole.do")
	@ResponseBody
	public ResultObj insert(Role role){
		try {
			this.dao.insert(role);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.ADD_ERROR;
		}
	}
	/**
	 * 修改角色
	 * @param role
	 * @return
	 */
	@RequestMapping("/updateRole.do")
	@ResponseBody
	public ResultObj updateRole(Role role){
		try {
			this.dao.update(role);
			return ResultObj.UPDATE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.UPDATE_ERROR;
		}
	}
	
	/**
	 * 删除角色
	 */
	@RequestMapping("/deleteRole.do")
	@ResponseBody
	public ResultObj deleteRole(RoleVo roleVo) {
		try {
			this.dao.deleteRole(roleVo.getRoleid());
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELETE_ERROR;
		}
	}
	/**
	 * 批量删除角色
	 */
	@RequestMapping("deleteBatchRole")
	@ResponseBody
	public ResultObj deleteBatchRole(RoleVo roleVo) {
		try {
			this.dao.deleteBatchRole(roleVo.getIds());
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELETE_ERROR;
		}
	}
	
	/**
	 * 加载角色管理分配菜单的json
	 */
	@RequestMapping("/initRoleMenuTreeJson.do")
	@ResponseBody
	public LayuiTableData initRoleMenuTreeJson(Integer roleid) {
		return this.dao.initRoleMenuTreeJson(roleid);
	}
	
	/**
	 * 保存角色和菜单的关系
	 */
	@RequestMapping("/saveRoleMenu.do")
	@ResponseBody
	public ResultObj saveRoleMenu(RoleVo roleVo) {
		try {
			this.dao.saveRoleMenu(roleVo);
			return ResultObj.DISPATCH_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DISPATCH_ERROR;
					
		}
	}
	 /**
     * 功能：检测新增菜单名是否重复
     * @param layuiPage
     * @return
     */
    @RequestMapping("/checkRoleName.do")
    @ResponseBody
    public boolean  checkRoleName(Role role){
    	Role checkRoleName = dao.checkRoleName(role);
    	if(checkRoleName!=null){
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
    @RequestMapping("/checkUpdateRoleName.do")
    @ResponseBody
    public  boolean checkUpdateRoleName(Role role){
    	Role checkUpdateRoleName = dao.checkUpdateRoleName(role);
    	if(checkUpdateRoleName!=null){
    		return true;
    	}else{
    		return false;
    	}
    }
    /**
     * 功能：将角色保存到部门
     * @param role
     * @return
     */
	@RequestMapping("/saveDepByRoleId.do")
	@ResponseBody
	public ResultObj saveDepByRoleId(Role role){
		try {
			this.dao.saveDepByRoleId(role);
			return ResultObj.UPDATE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.UPDATE_ERROR;
		}
	}
}
