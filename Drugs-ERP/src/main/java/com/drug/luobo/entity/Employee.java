package com.drug.luobo.entity;


public class Employee {
	private Integer employeeId;  //员工主键id
	private String	employeeName;//	员工登录名
	private String realName;	//员工真实姓名
	private String	employeePwd;//员工密码
	private Integer	employeeAge;//员工年龄
	private String	employeeSex;//员工性别
	private String	employeeTel;//联系方式
	private String	idCard;//身份证号码
	private String	headUrl;//头像url路径
	private String	addr;//地址
	private String	studyUndergo;//	学历
	private Integer	visibles;	//是否显示
	private String	describes;//	员工描述
	private Integer	roleId;//角色表Id
	private Integer	depId;//部门表外键
	private String joinTime; //入职时间
     
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
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
	public Integer getEmployeeAge() {
		return employeeAge;
	}
	public void setEmployeeAge(Integer employeeAge) {
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
	public Integer getVisibles() {
		return visibles;
	}
	public void setVisibles(Integer visibles) {
		this.visibles = visibles;
	}
	public String getdescribes() {
		return describes;
	}
	public void setdescribes(String describes) {
		this.describes = describes;
	}
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
	public String getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(String joinTime) {
		this.joinTime = joinTime;
	}
	public Employee() {
		super();
	}
	public Employee(String employeeName, String employeePwd) {
		super();
		this.employeeName = employeeName;
		this.employeePwd = employeePwd;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	
	 
	
}
