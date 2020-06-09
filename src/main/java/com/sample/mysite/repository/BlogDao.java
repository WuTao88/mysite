package com.sample.mysite.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.mysite.entity.Blog;

@Repository
public interface BlogDao extends JpaRepository<Blog, Integer> {

}
