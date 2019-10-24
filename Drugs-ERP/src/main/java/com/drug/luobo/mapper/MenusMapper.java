package com.drug.luobo.mapper;

import java.util.List;

import com.drug.luobo.entity.Menus;

public interface MenusMapper {  
	List<Menus>  getAllMenusByRoleId(Integer roleId);
	
}
