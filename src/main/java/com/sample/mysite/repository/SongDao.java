package com.sample.mysite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.mysite.entity.Song;

@Repository
public interface SongDao extends JpaRepository<Song, Integer> {

}
