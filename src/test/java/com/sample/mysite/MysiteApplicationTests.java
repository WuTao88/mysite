package com.sample.mysite;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.sample.mysite.entity.Account;
import com.sample.mysite.entity.Article;
import com.sample.mysite.entity.Category;
import com.sample.mysite.entity.News;
import com.sample.mysite.entity.Role;
import com.sample.mysite.repository.AccountDao;
import com.sample.mysite.repository.RoleDao;
import com.sample.mysite.repository.TestDao;
import com.sample.mysite.service.AccountService;

@SpringBootTest
class MysiteApplicationTests {

	@Autowired
	private TestDao dao;
	
	@Test
	public void test1() {
		List<News> roles=new ArrayList<News>();
		for(int i=0;i<10;i++) {
			News r=new News();
			r.setNewsTitle("test news title "+i);
			r.setNewsContent("test news content "+i+",test content is over.");
			Account reporter=new Account();
			reporter.setId(3);
			r.setReporter(reporter);

			roles.add(r);
		}
		dao.saveAll(roles);
	}
	@Test
	public void test2() {
		File file=new File("C:/Users/saber/test.txt");
		try {
			file.createNewFile();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
