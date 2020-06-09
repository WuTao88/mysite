package com.sample.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sample.mysite.entity.Novel;
import com.sample.mysite.repository.NovelDao;

@Service
public class NovelService {
	
	@Autowired
	private NovelDao dao;
	public List<Novel> FindAll() {
		
		
		return dao.findAll();
	}
	
	
	public List<Novel> FindPageSort(int Page,int size,Sort sort) {
		
		
		return dao.findAll(PageRequest.of(Page-1, size, sort)).getContent();
	}
	
	public List<Novel> ShowAll() {
		Novel novel=new Novel();
		novel.setDeleteMark(false);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withIgnorePaths("id")
				.withIgnoreNullValues();
		
		return dao.findAll(Example.of(novel, matcher));
	}
	
	public List<Novel> ShowPageSort(int Page,int size,Sort sort) {
		Novel novel=new Novel();
		novel.setDeleteMark(false);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withIgnorePaths("id")
				.withIgnoreNullValues();
		
		return dao.findAll(Example.of(novel, matcher),PageRequest.of(Page-1, size, sort)).getContent();
	}
	
	public List<Novel> Search(String kw) {
		Novel novel=new Novel();
		novel.setDeleteMark(false);
		novel.setTitle(kw);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withMatcher("title", match->match.contains())
				.withIgnorePaths("id")
				.withIgnoreNullValues();
		return dao.findAll(Example.of(novel, matcher));
		
	}
	
	public List<Novel> Filter() {
		return null;
		
	}
	
	public void Publish(Novel novel) {
		
		dao.saveAndFlush(novel);
	}
	
	public void Edit(Novel novel) {
		if(novel.getId()!=0&&dao.existsById(novel.getId())) {
			dao.saveAndFlush(novel);
		}
		
	}
	
	public void Remove(int id) {
		if(dao.existsById(id)) {
			Novel novel=dao.findById(id).orElse(null);
			novel.setDeleteMark(true);
			dao.saveAndFlush(novel);
		}
	}
	
	
	public void DeleteById(int id) {
		dao.deleteById(id);
	}
	

}
