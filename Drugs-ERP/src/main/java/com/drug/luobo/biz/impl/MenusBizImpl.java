package com.drug.luobo.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.luobo.biz.MenusBiz;
import com.drug.luobo.entity.Menus;
import com.drug.luobo.mapper.MenusMapper;
import com.drug.luobo.untils.LayuiPage;
@Service
public class MenusBizImpl implements MenusBiz {
    @Autowired
	private MenusMapper mapper;
	@Override
	public List<Menus> getAllMenusByRoleId(Integer roleId) {
		return mapper.getAllMenusByRoleId(roleId);
	}
	@Override
	public List<Menus> loadMenuManagerLeftTree(LayuiPage layuiPage) {
		return mapper.loadMenuManagerLeftTree(layuiPage);
	}
	@Override
	public List<Menus> loadAllMenu(LayuiPage layuiPage) {
		return mapper.loadAllMenu(layuiPage);
	}
	@Override
	public Long getCount(LayuiPage layuiPage) {
		return mapper.getCount(layuiPage);
	}
	@Override
	public Integer addMenu(LayuiPage layuiPage) {
		return mapper.addMenu(layuiPage);
	}
	@Override
	public Menus checkTitle(LayuiPage layuiPage) {
		return mapper.checkTitle(layuiPage);
	}
	@Override
	public Menus checkUpdateTitle(LayuiPage layuiPage) {
		return mapper.checkUpdateTitle(layuiPage);
	}
	@Override
	public Integer checkMenuHasChildren(LayuiPage layuiPage) {
		return mapper.checkMenuHasChildren(layuiPage);
	}
	@Override
	public Integer deleteMenu(LayuiPage layuiPage) {
		return mapper.deleteMenu(layuiPage);
	}
	@Override
	public Integer updateMenu(LayuiPage layuiPage) {
		return mapper.updateMenu(layuiPage);
	}
	
}
