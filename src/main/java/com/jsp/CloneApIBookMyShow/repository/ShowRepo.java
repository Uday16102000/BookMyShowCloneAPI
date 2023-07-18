package com.jsp.CloneApIBookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.CloneApIBookMyShow.entity.MovieShow;


public interface ShowRepo extends JpaRepository<MovieShow, Long> {

}
