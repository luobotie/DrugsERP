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
	 /**
	  * 功能：用于用户的登录和记录该用户的登录信息的日志
	  * @param loginUsername  登录名
	  * @param loginPassword   登录密码
	  * @return  一个员工对象
	  */
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
	 /**
	  * 功能：查询所有的员工信息
	  * @param eVo 用户模糊查询
	  * @return  所有员工对象的集合
	  */
	 @RequestMapping("/loadAllEmp.do")
	 @ResponseBody
	 public LayuiTableData loadAllEmp(EmployeeVo eVo){
		 return biz.loadAllEmp(eVo);
	 }
	 /**
	  * 功能：修改员工的头像路径
	  * @param employee  员工对象
	  */
	 @RequestMapping("/updateHeadImage.do")
	 @ResponseBody
	 public void  updateHeadImage(Employee employee){
		biz.updateHeadImage(employee);
	 }
	    /**
	     * 功能：检查新增员工的登录名是否重复
	     * @param employeeName  员工登录名
	     * @return  boolean
	     */
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
	    /**
	     * 功能：检查修改员工的登录名是否重复
	     * @param employee  员工对象
	     * @return boolean
	     */
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
	    /**
	     * 功能：新增员工信息 
	     * @param employee 员工对象
	     * @return ResultObj
	     */
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
	    /**
	     * 功能：根据部门id查询该部门下所有的角色
	     * @param depId 部门id
	     * @return  角色对象的集合
	     */
	    @RequestMapping("/getAllRoleByDepId.do")
	    @ResponseBody
	    public List<Role> getAllRoleByDepId(Integer depId) {
			return biz.getAllRoleByDepId(depId);
		}
	    /**
	     * 功能：修改员工信息
	     * @param employee 员工对象
	     * @return  ResultObj 
	     */
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
	    /**
	     * 功能：删除部门
	     * @param employeeId  部门id
	     * @return   ResultObj
	     */
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
	    /**
	     * 功能：重置用户密码
	     * @param eVo 员工对象
	     * @return ResultObj
	     */
	    @RequestMapping("/restPwd.do")
	    @ResponseBody
	    public ResultObj restPwd(EmployeeVo eVo){
	    	return biz.restPwd(eVo);
	    }
	    /**
	     * 功能：修改个人信息
	     * @param employee 员工对象
	     * @return ResultObj
	     */
	    @RequestMapping("/updatePersonalInfo.do")
	    @ResponseBody
	    public ResultObj updatePersonalInfo(Employee employee){
	    	return biz.updatePersonalInfo(employee);
	    }
	    /**
	     * 功能：用户修改自己的密码，验证原来的密码
	     * @param eVo 员工对象
	     * @return  boolean
	     */
	    @RequestMapping("/checkOldPwdByEmpId.do")
	    @ResponseBody
	    public boolean checkOldPwdByEmpId(EmployeeVo eVo){
	    	return biz.checkOldPwdByEmpId(eVo);
	    }
	    /**
	     * 功能：根据员工id，修改密码
	     * @param eVo  员工对象
	     * @return  ResultObj
	     */
	    @RequestMapping("/updateNewPwdByEmpId.do")
	    @ResponseBody
	    public ResultObj updateNewPwdByEmpId(EmployeeVo eVo){
	    	return biz.updateNewPwdByEmpId(eVo);
	    }
	  
}
