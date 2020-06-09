package com.sample.mysite.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.mysite.entity.News;
@Repository
public interface NewsDao extends JpaRepository<News, Integer> {

}
