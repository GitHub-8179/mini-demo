package com.reptile.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		try {
			reptileImpl.insert(reptileEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
		return 0;
	}
	
	
//	@PostMapping("/insert")
	@GetMapping("/getData")
    public Map getData(HttpServletRequest request,HttpServletResponse response, ReptileEntity reptileEntity) throws Exception{
		Map map = new HashMap();
		try {
			map.put("msg", true);
			List dataList = reptileImpl.getData(reptileEntity);
			map.put("data", dataList);
		} catch (Exception e) {
			map.put("msg", false);
		}
    	
		return map;
	}
}
