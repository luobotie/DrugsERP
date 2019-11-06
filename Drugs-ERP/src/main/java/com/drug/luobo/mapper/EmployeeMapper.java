package com.drug.luobo.mapper;


import java.util.List;

import com.drug.luobo.entity.Employee;
import com.drug.luobo.entity.Role;
import com.drug.luobo.untils.EmployeeVo;

public interface EmployeeMapper {
	 //获取登录对象信息
	 EmployeeVo login(Employee employee);
     //layui分页+模糊查询分页数据
     List<EmployeeVo> loadAllEmp(EmployeeVo eVo);
     //layui分页+模糊查询数据总个数
     Long getCount(EmployeeVo eVo);
      //根据员工id修改该员工头像
     Integer  updateHeadImage(Employee employee);
     //接收form表单传过来的对象，进行新增
     Integer insertEmp(Employee employee);
     
     Employee checkAddEmpName(String employeeName);
     
     Employee checkUpdateEmpName(Employee employee);
     
     List<Role>  getAllRoleByDepId(Integer depId);
     //获取编辑后员工对象修改该员工
     Integer updateEmpByEmp(Employee employee);
      //根据员工id删除该员工
     Integer deleteEmpEmpId(Integer employeeId);
     
     Integer updateEmpPwdByEmpId(EmployeeVo eVo);
     
     Integer updatePersonalInfo(Employee employee);
     
     Employee checkOldPwdByEmpId(EmployeeVo eVo);
     
     Integer updateNewPwdByEmpId(EmployeeVo eVo);
     
}
