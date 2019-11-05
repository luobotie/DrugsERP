package com.drug.luobo.untils;

import com.drug.luobo.entity.Department;

public class DepartmentVo extends Department{
    private Integer page;
    private Integer limit;
    
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
    
    
}
