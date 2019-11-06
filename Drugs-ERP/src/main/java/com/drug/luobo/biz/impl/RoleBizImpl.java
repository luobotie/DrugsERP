package com.drug.luobo.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.luobo.biz.RoleBiz;
import com.drug.luobo.constast.SysConstast;
import com.drug.luobo.entity.Menus;
import com.drug.luobo.entity.Role;
import com.drug.luobo.mapper.MenusMapper;
import com.drug.luobo.mapper.RoleMapper;
import com.drug.luobo.untils.LayuiPage;
import com.drug.luobo.untils.LayuiTableData;
import com.drug.luobo.untils.RoleVo;
import com.drug.luobo.untils.TreeNode;
@Service
public class RoleBizImpl implements RoleBiz {
    @Autowired
	private RoleMapper mapper;
    @Autowired
    private MenusMapper menusMapper;
	@Override
	public List<Role> queryAllRole(RoleVo roleVo) {
		return mapper.queryAllRole(roleVo);
	}

	@Override
	public Long getCount(RoleVo roleVo) {
		return mapper.getCount(roleVo);
	}

	@Override
	public Integer insert(Role role) {
		return mapper.insert(role);
	}

	@Override
	public Integer update(Role role) {
		return mapper.update(role);
	}

	@Override
	public LayuiTableData initRoleMenuTreeJson(Integer roleid) {
		// 查询所有的可用的菜单
		LayuiPage layuiPage = new LayuiPage();
		layuiPage.setAvailable(SysConstast.AVAILABLE_TRUE);
		List<Menus> allMenu = menusMapper.loadMenuManagerLeftTree(layuiPage);
		// 根据角色ID查询当前角色拥有的菜单
		List<Menus> roleMenu = menusMapper.queryAllMenusByRoleId(roleid);
		List<TreeNode> data = new ArrayList<>();
		for (Menus m1 : allMenu) {
			String checkArr = SysConstast.CODE_ZERO+"";
			for (Menus m2 : roleMenu) {
				if (m1.getMid() == m2.getMid()) {
					checkArr = SysConstast.CODE_ONE+"";
					break;
				}
			}
			Integer id = m1.getMid();
			Integer pid = m1.getPid();
			String title = m1.getTitle();
			Boolean spread = m1.getSpread() == SysConstast.SPREAD_TRUE ? true : false;
			data.add(new TreeNode(id, pid, title, spread, checkArr));
		}
		return new LayuiTableData(data);
		
	}

	@Override
	public void saveRoleMenu(RoleVo roleVo) {
		Integer rid=roleVo.getRoleid();
		Integer [] mids=roleVo.getIds();
		//根据rid删除sys_role_menu里面所有数据
		this.mapper.deleteRoleMenuByRid(rid);
		//保存角色和菜单的关系
		for (Integer mid : mids) {
			this.mapper.insertRoleMenu(rid,mid);
		}
	}

	@Override
	public Integer deleteRoleMenuByRid(Integer rid) {
		return mapper.deleteRoleMenuByRid(rid);
	}

	@Override
	public Integer insertRoleMenu(Integer rid, Integer mid) {
		return mapper.insertRoleMenu(rid, mid);
	}

	@Override
	public void deleteRole(Integer roleid) {
		// 删除角色表的数据
		this.mapper.deleteRole(roleid);
		// 根据角色id删除menusrole里面的数据
		this.mapper.deleteRoleMenuByRid(roleid);
		this.mapper.updateEmpByRoleId(roleid);
	}

	@Override
	public void deleteBatchRole(Integer[] ids) {
		for (Integer rid : ids) {
			deleteRole(rid);
		}
		
	}

	@Override
	public Role checkRoleName(Role role) {
		return mapper.checkRoleName(role);
	}

	@Override
	public Role checkUpdateRoleName(Role role) {
		return mapper.checkUpdateRoleName(role);
	}

	@Override
	public void saveDepByRoleId(Role role) {
		   mapper.saveDepByRoleId(role);
	}
   
	
}
