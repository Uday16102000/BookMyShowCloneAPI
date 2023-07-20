package com.jsp.CloneApIBookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.CloneApIBookMyShow.dto.TheatreDto;
import com.jsp.CloneApIBookMyShow.entity.Theatre;
import com.jsp.CloneApIBookMyShow.repository.TheatreRepo;
import com.jsp.CloneApIBookMyShow.service.AddressService;
import com.jsp.CloneApIBookMyShow.service.TheatreService;
import com.jsp.CloneApIBookMyShow.util.ResponseStructure;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

//	
//	@Autowired
//	private AddressService addressService;
	@Autowired
	private TheatreService theatreService;
	@PostMapping
	public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(@RequestParam long ownerId, @RequestParam long addressId, @RequestBody TheatreDto theatreDto){
		return theatreService.saveTheatre(ownerId,addressId,theatreDto);
		
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Theatre>> updateTheatre(@RequestParam long theatreId,  @RequestBody TheatreDto theatreDto){
		return theatreService.updateTheatre(theatreId,theatreDto);
		
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Theatre>> deleteTheatre(@RequestParam long theatreId)
	{
		return theatreService.deleteTheatre(theatreId);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Theatre>> getTheatre(@RequestParam long theatreId)
	{
		return theatreService.getTheatreById(theatreId);
		
	}
	
}
