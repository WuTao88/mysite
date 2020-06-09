package com.sample.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.sample.mysite.entity.Article;
import com.sample.mysite.repository.ArticleDao;

@Service
public class ArticleService {
	@Autowired
	private ArticleDao dao;
	
	
	/**
	 * 
	 * @return
	 */
	public List<Article> showAll() {
		
			
		return dao.findAll();
		
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Article> showAllActive() {
		Article a=new Article();
		a.setDeleteMark(false);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withMatcher("deleteMark", match->match.caseSensitive())
				.withIgnorePaths("id")
				.withIgnoreNullValues();
		
		
		return dao.findAll(Example.of(a, matcher));
		
	}
	
	/**
	 * 
	 * @param article
	 * @param page
	 * @param size
	 * @return
	 */
	public List<Article> ShowPage(Article article,int page, int size){
		article.setDeleteMark(false);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withMatcher("deleteMark", match->match.caseSensitive())
				.withIgnorePaths("id")
				.withIgnoreNullValues();
		return dao.findAll(Example.of(article, matcher), PageRequest.of(page, size)).getContent();
		
	}
	
	/**
	 * 
	 * @param article
	 * @return
	 */
	public Article publish(Article article) {
		
		return dao.save(article);
	}
	/**
	 * 
	 * @param article
	 * @return
	 */
	public Article midify(Article article) {
		Article a= dao.findOne(Example.of(article)).orElse(null);
		if(a!=null) {
			return	dao.saveAndFlush(a);
		}else {
			return null;
		}
	}
	
	/**
	 * 
	 * @param a
	 * @return
	 */
	public boolean remove(Article a) {
		
		
		a.setDeleteMark(true);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withMatcher("deleteMark", match->match.caseSensitive())
				.withIgnoreNullValues();
		if(dao.exists(Example.of(a, matcher))) {
			dao.saveAndFlush(dao.findOne(Example.of(a, matcher)).get());
			return true;
		}else {
		
		
		return false;
		}
		
	}
	/**
	 * 
	 */
	public void delete() {
		dao.deleteAll();
	}
	
}
