package com.drug.luobo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drug.luobo.biz.Newsbiz;
import com.drug.luobo.entity.Employee;
import com.drug.luobo.entity.News;
import com.drug.luobo.untils.LayuiTableData;
import com.drug.luobo.untils.NewsVo;
import com.drug.luobo.untils.ResultObj;
import com.drug.luobo.untils.WebUtils;



/**
 * 公告管理控制器
 * 
 * @author 罗波
 *
 */
@RestController
public class NewsController {

	@Autowired
	private Newsbiz newsService;

	/**
	 * 加载公告列表返回DataGridView
	 */
	@RequestMapping("loadAllNews")
	public LayuiTableData loadAllNews(NewsVo newsVo) {
		return this.newsService.queryAllNews(newsVo);
	}
	
	/**
	 * 添加公告
	 */
	@RequestMapping("addNews")
	public ResultObj addNews(NewsVo newsVo) {
		try {
			newsVo.setCreatetime(new Date());
			Employee user=(Employee) WebUtils.getHttpSession().getAttribute("employee");
			newsVo.setOpername(user.getRealName());
			this.newsService.addNews(newsVo);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.ADD_ERROR;
		}
	}
	/**
	 * 修改公告
	 */
	@RequestMapping("updateNews")
	public ResultObj updateNews(NewsVo newsVo) {
		try {
			this.newsService.updateNews(newsVo);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.ADD_ERROR;
		}
	}

	/**
	 * 删除公告
	 */
	@RequestMapping("deleteNews")
	public ResultObj deleteNews(NewsVo newsVo) {
		try {
			this.newsService.deleteNews(newsVo.getId());
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELETE_ERROR;
		}
	}

	/**
	 * 批量删除公告
	 */
	@RequestMapping("deleteBatchNews")
	public ResultObj deleteBatchNews(NewsVo newsVo) {
		try {
			this.newsService.deleteBatchNews(newsVo.getIds());
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELETE_ERROR;
		}
	}
	
	/**
	 * 根据id查询公告
	 */
	@RequestMapping("loadNewsById")
	public News loadNewsById(Integer id) {
		return this.newsService.queryNewsById(id);
	}

}
