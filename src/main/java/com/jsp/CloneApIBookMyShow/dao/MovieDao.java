package com.jsp.CloneApIBookMyShow.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.CloneApIBookMyShow.entity.Movie;
import com.jsp.CloneApIBookMyShow.repository.MovieRepo;

@Repository
public class MovieDao {

	@Autowired
	private MovieRepo repo;

	public Movie saveMovie(Movie movie) {
		return repo.save(movie);
	}
}
