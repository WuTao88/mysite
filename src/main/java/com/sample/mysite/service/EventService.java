package com.sample.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sample.mysite.entity.Event;
import com.sample.mysite.repository.EventDao;



@Service
public class EventService {
	@Autowired
	private EventDao dao;
	
	
	public List<Event> FindAll(){
		
		return dao.findAll();
	}
	
	public List<Event> FindPage(int page, int size){
		
		return dao.findAll(PageRequest.of(page-1, size)).getContent();
	}
	
	public List<Event> showAll(){
		
		ExampleMatcher matcher=ExampleMatcher
				.matching()
				.withIgnorePaths("id")
				.withIncludeNullValues();
		Event event=new Event();
		event.setDeleteMark(false);
		
		return  dao.findAll(Example.of(event, matcher));
		
	}
	
	
	public List<Event> ShowPage(int page, int size){
		Event event=new Event();
		event.setDeleteMark(false);
		ExampleMatcher matcher=ExampleMatcher
				.matching()
				.withIgnorePaths("id")
				.withIncludeNullValues();

		return dao.findAll(Example.of(event, matcher),PageRequest.of(page-1, size)).getContent();
	}
	
	
	public void modify() {
		
	}
	
	public void remove() {
		
	}
	
	public void delete() {
		
	}
}
