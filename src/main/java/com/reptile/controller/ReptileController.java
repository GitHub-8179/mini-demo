package com.reptile.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.reptile.entity.ArticleWithBLOBs;
import com.reptile.entity.ReptileEntity;
import com.reptile.service.IReptile;


@RestController
@RequestMapping("/reptile")
public class ReptileController {

	@Autowired
	private IReptile reptileImpl;
	
	@GetMapping("/getData")
    public Map getData(HttpServletRequest request,HttpServletResponse response,  ReptileEntity reptileEntity
    		,@RequestParam(value = "page", defaultValue = "1") Integer page,@RequestParam(value = "rows", defaultValue = "10") Integer rows) throws Exception{
		
		 
		Map map = new HashMap();
		try {
//			if(reptileEntity==null&&reptileEntity.getArticleTypeId()==null) {
//				map.put("code",302);
//				map.put("msg", "请求文章类型id不可为空！");
//				return map;
//			}
			
			if(rows>1000) {
				map.put("code",302);
				map.put("msg", "数据查询条数过多，请重新请求！");
			}else {
				PageHelper.startPage(page, rows);
				List<ArticleWithBLOBs> list = reptileImpl.getData(reptileEntity);
				List dataList = new ArrayList();
				//
				Map map1 = new HashMap();
				for (ArticleWithBLOBs articleWithBLOBs : list) {
					map1 = new HashMap();
					map1.put("txt", new String(articleWithBLOBs.getDetailsTxt(),"UTF-8"));
					map1.put("articleId", articleWithBLOBs.getArticleId());
					dataList.add(map1);
				}
				PageInfo pageInfo = new PageInfo(list);
				map.put("count", pageInfo.getTotal());

				map.put("data", dataList);
				map.put("msg", "数据返回成功！");
				map.put("code",200);
			}
			
		} catch (Exception e) {
			map.put("msg", "系统程序出错，请联系管理员！");
			map.put("code",500);
		}
    	
		return map;
	}
}
