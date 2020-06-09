package com.sample.mysite.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.mysite.entity.Novel;
@Repository
public interface NovelDao extends JpaRepository<Novel, Integer> {

}
