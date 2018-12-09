package com.reptile.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.reptile.dao.ArticleMapper;
import com.reptile.entity.Article;
import com.reptile.entity.ArticleExample;
import com.reptile.entity.ReptileEntity;
import com.reptile.service.IReptile;


@RestController
@RequestMapping("/reptile")
public class ReptileController {

	@Autowired
	private IReptile reptileImpl;
	
//	@PostMapping("/insert")
	@GetMapping("/insert")
  	@ResponseBody
    public int insert(HttpServletRequest request,HttpServletResponse response, ReptileEntity reptileEntity) throws Exception{
		
		try {
			PageHelper.startPage(1, 5, true);
			reptileImpl.insert(reptileEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		PageHelper.startPage(1, 5);
    	
		return 0;
	}
}
