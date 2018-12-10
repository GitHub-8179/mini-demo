package com.reptile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.reptile.dao.ArticleMapper;
import com.reptile.dao.ArticleTypeMapper;
import com.reptile.dao.ReptileDao;
import com.reptile.entity.Article;
import com.reptile.entity.ArticleExample;
import com.reptile.entity.ArticleType;
import com.reptile.entity.ArticleTypeExample;
import com.reptile.entity.ArticleTypeExample.Criteria;
import com.reptile.entity.ReptileEntity;

@Service
public class ReptileImpl implements IReptile{

	@Autowired
	private ReptileDao mapper;
	
	@Autowired
	private Gather gather;
	
	@Autowired
	private ArticleMapper articleMapper;
	
	@Autowired
	private ArticleTypeMapper articleTypeMapper;
	
	@Override
	public int insert(ReptileEntity record) throws Exception {
		ArticleTypeExample example = new ArticleTypeExample();
		Criteria c  = example.createCriteria();
		c.andParentidNotEqualTo(0);
		List<ArticleType> listArticleType = articleTypeMapper.selectByExample(example);
			
		for (ArticleType articleType : listArticleType) {
			gather.setData(1,articleType);
		}
		
		return 0;
	}

}
