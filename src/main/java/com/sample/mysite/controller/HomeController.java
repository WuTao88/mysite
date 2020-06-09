package com.sample.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.mysite.service.ArticleService;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private ArticleService service;
	
	@RequestMapping(value= {"/home","/","index"})
	public String Home(Model model) {
		
		model.addAttribute("data",service.showAll());
		return "index";
	}
	
	@RequestMapping("/event")
	public String Event(Model model) {
		
		 model.addAttribute("title","New Event");
		return "event";
	}
	
	@RequestMapping("/recommend")
	public String Recommend(Model model) {
		
		 model.addAttribute("title","Recommend-站长推荐");
		return "recommend";
	}
	
	@RequestMapping("/news")
	public String News(Model model) {
		
		 model.addAttribute("title","News-最新资讯");
		return "news";
	}
	@RequestMapping("/blog")
	public String Blogs(Model model) {
		
		 model.addAttribute("title","博客");
		return "blog";
	}	
	@RequestMapping("/manage")
	public String index() {
		
		
		return "manage/index";
		
	}
}
