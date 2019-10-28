package com.drug.luobo.biz;

import java.util.List;

import com.drug.luobo.entity.Role;
import com.drug.luobo.untils.LayuiTableData;
import com.drug.luobo.untils.RoleVo;

public interface RoleBiz {
	List<Role> queryAllRole(RoleVo roleVo);
	Long getCount(RoleVo roleVo);
	Integer insert(Role role);
	Integer update(Role role);
	LayuiTableData initRoleMenuTreeJson(Integer roleid);
	void saveRoleMenu(RoleVo roleVo);
	Integer deleteRoleMenuByRid(Integer rid);
	Integer insertRoleMenu(Integer rid, Integer mid);
	void deleteRole(Integer roleid);
	void deleteBatchRole(Integer[] ids);
	Role checkRoleName(Role role);
	Role checkUpdateRoleName(Role role);
}
