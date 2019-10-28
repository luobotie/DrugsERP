package com.drug.luobo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.luobo.biz.MenusBiz;
import com.drug.luobo.constast.SysConstast;
import com.drug.luobo.entity.Employee;
import com.drug.luobo.entity.Menus;
import com.drug.luobo.untils.LayuiPage;
import com.drug.luobo.untils.LayuiTableData;
import com.drug.luobo.untils.ResultObj;
import com.drug.luobo.untils.TreeNode;
import com.drug.luobo.untils.TreeNodeBuilder;
import com.drug.luobo.untils.WebUtils;
/**
 * 功能：菜单控制器
 * @author 罗波
 *
 */
@Controller
public class MenusController {
    @Autowired
	private MenusBiz dao;
    /**
     * 功能：加载主页面的左边的菜单
     * @return  菜单数据的集合
     */
    @RequestMapping("/loadIndexLeftMenu.do")
    @ResponseBody
    public List<TreeNode> loadIndexLeftMenu(){
    	//得到用户对象
    	Employee employee = (Employee) WebUtils.getHttpSession().getAttribute("employee");
    	List<Menus> list=dao.getAllMenusByRoleId(employee.getRoleId());
    	List<TreeNode> nodes= new ArrayList<TreeNode>();
    	//把list里面的数据放到nodes
    	for (Menus menu : list) {
    				Integer id=menu.getMid();
    				Integer pid=menu.getPid();
    				String title=menu.getTitle();
    				String icon=menu.getIcon();
    				String href=menu.getHref();
    				Boolean spread=menu.getSpread()==SysConstast.SPREAD_TRUE?true:false;
    				String target=menu.getTarget();
    				nodes.add(new TreeNode(id, pid, title, icon, href, spread, target));
    			}
    	//TreeNodeBuilder.builder将数据转成有层级结构数据
    	return TreeNodeBuilder.builder(nodes, 1);
    	
    	
    }
    /**
     * 功能：输入密码解锁页面锁定
     * @param mima 输入的密码
     * @return  真和假
     */
    @RequestMapping("/unlock.do")
    @ResponseBody
    public boolean unlock(String mima){
    	//将输入的密码转化为密文
    	String pwd = DigestUtils.md5DigestAsHex(mima.getBytes());
    	//获取session中的登录用户对象
    	Employee employee= (Employee) WebUtils.getHttpSession().getAttribute("employee");
    	if(pwd.equals(employee.getEmployeePwd())){
    		return true;
    	}else {
			return false;
		}
    	
    }
    /**
     * 功能：获得菜单管理页面的树形结构数据
     * @return
     */
    @RequestMapping("/loadMenuManagerLeftTree.do")
    @ResponseBody
    public LayuiTableData loadMenuManagerLeftTree(){
    	LayuiPage layuiPage=new LayuiPage();
    	layuiPage.setAvailable(SysConstast.AVAILABLE_TRUE);
    	List<Menus> list = dao.loadMenuManagerLeftTree(layuiPage);
    	List<TreeNode> nodes= new ArrayList<TreeNode>();
    	//把list里面的数据放到nodes
    	for (Menus menu : list) {
    				Integer id=menu.getMid();
    				Integer pid=menu.getPid();
    				String title=menu.getTitle();
    				String icon=menu.getIcon();
    				String href=menu.getHref();
    				Boolean spread=menu.getSpread()==SysConstast.SPREAD_TRUE?true:false;
    				String target=menu.getTarget();
    				nodes.add(new TreeNode(id, pid, title, icon, href, spread, target));
    			}
    	return new LayuiTableData(nodes);
    }
    /**
     * 功能：菜单管理页面右边的layui数据表格
     * @param layuiPage
     * @return
     */
    @RequestMapping("/loadAllMenu.do")
    @ResponseBody
    public LayuiTableData loadAllMenu(LayuiPage layuiPage){
    	layuiPage.setPage((layuiPage.getPage()-1)*layuiPage.getLimit());
    	layuiPage.setAvailable(SysConstast.AVAILABLE_TRUE);
    	List<Menus> list = dao.loadAllMenu(layuiPage);
    	Long count = dao.getCount(layuiPage);
    	return new LayuiTableData(count, list);
    	
    }
    /**
     * 功能：模糊查询菜单
     * @param layuiPage
     * @return
     */
    @RequestMapping("/moHuMenu.do")
    @ResponseBody
    public LayuiTableData moHuMenu(LayuiPage layuiPage){
    	layuiPage.setPage((layuiPage.getPage()-1)*layuiPage.getLimit());
    	List<Menus> list = dao.loadAllMenu(layuiPage);
    	Long count = dao.getCount(layuiPage);
    	return new LayuiTableData(count, list);
    	
    }
    /**
     * 功能：菜单管理页面新增一个菜单
     * @param layuiPage
     * @return
     */
    @RequestMapping("/addMenu")
    @ResponseBody
    public ResultObj addMenu(LayuiPage layuiPage){
    	try {
			this.dao.addMenu(layuiPage);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.ADD_ERROR;
		}
    	
    }
    /**
     * 功能：检测新增菜单名是否重复
     * @param layuiPage
     * @return
     */
    @RequestMapping("/checkTitle.do")
    @ResponseBody
    public boolean  checkTitle(LayuiPage layuiPage){
    	Menus checkTitle = dao.checkTitle(layuiPage);
    	if(checkTitle!=null){
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
    @RequestMapping("/checkUpdateTitle.do")
    @ResponseBody
    public  boolean checkUpdateTitle(LayuiPage layuiPage){
    	Menus checkUpdateTitle = dao.checkUpdateTitle(layuiPage);
    	if(checkUpdateTitle!=null){
    		return true;
    	}else{
    		return false;
    	}
    }
	/**
	 * 根据mid判断当前菜单有没有子节点
	 * 有返回code>=0
	 * 没有 返回code<0
	 */
    @RequestMapping("/checkMenuHasChildren.do")
    @ResponseBody
    public ResultObj  checkMenuHasChildren(LayuiPage layuiPage){
    	layuiPage.setAvailable(SysConstast.AVAILABLE_TRUE);
    	Integer count = dao.checkMenuHasChildren(layuiPage);
    	if(count>0) {
			return ResultObj.STATUS_TRUE;
		}else {
			return ResultObj.STATUS_FALSE;
		}
    	
    }
    /**
	 * 删除菜单
	 */
	@RequestMapping("/deleteMenu.do")
	@ResponseBody
   public ResultObj	deleteMenu(LayuiPage layuiPage){
		layuiPage.setAvailable(SysConstast.AVAILABLE_FALSE);
		try {
			this.dao.deleteMenu(layuiPage);
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELETE_ERROR;
		}
   }
	
	/**
	 * 修改菜单
	 */
	@RequestMapping("/updateMenu.do")
	@ResponseBody
	public ResultObj updateMenu(LayuiPage layuiPage) {
		try {
			this.dao.updateMenu(layuiPage);
			return ResultObj.UPDATE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.UPDATE_ERROR;
		}
	}
}
