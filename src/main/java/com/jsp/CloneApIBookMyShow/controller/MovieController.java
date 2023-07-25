package com.jsp.CloneApIBookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.CloneApIBookMyShow.dto.MovieDto;
import com.jsp.CloneApIBookMyShow.service.MovieService;
import com.jsp.CloneApIBookMyShow.util.ResponseStructure;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<MovieDto>> saveMovie(@RequestParam long houseId,
			@RequestBody MovieDto movieDto){
		return service.saveMovie(houseId,movieDto);
	}
//	@PutMapping
//	public ResponseEntity<ResponseStructure<MovieDto>> updateMovie(@RequestParam long movieId,@RequestBody MovieDto movieDto)
//	{
////		return service.updateMovie(movieId,movieDto);
//	}

}
