package com.xiaoshu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoshu.dao.CategoryMapper;
import com.xiaoshu.dao.ContentMapper;
import com.xiaoshu.entity.Category;
import com.xiaoshu.entity.Content;
import com.xiaoshu.entity.ContentVo;

@Service
public class ContentService {

	@Autowired
	ContentMapper contentMapper;

	@Autowired
	CategoryMapper categoryMapper;
	
	
	
	public List<Category> findCategory(){
		return categoryMapper.selectAll();
	}
	
	public Content findByName(String contenttitle){
		Content c = new Content();
		c.setContenttitle(contenttitle);
		return contentMapper.selectOne(c);
	}
	
	public PageInfo<ContentVo> findPage(ContentVo contentVo , Integer pageNum , Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<ContentVo> list = contentMapper.findList(contentVo);
		return new PageInfo<ContentVo>(list);
	}
	
	public void updateContent(Content content){
		contentMapper.updateByPrimaryKeySelective(content);
	}
	
	public void addContent(Content content){
		content.setCreatetime(new Date());
		contentMapper.insert(content);
	}
	
	public void deleteContent(Integer contentid){
		contentMapper.deleteByPrimaryKey(contentid);
	}
	public List<ContentVo> findList(ContentVo contentVo){
		return contentMapper.findList(contentVo);
	}
	
}
