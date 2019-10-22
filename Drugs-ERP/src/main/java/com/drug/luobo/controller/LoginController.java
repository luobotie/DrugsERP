package com.drug.luobo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.luobo.biz.EmployeeBiz;
import com.drug.luobo.entity.Employee;
import com.drug.luobo.untils.WebUtils;

@Controller
public class LoginController {
	 @Autowired
	private EmployeeBiz biz;
	 @RequestMapping("/login.do")
	 @ResponseBody
     public String login(String loginUsername,String loginPassword ){
			// 明文123456
			// 生成密文
			String pwd = DigestUtils.md5DigestAsHex(loginPassword.getBytes());
			Employee employee=new Employee(loginUsername, pwd);
			Employee login = biz.longin(employee);
			if(login!=null){
				HttpSession session = WebUtils.getHttpSession();
				session.setAttribute("employee", login);
				return "true";
			}else {
				return "false";
			}
			
	 }
}
