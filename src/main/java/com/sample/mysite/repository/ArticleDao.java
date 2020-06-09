package com.sample.mysite.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sample.mysite.entity.Article;
@Repository
public interface ArticleDao extends JpaRepository<Article, Integer> {

}
