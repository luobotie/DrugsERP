package com.drug.hxb.entity;

import org.springframework.stereotype.Component;

/**
 * @说明:分页类
 * @author hxb
 * @datetime 2019年10月22日下午1:42:30
 * @version 1.0
 */
@Component
public class PageLimit {
	/**
	 * 第几页
	 */
	private Integer page;
	/**
	 * 显示几行数据
	 */
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
