package com.sample.mysite.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sample.mysite.entity.Category;
import com.sample.mysite.repository.CategoryDao;

@Service
public class CategoryService {
	
	private CategoryDao dao;
	
	public Category addCategory(Category category) {
		
		
		return dao.save(category);
	}
	
	public void addCategories(List<Category> categories) {
		
		 
		dao.saveAll(categories);
	}
	
	public void removeCategories(List<Category> categories) {
		
		
	}
	
	
	public void updateCategories(List<Category> categories) {
		
		
	}
	
	public List<Category> showAll() {
		Category c=new Category();
		c.setDeleteMark(false);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withIgnorePaths("id")
				.withIgnoreNullValues();
		
		return dao.findAll(Example.of(c, matcher));
		
	}
	
	public List<Category> showPage(int page ,int size){
		
		Category c=new Category();
		c.setDeleteMark(false);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withIgnorePaths("id")
				.withIgnoreNullValues();
		
		return dao.findAll(Example.of(c, matcher),PageRequest.of(page, size)).getContent();
	}

}
