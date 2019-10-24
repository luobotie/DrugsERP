package com.drug.luobo.entity;

import org.springframework.stereotype.Component;

@Component
public class Role {
     private Integer roleId;
     private Integer depId;
     private String roleName;
     private String describe;
     private Integer visibles;
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getDepId() {
		return depId;
	}
	public void setDepId(Integer depId) {
		this.depId = depId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public Integer getVisibles() {
		return visibles;
	}
	public void setVisibles(Integer visibles) {
		this.visibles = visibles;
	}
	public Role() {
		super();
	}
     
     
}
