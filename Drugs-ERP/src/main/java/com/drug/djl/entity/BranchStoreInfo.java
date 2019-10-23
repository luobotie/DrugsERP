package com.drug.djl.entity;

import org.springframework.stereotype.Component;

/**
 * 
 * 描述:分店信息表的实体类.
 * @author djl
 * 2019年10月17日
 * version:1.0
 */
@Component
public class BranchStoreInfo {
	private Integer bsiId;//分店主键
	private String bsName;//分店名称
	private String bslocation; // 地址
	private String bsopendate; //开业时间
	private Integer  empTable; // (外键)指向员工表(店长)
	private Integer crewSize;//员工人数
	private String contact;	//联系方式
	private String  email;	//电子邮箱
	private double regisiteredamount;//注册金额
	private String standByField1;//备用字段1
	private String standByField2;// 备用字段2
	
	public BranchStoreInfo() {
	}
	
	/**
	 * 
	 * constructors
	 * @param bsiId
	 * @param bsName
	 * @param bslocation
	 * @param bsopendate
	 * @param empTable
	 * @param crewSize
	 * @param contact
	 * @param email
	 * @param regisiteredamount
	 * @param standByField1
	 * @param standByField2
	 */
	public BranchStoreInfo(Integer bsiId, String bsName, String bslocation, String bsopendate, Integer empTable,
			Integer crewSize, String contact, String email, double regisiteredamount, String standByField1,
			String standByField2) {
		super();
		this.bsiId = bsiId;
		this.bsName = bsName;
		this.bslocation = bslocation;
		this.bsopendate = bsopendate;
		this.empTable = empTable;
		this.crewSize = crewSize;
		this.contact = contact;
		this.email = email;
		this.regisiteredamount = regisiteredamount;
		this.standByField1 = standByField1;
		this.standByField2 = standByField2;
	}
	public Integer getBsiId() {
		return bsiId;
	}
	public void setBsiId(Integer bsiId) {
		this.bsiId = bsiId;
	}
	public String getBsName() {
		return bsName;
	}
	public void setBsName(String bsName) {
		this.bsName = bsName;
	}
	public String getBslocation() {
		return bslocation;
	}
	public void setBslocation(String bslocation) {
		this.bslocation = bslocation;
	}
	public String getBsopendate() {
		return bsopendate;
	}
	public void setBsopendate(String bsopendate) {
		this.bsopendate = bsopendate;
	}
	public Integer getEmpTable() {
		return empTable;
	}
	public void setEmpTable(Integer empTable) {
		this.empTable = empTable;
	}
	public Integer getCrewSize() {
		return crewSize;
	}
	public void setCrewSize(Integer crewSize) {
		this.crewSize = crewSize;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getRegisiteredamount() {
		return regisiteredamount;
	}
	public void setRegisiteredamount(double regisiteredamount) {
		this.regisiteredamount = regisiteredamount;
	}
	public String getStandByField1() {
		return standByField1;
	}
	public void setStandByField1(String standByField1) {
		this.standByField1 = standByField1;
	}
	public String getStandByField2() {
		return standByField2;
	}
	public void setStandByField2(String standByField2) {
		this.standByField2 = standByField2;
	}
}
