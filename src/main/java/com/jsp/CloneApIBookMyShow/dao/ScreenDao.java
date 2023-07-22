package com.jsp.CloneApIBookMyShow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.CloneApIBookMyShow.entity.Screen;
import com.jsp.CloneApIBookMyShow.entity.Theatre;
import com.jsp.CloneApIBookMyShow.repository.ScreenRepo;

@Repository
public class ScreenDao {
@Autowired
private ScreenRepo repo;

public Screen saveScreen(Screen screen) {
	return repo.save(screen);
}

public Screen updateScreen(long screenId, Screen screen) {
	Optional<Screen> dbScreen= repo.findById(screenId);
	if(dbScreen.isPresent())
	{   screen.setScreenId(screenId);
		screen.setTheatre(dbScreen.get().getTheatre());
		screen.setSeats(dbScreen.get().getSeats());
		return repo.save(screen);
	}else {
		return null;
	}
	
}

public Screen getScreenById(long screenId) {
 Optional<Screen> optional= repo.findById(screenId);
 if(optional.isPresent())
 {
	 return optional.get();
 }else {
	 return null;
 }
}

public Screen deleteScreenById(long screenId) {
Optional<Screen> optional=repo.findById(screenId);
if(optional.isPresent())
{
	Screen screen=optional.get();
	Theatre theatre = screen.getTheatre();
	theatre.setScreen(null);
	screen.setTheatre(null);
	
	repo.delete(screen);
	return screen;
	
}else {
	return null;
}
}
}