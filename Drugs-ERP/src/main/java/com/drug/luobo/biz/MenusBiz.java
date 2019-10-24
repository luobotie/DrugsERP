package com.drug.luobo.biz;

import java.util.List;

import com.drug.luobo.entity.Menus;

public interface MenusBiz {
	List<Menus>  getAllMenusByRoleId(Integer roleId);
}
