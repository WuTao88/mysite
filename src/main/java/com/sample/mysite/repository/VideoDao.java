package com.sample.mysite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.mysite.entity.Video;
@Repository
public interface VideoDao extends JpaRepository<Video, Integer> {

	
}
