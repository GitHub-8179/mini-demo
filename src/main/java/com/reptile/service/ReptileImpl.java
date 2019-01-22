package com.reptile.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reptile.dao.ArticleMapper;
import com.reptile.dao.ArticleTypeMapper;
import com.reptile.dao.ReptileDao;
import com.reptile.entity.ArticleExample;
import com.reptile.entity.ArticleType;
import com.reptile.entity.ArticleTypeExample;
import com.reptile.entity.ArticleTypeExample.Criteria;
import com.reptile.entity.ArticleWithBLOBs;
import com.reptile.entity.IpPostEntity;
import com.reptile.entity.ReptileEntity;

@Service
public class ReptileImpl implements IReptile{

	private static final Logger log = LoggerFactory.getLogger(ReptileImpl.class);
	@Autowired
	private ReptileDao mapper;
	
	@Autowired
	private Gather gather;
	
	@Autowired
	private ArticleMapper articleMapper;
	
	@Autowired
	private ArticleTypeMapper articleTypeMapper;

	@Override
	public List getData(ReptileEntity record) throws Exception {
		ArticleExample articleExample =new ArticleExample();
		com.reptile.entity.ArticleExample.Criteria c = articleExample.createCriteria();
//		c.andArticleTypeIdEqualTo(record.getArticleTypeId());
		c.andStateEqualTo(1);
		List<ArticleWithBLOBs> list = articleMapper.selectaData(articleExample);
//		List idList = new ArrayList();
//		List dataList = new ArrayList();
////
//		Map map = new HashMap();
//		for (ArticleWithBLOBs articleWithBLOBs : list) {
////			idList.add(articleWithBLOBs.getArticleId());
//			map = new HashMap();
//			map.put("txt", new String(articleWithBLOBs.getDetailsTxt(),"UTF-8"));
//			map.put("articleId", articleWithBLOBs.getArticleId());
////			map.put("articleTypeId", articleWithBLOBs.getArticleTypeId());
////			map.put("articleKeyword", articleWithBLOBs.getArticleKeyword());
//			dataList.add(map);
//		}
//		if(articleMapper.updateDataState(idList)>0) {
//			log.info("抽取数据："+idList.size()+"条");
//			return dataList; 
//		}
		
		return list;
	}

}
