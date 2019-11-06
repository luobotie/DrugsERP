package com.drug.luobo.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.luobo.biz.DepartmentBiz;
import com.drug.luobo.biz.RoleBiz;
import com.drug.luobo.entity.Department;
import com.drug.luobo.entity.Role;
import com.drug.luobo.mapper.DepartmentMapper;
import com.drug.luobo.untils.DepartmentVo;

@Service
public class DepartmentBizImpl implements DepartmentBiz {
     @Autowired
	private DepartmentMapper mapper;
     @Autowired
     private RoleBiz roleBiz;
	@Override
	public List<Department> queryAllDepartment(DepartmentVo pVo) {
		return mapper.queryAllDepartment(pVo);
	}

	@Override
	public Long getCount(DepartmentVo pVo) {
		return mapper.getCount(pVo);
	}

	@Override
	public Integer queryDepNum(Department department) {
		return mapper.queryDepNum(department);
	}

	@Override
	public Integer addDepartment(Department department) {
		return mapper.addDepartment(department);
	}

	@Override
	public Integer updateDepartment(Department department) {
		return mapper.updateDepartment(department);
	}

	@Override
	public Department checkDepName(Department department) {
		return mapper.checkDepName(department);
	}

	@Override
	public Department checkUpdateDepName(Department department) {
		return mapper.checkUpdateDepName(department);
	}

	@Override
	public void deleteDepartment(Integer depId) {
		mapper.deleteDepartment(depId);
		mapper.updateEmployee(depId);
		List<Role> list = mapper.getRoleByDepId(depId);
		for(Role r:list){
			roleBiz.deleteRole(r.getRoleid());
		}
	}

	@Override
	public Integer updateEmployee(Integer depId) {
		return mapper.updateEmployee(depId);
	}

	@Override
	public List<Role> getRoleByDepId(Integer depId) {
		return mapper.getRoleByDepId(depId);
	}

	@Override
	public List<Department> getAllDepAndvisibles() {
		return mapper.getAllDepAndvisibles();
	}

	@Override
	public Department queryDepNameBydepId(Integer depId) {
		return mapper.queryDepNameBydepId(depId);
	}
   
	
}
