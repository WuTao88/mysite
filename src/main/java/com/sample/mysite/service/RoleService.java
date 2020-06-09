package com.sample.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sample.mysite.entity.Role;
import com.sample.mysite.repository.RoleDao;


@Service
public class RoleService {

	@Autowired
	private RoleDao dao;
	
	public List<Role> showAll() {
		
		
		return dao.findAll();
		
	}
	public List<Role> showAllActive() {
		Role a=new Role();
		a.setDeleteMark(false);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withMatcher("deleteMark", match->match.caseSensitive())
				.withIgnorePaths("id")
				.withIgnoreNullValues();
		
		
		return dao.findAll(Example.of(a, matcher));
		
	}
	
	
	public List<Role> ShowPage(Role role,int page, int size){
		role.setDeleteMark(false);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withMatcher("deleteMark", match->match.caseSensitive())
				.withIgnorePaths("id")
				.withIgnoreNullValues();
		return dao.findAll(Example.of(role, matcher), PageRequest.of(page, size)).getContent();
		
	}
	public Role publish(Role role) {
		
		return dao.save(role);
	}
	
	public Role midify(Role Role) {
		Role a= dao.findOne(Example.of(Role)).orElse(null);
		if(a!=null) {
			return	dao.saveAndFlush(a);
		}else {
			return null;
		}
	}
	public boolean remove(Role a) {
		
		
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
	
	public void delete() {
		dao.deleteAll();
	}
	
}
