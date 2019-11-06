package com.drug.luobo.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.luobo.biz.EmployeeBiz;
import com.drug.luobo.biz.LoginLogBiz;
import com.drug.luobo.entity.Employee;
import com.drug.luobo.entity.Role;
import com.drug.luobo.untils.EmployeeVo;
import com.drug.luobo.untils.LayuiTableData;
import com.drug.luobo.untils.LoginLogVo;
import com.drug.luobo.untils.ResultObj;
import com.drug.luobo.untils.WebUtils;

@Controller
public class EmployeeController {
	 @Autowired
	private EmployeeBiz biz;
	 @Autowired
	private LoginLogBiz loginBiz; 
	 @RequestMapping("/login.do")
	 @ResponseBody
     public boolean login(String loginUsername,String loginPassword ){
			// 明文123456
			// 生成密文
			String pwd = DigestUtils.md5DigestAsHex(loginPassword.getBytes());
			Employee employee=new Employee(loginUsername, pwd);
			EmployeeVo login = biz.longin(employee);
			if(login!=null){
				HttpSession session = WebUtils.getHttpSession();
				session.setAttribute("employee", login);
				//记录登陆日志 向loginlog里面插入数据
				LoginLogVo logInfoVo=new LoginLogVo();
				logInfoVo.setLogintime(new Date());
				logInfoVo.setLoginname(login.getEmployeeName()+"-"+login.getRealName());
				logInfoVo.setLoginip(WebUtils.getHttpServletRequest().getRemoteAddr());
				
				loginBiz.addLogInfo(logInfoVo);
				return true;
			}else {
				return false;
			}
			
	 }
	 
	 @RequestMapping("/loadAllEmp.do")
	 @ResponseBody
	 public LayuiTableData loadAllEmp(EmployeeVo eVo){
		 return biz.loadAllEmp(eVo);
	 }
	 @RequestMapping("/updateHeadImage.do")
	 @ResponseBody
	 public void  updateHeadImage(Employee employee){
		biz.updateHeadImage(employee);
	 }
	 
	    @RequestMapping("/checkAddEmpName.do")
	    @ResponseBody
	    public boolean  checkAddEmpName(String employeeName){
	    	 Employee checkAddEmpName = biz.checkAddEmpName(employeeName);
	    	if(checkAddEmpName!=null){
	    		return true;
	    	}else{
	    		return false;
	    	}
	    }
	    
	    @RequestMapping("/checkUpdateEmpName.do")
	    @ResponseBody
	    public boolean  checkUpdateEmpName(Employee employee){
	    	 Employee checkAddEmpName = biz.checkUpdateEmpName(employee);
	    	if(checkAddEmpName!=null){
	    		return true;
	    	}else{
	    		return false;
	    	}
	    }
	    @RequestMapping("/addEmp.do")
	    @ResponseBody
	    public ResultObj addEmp(Employee employee){
	    employee.setEmployeePwd(DigestUtils.md5DigestAsHex(employee.getEmployeePwd().getBytes()));
	    	try {
				this.biz.addEmp(employee);
				return ResultObj.ADD_SUCCESS;
			} catch (Exception e) {
				e.printStackTrace();
				return ResultObj.ADD_ERROR;
			}
	    }
	    @RequestMapping("/getAllRoleByDepId.do")
	    @ResponseBody
	    public List<Role> getAllRoleByDepId(Integer depId) {
			return biz.getAllRoleByDepId(depId);
		}
	    
	    @RequestMapping("/updateEmp.do")
	    @ResponseBody
	    public ResultObj updateEmp(Employee employee){
	    	try {
				this.biz.updateEmp(employee);
				return ResultObj.UPDATE_SUCCESS;
			} catch (Exception e) {
				e.printStackTrace();
				return ResultObj.UPDATE_ERROR;
			}
	    }
	    
	    @RequestMapping("/deleteEmpByEmpId.do")
	    @ResponseBody
	    public ResultObj deleteEmpByEmpId(Integer employeeId){
	    	try {
				this.biz.deleteEmpByEmpId(employeeId);
				return ResultObj.DELETE_SUCCESS;
			} catch (Exception e) {
				e.printStackTrace();
				return ResultObj.DELETE_ERROR;
			}
	    }
	    @RequestMapping("/restPwd.do")
	    @ResponseBody
	    public ResultObj restPwd(EmployeeVo eVo){
	    	System.err.println(eVo.getEmployeeId()+"\t"+eVo.getRestPwd());
	    	return biz.restPwd(eVo);
	    }
	    @RequestMapping("/updatePersonalInfo.do")
	    @ResponseBody
	    public ResultObj updatePersonalInfo(Employee employee){
	    	return biz.updatePersonalInfo(employee);
	    }
	    @RequestMapping("/checkOldPwdByEmpId.do")
	    @ResponseBody
	    public boolean checkOldPwdByEmpId(EmployeeVo eVo){
	    	return biz.checkOldPwdByEmpId(eVo);
	    }
	    @RequestMapping("/updateNewPwdByEmpId.do")
	    @ResponseBody
	    public ResultObj updateNewPwdByEmpId(EmployeeVo eVo){
	    	return biz.updateNewPwdByEmpId(eVo);
	    }
	  
}
