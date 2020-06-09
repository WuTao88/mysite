package com.sample.mysite.service;

import java.io.File;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sample.mysite.entity.Photo;
import com.sample.mysite.repository.PhotoDao;

@Service
public class PhotoService {

	
	private PhotoDao dao;
	public List<Photo> FindAll() {
		
		
		return dao.findAll();
	}
	
	
	public List<Photo> FindPageSort(int Page,int size,Sort sort) {
		
		
		return dao.findAll(PageRequest.of(Page-1, size, sort)).getContent();
	}
	
	public List<Photo> ShowAll() {
		Photo photo=new Photo();
		photo.setDeleteMark(false);
		
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withIgnorePaths("id")
				.withIgnoreNullValues();
		
		return dao.findAll(Example.of(photo, matcher));
	}
	
	public List<Photo> ShowPageSort(int Page,int size,Sort sort) {
		Photo photo=new Photo();
		photo.setDeleteMark(false);
		
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withIgnorePaths("id")
				.withIgnoreNullValues();
		
		return dao.findAll(Example.of(photo, matcher),PageRequest.of(Page-1, size, sort)).getContent();
	}
	
	public List Search(String kw) {
		Photo photo=new Photo();
		photo.setPhotoName(kw);
		photo.setDeleteMark(false);
		
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withIgnorePaths("id")
				.withIgnoreNullValues();		
		return dao.findAll(Example.of(photo, matcher));
		
	}
	
	public List Filter() {
		return null;
		
	}
	
	public void Publish(Photo photo) {
		File file=new File("classpath:/photo/");
		
		dao.saveAndFlush(photo);
	}
	
	public void Edit() {
		
	}
	
	public void Remove() {
		
	}
	
	
	public void DeleteById() {
		
	}
	
}
