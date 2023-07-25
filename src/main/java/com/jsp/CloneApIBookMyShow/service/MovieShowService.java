package com.jsp.CloneApIBookMyShow.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.CloneApIBookMyShow.dao.MovieDao;
import com.jsp.CloneApIBookMyShow.dao.MovieShowDao;
import com.jsp.CloneApIBookMyShow.dao.ScreenDao;
import com.jsp.CloneApIBookMyShow.dao.TheatreDao;
import com.jsp.CloneApIBookMyShow.dto.MovieShowDto;
import com.jsp.CloneApIBookMyShow.entity.Movie;
import com.jsp.CloneApIBookMyShow.entity.MovieShow;
import com.jsp.CloneApIBookMyShow.entity.Screen;
import com.jsp.CloneApIBookMyShow.entity.Theatre;
import com.jsp.CloneApIBookMyShow.exception.MovieIdNotFoundException;
import com.jsp.CloneApIBookMyShow.exception.ScreenAlreadyAlloted;
import com.jsp.CloneApIBookMyShow.exception.ScreenIdNotFoundException;
import com.jsp.CloneApIBookMyShow.exception.TheatreIdNotFoundException;
import com.jsp.CloneApIBookMyShow.util.ResponseStructure;

@Service
public class MovieShowService
{

	@Autowired
	private MovieShowDao  showDao;
	@Autowired
	private TheatreDao theatreDao;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private ScreenDao  screenDao;
	@Autowired
	private MovieDao movieDao;
	public ResponseEntity<ResponseStructure<MovieShowDto>> addShow(long theatreId, MovieShowDto showDto) {
		Theatre dbTheatre=theatreDao.getTheatreById(theatreId);
		if(dbTheatre!=null) {
            MovieShow moviewShow=this.modelMapper.map(showDto, MovieShow.class);
            long screenId=moviewShow.getScreenId();
            Screen dbScreen=screenDao.getScreenById(screenId);
            if(dbScreen!=null) {
              if( dbScreen.getScreenAvailability().equals("NOT_ALLOTED")) {
//            	  ADD Show
            	  long movieId=moviewShow.getMovieId();
            	  Movie dbMovie=movieDao.getMovieById(movieId);
            	  if(dbMovie!=null) {
//            		  add movie to that show
            		  return null;
//            		  to avoid this error im returning null will change this
            	  }else {
            		  throw new MovieIdNotFoundException("Sorry failed to add show");
            	  }
            	  
              }else{
            	  throw new ScreenAlreadyAlloted("Sorry failed to add show");
              }
            }else {
            	throw new ScreenIdNotFoundException("Sorry failed to add show");
            }
            
		}else {
			throw new TheatreIdNotFoundException("Sorry failed to add show");
		}
		
	}
}
