package com.drug.luobo.entity;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	private int employeeId;  //员工主键id
	private String	employeeName;//	员工姓名
	private String	employeePwd;//员工密码
	private int 	employeeAge;//员工年龄
	private String	employeeSex;//员工性别
	private String	employeeTel;//联系方式
	private String	idCard;//身份证号码
	private String	headUrl;//头像url路径
	private String	addr;//地址
	private String	studyUndergo;//	学历
	private String	visibles;	//是否显示
	private String	describe;//	员工描述
	private String	roleId;//角色表Id
	private String	depId;//部门表外键
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeePwd() {
		return employeePwd;
	}
	public void setEmployeePwd(String employeePwd) {
		this.employeePwd = employeePwd;
	}
	public int getEmployeeAge() {
		return employeeAge;
	}
	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}
	public String getEmployeeSex() {
		return employeeSex;
	}
	public void setEmployeeSex(String employeeSex) {
		this.employeeSex = employeeSex;
	}
	public String getEmployeeTel() {
		return employeeTel;
	}
	public void setEmployeeTel(String employeeTel) {
		this.employeeTel = employeeTel;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getHeadUrl() {
		return headUrl;
	}
	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getStudyUndergo() {
		return studyUndergo;
	}
	public void setStudyUndergo(String studyUndergo) {
		this.studyUndergo = studyUndergo;
	}
	public String getVisibles() {
		return visibles;
	}
	public void setVisibles(String visibles) {
		this.visibles = visibles;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getDepId() {
		return depId;
	}
	public void setDepId(String depId) {
		this.depId = depId;
	}
	public Employee() {
		super();
	}
	public Employee(String employeeName, String employeePwd) {
		super();
		this.employeeName = employeeName;
		this.employeePwd = employeePwd;
	}
	 
	
}
