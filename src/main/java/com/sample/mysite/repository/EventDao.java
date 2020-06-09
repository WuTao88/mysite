package com.sample.mysite.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.mysite.entity.Event;
@Repository
public interface EventDao extends JpaRepository<Event, Integer> {

}
