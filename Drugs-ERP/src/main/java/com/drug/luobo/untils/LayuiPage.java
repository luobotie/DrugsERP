package com.drug.luobo.untils;

import com.drug.luobo.entity.Menus;

/**
 * 描述：用来接收layui分页的参数page,limit
 * @author 罗波
 *
 */
public class LayuiPage extends Menus {
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
