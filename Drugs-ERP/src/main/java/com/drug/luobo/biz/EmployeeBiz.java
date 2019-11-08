package com.drug.luobo.biz;


import java.util.List;

import com.drug.luobo.entity.Employee;
import com.drug.luobo.entity.Role;
import com.drug.luobo.untils.EmployeeVo;
import com.drug.luobo.untils.LayuiTableData;
import com.drug.luobo.untils.ResultObj;

public interface EmployeeBiz {
	 EmployeeVo longin(Employee employee);
	 LayuiTableData  loadAllEmp(EmployeeVo eVo);
	 Integer  updateHeadImage(Employee employee);
	 Employee checkAddEmpName(String employeeName);
	 Employee checkUpdateEmpName(Employee employee);
	 Integer  addEmp(Employee employee);
	 List<Role>  getAllRoleByDepId(Integer depId);
	 Integer updateEmp(Employee employee);
	 Integer deleteEmpByEmpId(Integer employeeId);
	 ResultObj restPwd(EmployeeVo eVo);
	 ResultObj updatePersonalInfo(Employee employee);
	 boolean  checkOldPwdByEmpId(EmployeeVo eVo);
	 ResultObj updateNewPwdByEmpId(EmployeeVo eVo);
	 void deleteBatchEmp(Integer[] ids);
}
