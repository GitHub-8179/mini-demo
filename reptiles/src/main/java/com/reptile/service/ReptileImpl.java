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
	public int insert(ReptileEntity record) throws Exception {
		ArticleTypeExample example = new ArticleTypeExample();
		Criteria c  = example.createCriteria();
		c.andParentidNotEqualTo(0);
		List<ArticleType> listArticleType = articleTypeMapper.selectByExample(example);
			
//		List ipPost = GetIPPost.getIp(3);
		
		IpPostEntity ipPostEntity = new IpPostEntity();
		ipPostEntity.setState(1);
		List ipPost =mapper.selectIpPost(ipPostEntity);

		gather.setData(1,listArticleType.get(0),ipPost);

		
//		for (ArticleType articleType : listArticleType) {
//			gather.setData(1,articleType,ipPost);
//		}
		
		return 0;
	}

	@Override
	public List getData(ReptileEntity record) throws Exception {
		List<ArticleWithBLOBs> list = articleMapper.selectaData(null);
		List idList = new ArrayList();
		List dataList = new ArrayList();

//		Map map = new HashMap();
		for (ArticleWithBLOBs articleWithBLOBs : list) {
			idList.add(articleWithBLOBs.getArticleId());
//			map = new HashMap();
//			map.put("data", new String(articleWithBLOBs.getDetailsTxt(),"UTF-8"));
//			dataList.add(map);
			dataList.add(new String(articleWithBLOBs.getDetailsTxt(),"UTF-8"));
		}
		if(articleMapper.updateDataState(idList)>0) {
			log.info("抽取数据："+idList.size()+"条");
			return dataList; 
		}
		
		return null;
	}

}
