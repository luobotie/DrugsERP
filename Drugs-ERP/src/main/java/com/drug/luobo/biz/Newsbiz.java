package com.drug.luobo.biz;

import com.drug.luobo.entity.News;
import com.drug.luobo.untils.LayuiTableData;
import com.drug.luobo.untils.NewsVo;

public interface Newsbiz {
	/**
	 * 查询所有公告
	 * @param newsVo
	 * @return
	 */
	public LayuiTableData queryAllNews(NewsVo newsVo);
	/**
	 * 添加公告
	 * @param newsVo
	 */
	public void addNews(NewsVo newsVo);
	/**
	 * 修改公告
	 * @param newsVo
	 */
	public void updateNews(NewsVo newsVo);
	/**
	 * 根据id删除公告
	 * @param newsid
	 */
	public void deleteNews(Integer newsid);
	/**
	 * 批量删除公告
	 * @param newsVo
	 */
	public void deleteBatchNews(Integer [] ids);
	
	/**
	 * 查询一个公告
	 * @param id
	 * @return
	 */
	public News queryNewsById(Integer id);
}
