package com.jsp.CloneApIBookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.CloneApIBookMyShow.entity.Movie;

public interface MovieRepo  extends JpaRepository<Movie, Long> {

}
