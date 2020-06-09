package com.sample.mysite.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sample.mysite.entity.Blog;
import com.sample.mysite.repository.BlogDao;


@Service
public class BlogService {
	@Autowired
	private BlogDao dao;
	
	public Blog publish(Blog blog) {
		
		return dao.save(blog);
		
	}
	public List<Blog> FindAll(){
		return dao.findAll();
		
	}
	
	public List<Blog> FindPage(int page,int size){
		return dao.findAll(PageRequest.of(page-1, size)).getContent();
		
	}
	
	public List<Blog> ShowAll(){
		Blog blog=new Blog();
		
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withIgnoreNullValues()
				.withIgnorePaths("id");
				
		
		return dao.findAll(Example.of(blog, matcher));
		
	}
	
	public List<Blog> ShowPage(int page,int size){
		Blog blog=new Blog();
		
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withIgnoreNullValues()
				.withIgnorePaths("id");
				
		
		return dao.findAll(Example.of(blog, matcher),PageRequest.of(page, size)).getContent();
		
	}
	
	public List<Blog> search(String kw){
		Blog blog=new Blog();
		blog.setContent(kw);
		blog.setDeleteMark(false);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withIgnoreNullValues()
				.withMatcher("content", match->match.contains())
				.withIgnorePaths("id");
		return dao.findAll(Example.of(blog,matcher));
		
	}
	
	public void modfy(Blog b) {
		Blog blog=new Blog();
		blog.setDeleteMark(false);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withIgnoreNullValues()
				.withMatcher("content", match->match.contains())
				.withIgnorePaths("id");
		
		
		dao.saveAndFlush(b);
	}
	
	public void remove(int id) {
		Blog blog=dao.findById(id).orElse(null);
		blog.setDeleteMark(false);

		
		
		dao.saveAndFlush(blog);
	}
	
	public void delete(int id) {
		Blog blog=dao.findById(id).orElse(null);
		
		dao.delete(blog);
	}
	
	
}
