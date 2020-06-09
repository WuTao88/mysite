package com.sample.mysite.controller;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.mysite.service.AccountService;

@Controller
@RequestMapping("/manage")
public class ManageController {
	
	@Autowired
	private AccountService service;

	@RequestMapping("/")
	public String index() {
		
		
		return "manage/index";
		
	}
	@RequestMapping(value="/register")
	public String Sign() {
		
		
		return "manage/SignUp";
		
	}
	@RequestMapping(value="/push",method=RequestMethod.POST)
	public String SignUp(@ModelAttribute Map<String,Object> map) {
		
		
		return "manage/SignUp";
		
	}
	
	
//	@RequestMapping(value = "/home" , method=RequestMethod.POST)
//	public String home(@ModelAttribute("manager") String name, @ModelAttribute("password") String pass) {
//		if(service.login(name, pass)!=null) {
//		return "main";
//		}else {
//			return "manage/index";
//		}
//		
//	}
	
	@RequestMapping(value = "/home" )
	public String home() {
		return "manage/main";

		
	}

}
