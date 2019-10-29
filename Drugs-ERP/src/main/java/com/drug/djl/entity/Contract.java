package com.drug.djl.entity;

/**
 * 
 * 描述:合同表的实体类
 * @author djl
 * 2019年10月28日下午3:26:03
 * version:1.0
 */
public class Contract {
	private int conID;	// 合同表主键
	private String conName; // 合同名称
	private String conType;// 合同类型(xxxx)
	private String conNum;	// 合同编号
	private String partyA;	// 我方身份(甲方)
	private String partyB;	// 乙方身份			
	private Double totalPrice;	//总金额
	private String conState;	//合同状态(草稿、生效，作废)
	private String conChange;	// 是否变更(默认为‘否’)			
	private int conUndertakerId; // 外键	承办人id			
	private String conContact;// 联系电话
	private int partyBId;   // 供应商id或者分店id，取决于合同类型		
	private String conEffectTime;// 合同生效时间
	private String conLostEffectTime;//合同失效时间
	private String conEndTime;	// 合同结束时间
	private String conAuditTime;// 合同签订时间
	private String note; // 备注
	private String standByField1; // 备用字段1
	private String standByField2; // 备用字段2
	
	
	public Contract() {
	}
	
	
	public Contract(int conID, String conName, String conType, String conNum, String partyA, String partyB,
			Double totalPrice, String conState, String conChange, int conUndertakerId, String conContact, int partyBId,
			String conEffectTime, String conLostEffectTime, String conEndTime, String conAuditTime, String note,
			String standByField1, String standByField2) {
		super();
		this.conID = conID;
		this.conName = conName;
		this.conType = conType;
		this.conNum = conNum;
		this.partyA = partyA;
		this.partyB = partyB;
		this.totalPrice = totalPrice;
		this.conState = conState;
		this.conChange = conChange;
		this.conUndertakerId = conUndertakerId;
		this.conContact = conContact;
		this.partyBId = partyBId;
		this.conEffectTime = conEffectTime;
		this.conLostEffectTime = conLostEffectTime;
		this.conEndTime = conEndTime;
		this.conAuditTime = conAuditTime;
		this.note = note;
		this.standByField1 = standByField1;
		this.standByField2 = standByField2;
	}
	public int getConID() {
		return conID;
	}
	public void setConID(int conID) {
		this.conID = conID;
	}
	public String getConName() {
		return conName;
	}
	public void setConName(String conName) {
		this.conName = conName;
	}
	public String getConType() {
		return conType;
	}
	public void setConType(String conType) {
		this.conType = conType;
	}
	public String getConNum() {
		return conNum;
	}
	public void setConNum(String conNum) {
		this.conNum = conNum;
	}
	public String getPartyA() {
		return partyA;
	}
	public void setPartyA(String partyA) {
		this.partyA = partyA;
	}
	public String getPartyB() {
		return partyB;
	}
	public void setPartyB(String partyB) {
		this.partyB = partyB;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getConState() {
		return conState;
	}
	public void setConState(String conState) {
		this.conState = conState;
	}
	public String getConChange() {
		return conChange;
	}
	public void setConChange(String conChange) {
		this.conChange = conChange;
	}
	public int getConUndertakerId() {
		return conUndertakerId;
	}
	public void setConUndertakerId(int conUndertakerId) {
		this.conUndertakerId = conUndertakerId;
	}
	public String getConContact() {
		return conContact;
	}
	public void setConContact(String conContact) {
		this.conContact = conContact;
	}
	public int getPartyBId() {
		return partyBId;
	}
	public void setPartyBId(int partyBId) {
		this.partyBId = partyBId;
	}
	public String getConEffectTime() {
		return conEffectTime;
	}
	public void setConEffectTime(String conEffectTime) {
		this.conEffectTime = conEffectTime;
	}
	public String getConLostEffectTime() {
		return conLostEffectTime;
	}
	public void setConLostEffectTime(String conLostEffectTime) {
		this.conLostEffectTime = conLostEffectTime;
	}
	public String getConEndTime() {
		return conEndTime;
	}
	public void setConEndTime(String conEndTime) {
		this.conEndTime = conEndTime;
	}
	public String getConAuditTime() {
		return conAuditTime;
	}
	public void setConAuditTime(String conAuditTime) {
		this.conAuditTime = conAuditTime;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
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
