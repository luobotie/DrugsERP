package com.drug.luobo.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.drug.luobo.biz.EmployeeBiz;
import com.drug.luobo.entity.Employee;
import com.drug.luobo.entity.Role;
import com.drug.luobo.mapper.EmployeeMapper;
import com.drug.luobo.untils.EmployeeVo;
import com.drug.luobo.untils.LayuiTableData;
import com.drug.luobo.untils.ResultObj;
@Service
public class EmployeeBizImpl implements EmployeeBiz {
    @Autowired
	private EmployeeMapper mapper;
	@Override
	public EmployeeVo longin(Employee employee) {
		return mapper.login(employee);
	}
	@Override
	public LayuiTableData loadAllEmp(EmployeeVo eVo) {
		LayuiTableData lTableData=new LayuiTableData();
		if(eVo.getJoinTime()!=null && eVo.getJoinTime()!=""){
			String[] split = eVo.getJoinTime().split("~");
			eVo.setStartTime(split[0]);
			eVo.setEndTime(split[1]);
		}
		if(eVo.getEmployeeName()!=null && eVo.getEmployeeName()!="" ){
			eVo.setEmployeeName(eVo.getEmployeeName().trim());
		}
		if(eVo.getRealName()!=null && eVo.getRealName()!="" ){
			eVo.setRealName(eVo.getRealName().trim());
		}
		if(eVo.getAddr()!=null && eVo.getAddr()!="" ){
			eVo.setAddr(eVo.getAddr().trim());
		}
		if(eVo.getDepName()!=null && eVo.getDepName()!="" ){
			eVo.setDepName(eVo.getDepName().trim());
		}
		if(eVo.getRolename()!=null && eVo.getRolename()!="" ){
			eVo.setRolename(eVo.getRolename().trim());
		}
		eVo.setPage((eVo.getPage()-1)*eVo.getLimit());
		List<EmployeeVo> list = mapper.loadAllEmp(eVo);
		Long count = mapper.getCount(eVo);
		lTableData.setData(list);
		lTableData.setCount(count);
		return lTableData;
	}
	@Override
	public Integer updateHeadImage(Employee employee) {
		return mapper.updateHeadImage(employee);
	}
	@Override
	public Employee checkAddEmpName(String employeeName) {
		return mapper.checkAddEmpName(employeeName);
	}
	@Override
	public Employee checkUpdateEmpName(Employee employee) {
		return mapper.checkUpdateEmpName(employee);
	}
	@Override
	public Integer addEmp(Employee employee) {
		return mapper.insertEmp(employee);
	}
	@Override
	public List<Role> getAllRoleByDepId(Integer depId) {
		return mapper.getAllRoleByDepId(depId);
	}
	@Override
	public Integer updateEmp(Employee employee) {
		return mapper.updateEmpByEmp(employee);
	}
	@Override
	public Integer deleteEmpByEmpId(Integer employeeId) {
		return mapper.deleteEmpEmpId(employeeId);
	}
	@Override
	public ResultObj restPwd(EmployeeVo eVo) {
	eVo.setRestPwd(DigestUtils.md5DigestAsHex(eVo.getRestPwd().getBytes()));
		try {
			this.mapper.updateEmpPwdByEmpId(eVo);
			return ResultObj.UPDATE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.UPDATE_ERROR;
		}
	}
	@Override
	public ResultObj updatePersonalInfo(Employee employee) {
		try {
			this.mapper.updatePersonalInfo(employee);
			return ResultObj.UPDATE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.UPDATE_ERROR;
		}
	}
	@Override
	public boolean checkOldPwdByEmpId(EmployeeVo eVo) {
		eVo.setOldPwd(DigestUtils.md5DigestAsHex(eVo.getOldPwd().getBytes()));
         Employee employee = mapper.checkOldPwdByEmpId(eVo);
         if(employee!=null){
        	 return true;
         }else {
        	 return false;
		}
		
	}
	@Override
	public ResultObj updateNewPwdByEmpId(EmployeeVo eVo) {
		eVo.setNewPwd(DigestUtils.md5DigestAsHex(eVo.getNewPwd().getBytes()));
		try {
			this.mapper.updateNewPwdByEmpId(eVo);
			return ResultObj.UPDATE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.UPDATE_ERROR;
		}
	}

}
