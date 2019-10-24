package com.drug.luobo.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.luobo.biz.MenusBiz;
import com.drug.luobo.entity.Menus;
import com.drug.luobo.mapper.MenusMapper;
@Service
public class MenusBizImpl implements MenusBiz {
    @Autowired
	private MenusMapper mapper;
	@Override
	public List<Menus> getAllMenusByRoleId(Integer roleId) {
		return mapper.getAllMenusByRoleId(roleId);
	}
}
