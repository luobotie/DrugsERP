package com.drug.hxb.entitytwo;
/**
 * @描述:原料仓查询条件实体类 
 *  @author hxb
 *	@datetime 2019年10月31日下午3:42:47
 * 	@version: 1.0
 */
public class MaterialSelects {
	private int warId;                     //仓库id
	private int supplierId;                		//供应商id
	private String materialName;				//药材名
	public int getWarId() {
		return warId;
	}
	public void setWarId(int warId) {
		this.warId = warId;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	
}
