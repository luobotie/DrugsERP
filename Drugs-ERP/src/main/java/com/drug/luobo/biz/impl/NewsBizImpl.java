package com.drug.luobo.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.luobo.biz.Newsbiz;
import com.drug.luobo.entity.News;
import com.drug.luobo.mapper.NewsMapper;
import com.drug.luobo.untils.LayuiTableData;
import com.drug.luobo.untils.NewsVo;

@Service
public class NewsBizImpl implements Newsbiz{
	@Autowired
	private NewsMapper newsMapper;

	@Override
	public LayuiTableData queryAllNews(NewsVo newsVo) {
		List<News> data = this.newsMapper.queryAllNews(newsVo);
		LayuiTableData lTableData=new LayuiTableData();
		newsVo.setPage((newsVo.getPage()-1)*newsVo.getLimit());
		Long count = newsMapper.getCount(newsVo);
		lTableData.setData(data);
		lTableData.setCount(count);
		return lTableData;
	}

	@Override
	public void addNews(NewsVo newsVo) {
		this.newsMapper.insertSelective(newsVo);
	}

	@Override
	public void deleteNews(Integer newsid) {
		this.newsMapper.deleteByPrimaryKey(newsid);
	}

	@Override
	public void deleteBatchNews(Integer[] ids) {
		for (Integer integer : ids) {
			this.deleteNews(integer);
		}
	}

	@Override
	public void updateNews(NewsVo newsVo) {
		this.newsMapper.updateByPrimaryKeySelective(newsVo);
	}

	@Override
	public News queryNewsById(Integer id) {
		return this.newsMapper.selectByPrimaryKey(id);
	}

}
