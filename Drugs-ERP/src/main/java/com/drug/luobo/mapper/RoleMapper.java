package com.drug.luobo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.drug.luobo.entity.Role;
import com.drug.luobo.untils.RoleVo;

public interface RoleMapper {  
	List<Role> queryAllRole(RoleVo roleVo);
	Long getCount(RoleVo roleVo);
	Integer insert(Role role);
	Integer update(Role role);
	Integer deleteRoleMenuByRid(Integer rid);
	Integer insertRoleMenu(@Param("rid")Integer rid, @Param("mid")Integer mid);
	Integer deleteRole(Integer roleid);
	Role checkRoleName(Role role);
	Role checkUpdateRoleName(Role role);
}
