package com.sample.mysite.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sample.mysite.entity.Account;
@Repository
public interface AccountDao extends JpaRepository<Account, Integer> {

	@Query("select a,r from Account a left join a.role r where a.name=?1  and a.passwd=?2 and a.deleteMark=false")
	public List<Account> FindByNameAndPassword(String name,String passwd );	

}
