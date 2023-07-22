package com.jsp.CloneApIBookMyShow.service;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.CloneApIBookMyShow.dao.ScreenDao;
import com.jsp.CloneApIBookMyShow.dao.TheatreDao;
import com.jsp.CloneApIBookMyShow.dto.ScreenDto;
import com.jsp.CloneApIBookMyShow.entity.Screen;
import com.jsp.CloneApIBookMyShow.entity.Theatre;
import com.jsp.CloneApIBookMyShow.enums.ScreenAvailability;
import com.jsp.CloneApIBookMyShow.enums.ScreenStatus;
import com.jsp.CloneApIBookMyShow.enums.ScreenType;
import com.jsp.CloneApIBookMyShow.enums.SeatType;
import com.jsp.CloneApIBookMyShow.entity.Seat;
import com.jsp.CloneApIBookMyShow.exception.ScreenIdNotFoundException;
import com.jsp.CloneApIBookMyShow.exception.TheatreIdNotFoundException;
import com.jsp.CloneApIBookMyShow.util.ResponseStructure;
import java.util.List;

@Service
public class ScreenService {
	@Autowired
	private ScreenDao screenDao;
	@Autowired
	private TheatreDao theatreDao;
	@Autowired
	private ModelMapper modelMapper;

	public ResponseEntity<ResponseStructure<ScreenDto>> addScreen(long thatreId, ScreenDto screenDto) {
		Theatre theatre= theatreDao.getTheatreById(thatreId);
		if(theatre!=null)
		{
			Screen screen= this.modelMapper.map(screenDto, Screen.class);
			List<Seat> seats= new ArrayList<Seat>();
			for(int a=screen.getNoOfClassicSeat();a>0;a--)
			{
				Seat seat= new Seat();
				seat.setSeatType(SeatType.CLASSIC);
				seat.setScreen(screen);
				seats.add(seat);
			}
			for(int a=screen.getNoOfGoldSeat();a>0;a--)
			{
				Seat seat= new Seat();
				seat.setSeatType(SeatType.GOLD);
				seat.setScreen(screen);
				seats.add(seat);
			}
			for(int a=screen.getNoOfPlatinumSeat();a>0;a--)
			{
				Seat seat= new Seat();
				seat.setSeatType(SeatType.PLATINUM);
				seat.setScreen(screen);
				seats.add(seat);
			}
			     screen.setTheatre(theatre);
	             screen.setSeats(seats);
	             screen.setScreentype(ScreenType.THREE_DIMENSION);
	             screen.setScreenAvailability(ScreenAvailability.NOT_ALLOTED);
	             screen.setScreenStatus(ScreenStatus.AVAILABLE);
			
	             
	             Screen dbsScreen= screenDao.saveScreen(screen);
//	            update the theatre
	             if(theatre.getScreen().isEmpty()) {
	            	 List<Screen> screens=new ArrayList<Screen>();
	            	 screens.add(dbsScreen);
	            	 theatre.setScreen(screens);
	            	 theatreDao.updateTheatre(thatreId, theatre);
	             }else{
	            	 List<Screen> screens=theatre.getScreen();
	            	 screens.add(dbsScreen);
	            	 theatre.setScreen(screens);
	            	 theatreDao.updateTheatre(thatreId, theatre);
	             }
	      ScreenDto dto= this.modelMapper.map(dbsScreen, ScreenDto.class);
	             ResponseStructure<ScreenDto> structure=new ResponseStructure<ScreenDto>();
	             structure.setMessage("Screen saved successfully");
	             structure.setStatus(HttpStatus.CREATED.value());
	             structure.setData(dto);
	             return new ResponseEntity<ResponseStructure<ScreenDto>>(structure,HttpStatus.CREATED);
		}else {
			throw new TheatreIdNotFoundException("failed to add screen");
		}
	}

	public ResponseEntity<ResponseStructure<ScreenDto>> updateScreen(long screenId, ScreenDto dto) {
		Screen screen = this.modelMapper.map(dto,Screen.class);
		Screen dbScreen=screenDao.updateScreen(screenId,screen);
		if(dbScreen!=null)
		{
			ScreenDto dto1=this.modelMapper.map(dbScreen, ScreenDto.class);
			ResponseStructure<ScreenDto > structure = new ResponseStructure<ScreenDto>();
			structure.setMessage("Screen updated successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dto1);
			return new ResponseEntity<ResponseStructure<ScreenDto>>(structure,HttpStatus.CREATED);
		}else {
			throw  new ScreenIdNotFoundException("Sorry screenId not found so failed to update the screen");
		}
		
	}

	public ResponseEntity<ResponseStructure<ScreenDto>> getScreenById(long screenId) {
		Screen dbScreen= screenDao.getScreenById(screenId);
		if(dbScreen!=null)
		{
			ScreenDto dto1=this.modelMapper.map(dbScreen, ScreenDto.class);
			ResponseStructure<ScreenDto > structure = new ResponseStructure<ScreenDto>();
			structure.setMessage("Screen fetched successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dto1);
			return new ResponseEntity<ResponseStructure<ScreenDto>>(structure,HttpStatus.FOUND);
		}else {
			throw new ScreenIdNotFoundException("Sorry not able to fetch screen");
		}
		
	
	}

	public ResponseEntity<ResponseStructure<ScreenDto>> deleteScreenById(long screenId) {
		Screen dbScreen= screenDao.deleteScreenById(screenId);
		if(dbScreen!=null) {
			ScreenDto dto1=this.modelMapper.map(dbScreen, ScreenDto.class);
			ResponseStructure<ScreenDto> structure=new ResponseStructure<ScreenDto>();
			structure.setMessage("Screen Deleted successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dto1);
			return new ResponseEntity<ResponseStructure<ScreenDto>>(structure,HttpStatus.FOUND);
		}else {
			throw new ScreenIdNotFoundException("Sorry failed to Delete screen");
		}
	}

}
