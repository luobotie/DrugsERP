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
import com.drug.luobo.untils.TreeNode;
import com.drug.luobo.untils.TreeNodeBuilder;
import com.drug.luobo.untils.WebUtils;

@Controller
public class MenusController {
    @Autowired
	private MenusBiz dao;
    @RequestMapping("/loadIndexLeftMenu.do")
    @ResponseBody
    public List<TreeNode> loadIndexLeftMenu(){
    	//得到用户对象
    	Employee employee = (Employee) WebUtils.getHttpSession().getAttribute("employee");
    	System.err.println(employee.getRoleId());
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
    	return TreeNodeBuilder.builder(nodes, 0);
    	
    	
    }
    @RequestMapping("/unlock.do")
    @ResponseBody
    public boolean unlock(String mima){
    	System.err.println(mima);
    	String pwd = DigestUtils.md5DigestAsHex(mima.getBytes());
    	Employee employee= (Employee) WebUtils.getHttpSession().getAttribute("employee");
    	if(pwd.equals(employee.getEmployeePwd())){
    		return true;
    	}else {
			return false;
		}
    	
    }
}
