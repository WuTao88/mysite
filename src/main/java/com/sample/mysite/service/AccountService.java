package com.sample.mysite.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.sample.mysite.entity.Account;
import com.sample.mysite.repository.AccountDao;


@Service
public class AccountService {
	
	@Autowired
	private AccountDao dao;
	
	
	/**
	 * 分页显示
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Account> FindAllPage(int page ,int size,Sort sort) {
		

			return dao.findAll(PageRequest.of(page-1, size, sort));

			
			//return dao.findAll(PageRequest.of(page-1, size,Sort.by("create_time")));
		
		
	}
	/**
	 * 显示所有数据
	 * @return
	 */
	public List<Account> FindAll() {
		return dao.findAll();
	}
	/**
	 * 显示所有有效数据
	 * @return
	 */
	public List<Account> ShowAll() {
		Account a=new Account();
		a.setDeleteMark(false);
		ExampleMatcher matcher=ExampleMatcher.matching()
				
				.withIgnorePaths("id","point")
				.withIgnoreNullValues();
		
		return dao.findAll(Example.of(a, matcher));
	}
	/**
	 * 分页显示有效数据
	 * @param page
	 * @param size
	 * @return
	 */
	public List<Account> ShowPage(int page,int size,String sort) {
		Account a=new Account();
		a.setDeleteMark(false);
		ExampleMatcher matcher=ExampleMatcher.matching()
				
				.withIgnorePaths("id","point")
				.withIgnoreNullValues();
		
		return dao.findAll(Example.of(a, matcher), PageRequest.of(page-1, size,Sort.by(Direction.ASC, (sort!=null?sort:"create_time")))).getContent();
		
	}
	
	
	/**
	 * 注册
	 * @param account
	 * @return
	 */
	public Account register(Account account) {
		return dao.saveAndFlush(account);
	}
	
	/**
	 * 登录
	 * @param name
	 * @param pass
	 * @return
	 */
	public Account login(String name,String pass) {
		return dao.FindByNameAndPassword(name, pass).get(0);
	}
	
	/**
	 * 修改
	 * @param account
	 */
	public void modify(Account account) {
		
		dao.saveAndFlush(account);
	}
	
	/**
	 * 假删除
	 * @param id
	 */
	public void remove(int id) {
		
		Account account=dao.findById(id).orElse(null);
		account.setDeleteMark(true);
		dao.saveAndFlush(account);
	}
	
	/**
	 * 真删除
	 * @param id
	 */
	public void delete(int id) {
		dao.deleteById(id);
	}


}
