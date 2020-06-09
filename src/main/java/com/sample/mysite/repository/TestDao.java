package com.sample.mysite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.mysite.entity.Account;
import com.sample.mysite.entity.Article;
import com.sample.mysite.entity.Category;
import com.sample.mysite.entity.News;
import com.sample.mysite.entity.Role;



public interface TestDao extends JpaRepository<News, Integer> {
	
	
}
