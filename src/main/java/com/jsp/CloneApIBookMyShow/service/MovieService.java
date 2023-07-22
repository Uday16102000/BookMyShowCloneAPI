package com.jsp.CloneApIBookMyShow.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.CloneApIBookMyShow.dao.MovieDao;
import com.jsp.CloneApIBookMyShow.dao.ProductionHouseDao;
import com.jsp.CloneApIBookMyShow.dto.MovieDto;
import com.jsp.CloneApIBookMyShow.entity.Movie;
import com.jsp.CloneApIBookMyShow.entity.ProductionHouse;
import com.jsp.CloneApIBookMyShow.exception.ProductionHouseIdNotFoundException;
import com.jsp.CloneApIBookMyShow.util.ResponseStructure;
import java.util.List;
import java.util.ArrayList;

@Service
public class MovieService {
	
	@Autowired
	private MovieDao movieDao;
	@Autowired
	private ProductionHouseDao houseDao;
	@Autowired
	private ModelMapper modelMapper;

	public ResponseEntity<ResponseStructure<MovieDto>> saveMovie(long houseId, MovieDto movieDto) {
		ProductionHouse house=houseDao.getProductionHouseById(houseId);
		if(house!=null)
		{
			Movie movie=this.modelMapper.map(movieDto, Movie.class);
			movie.setProductionHouse(house);
			Movie dbMovie=movieDao.saveMovie(movie);
			if(house.getMovies().isEmpty()) {
				List<Movie> list=new ArrayList<Movie>();
				list.add(movie);
				house.setMovies(list);
			}else {
				List<Movie> list=house.getMovies();
				list.add(movie);
				house.setMovies(list);
			}
			ResponseStructure<MovieDto> structure=new ResponseStructure<MovieDto>();
			structure.setMessage("Movie Saved successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(this.modelMapper.map(dbMovie, MovieDto.class));
			return new ResponseEntity<ResponseStructure<MovieDto>>(structure,HttpStatus.CREATED);
		}else {
			throw new ProductionHouseIdNotFoundException("sorry failed to add movie ");
		}
			
		}
	}
 
	
	
