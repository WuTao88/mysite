package com.sample.mysite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.mysite.entity.Photo;
@Repository
public interface PhotoDao extends JpaRepository<Photo, Integer> {

}
