package com.drug.luobo.biz;

import java.util.List;

import com.drug.luobo.entity.Employee;
import com.drug.luobo.entity.Menus;
import com.drug.luobo.untils.LayuiPage;

public interface MenusBiz {
	List<Menus>  getAllMenusByRoleId(Employee employee);
	List<Menus>  loadMenuManagerLeftTree(LayuiPage layuiPage);
	List<Menus>  loadAllMenu(LayuiPage layuiPage);
	Long getCount(LayuiPage layuiPage);
	Integer addMenu(LayuiPage layuiPage);
	Menus   checkTitle(LayuiPage layuiPage);
	Menus checkUpdateTitle(LayuiPage layuiPage);
	Integer checkMenuHasChildren(LayuiPage layuiPage);
	Integer	deleteMenu(LayuiPage layuiPage);
	Integer updateMenu(LayuiPage layuiPage);
}
