package com.sample.mysite.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.mysite.entity.Category;
@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {

}
