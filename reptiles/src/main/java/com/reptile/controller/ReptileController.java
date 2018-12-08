package com.reptile.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
		
		reptileImpl.insert(reptileEntity);
		return 0;
	}
}
