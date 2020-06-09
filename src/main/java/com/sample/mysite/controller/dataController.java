package com.sample.mysite.controller;

import java.util.*;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.alibaba.fastjson.JSON;
import com.sample.mysite.entity.Account;

import com.sample.mysite.service.AccountService;
import com.sample.mysite.service.RoleService;


@Controller()
@RequestMapping("data")
public class dataController {
	
	@Autowired
	private AccountService service;
	@Autowired
	private RoleService roleService;
	
	@ResponseBody
	@RequestMapping("/accounts")
	public String dataPage(@RequestParam("page")int page,@RequestParam("limit")int size,Map<String, Object> map) {
		List<Account> list=null;

        map.put("code","0");
        map.put("msg","");
       
        map.put("data", list);
		return JSON.toJSONString(map);
		
	}
	@ResponseBody
	@RequestMapping("/listroles")
	public String tableRoles(Map<String, Object> map) {
		
        map.put("code","0");
        map.put("msg","");
        map.put("count",roleService.showAll().size());
        map.put("data", roleService.showAll());
		return JSON.toJSONString(map);
		
	}
	@ResponseBody
	@RequestMapping("/roles")
	public String getRoles() {
		
		return JSON.toJSONString(roleService.showAll());
		
	}
}
