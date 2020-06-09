package com.sample.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@RequestMapping("/list")
	public String index() {
		
		return "article/addArticle";
	}
}
