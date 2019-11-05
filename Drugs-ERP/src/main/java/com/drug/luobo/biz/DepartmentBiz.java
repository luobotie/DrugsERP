package com.drug.luobo.biz;

import java.util.List;

import com.drug.luobo.entity.Department;
import com.drug.luobo.entity.Role;
import com.drug.luobo.untils.DepartmentVo;

public interface DepartmentBiz {
	 List<Department>  queryAllDepartment(DepartmentVo pVo);
	 Long getCount(DepartmentVo pVo); 
	 Integer  queryDepNum(Department department);
	 Integer addDepartment(Department department);
	 Integer updateDepartment(Department department);
	 Department checkDepName(Department department);
	 Department checkUpdateDepName(Department department);
	 void deleteDepartment(Integer depId);
	 Integer updateEmployee(Integer depId);
	 List<Role> getRoleByDepId(Integer depId);
	 List<Department> getAllDepAndvisibles();
	 Department queryDepNameBydepId(Integer depId);
}
