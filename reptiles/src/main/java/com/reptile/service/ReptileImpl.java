package com.reptile.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.reptile.entity.ArticleWithBLOBs;
import com.reptile.entity.IpPostEntity;
import com.reptile.entity.ArticleTypeExample.Criteria;
import com.reptile.entity.ReptileEntity;
import com.reptile.util.GetIPPost;

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
			
//		List ipPost = GetIPPost.getIp(3);
		
		IpPostEntity ipPostEntity = new IpPostEntity();
		ipPostEntity.setState(1);
		List ipPost =mapper.selectIpPost(ipPostEntity);

		for (ArticleType articleType : listArticleType) {
			gather.setData(1,articleType,ipPost);
		}
		
		return 0;
	}

	@Override
	public List getData(ReptileEntity record) throws Exception {
		List<ArticleWithBLOBs> list = articleMapper.selectaData(null);
		List idList = new ArrayList();
		List dataList = new ArrayList();

		for (ArticleWithBLOBs articleWithBLOBs : list) {
			idList.add(articleWithBLOBs.getArticleId());
			dataList.add(new String(articleWithBLOBs.getDetailsTxt(),"UTF-8"));
		}
		if(articleMapper.updateDataState(idList)>0) {
			return dataList; 
		}
		
		return null;
	}

}
