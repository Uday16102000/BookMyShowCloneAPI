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

import com.jsp.CloneApIBookMyShow.dto.ScreenDto;
import com.jsp.CloneApIBookMyShow.entity.Screen;
import com.jsp.CloneApIBookMyShow.service.ScreenService;
import com.jsp.CloneApIBookMyShow.util.ResponseStructure;

@RestController
@RequestMapping("/screen")
public class ScreenController {

	@Autowired
	private ScreenService screenService;
	@PostMapping
	public ResponseEntity<ResponseStructure<ScreenDto>> addScreen(@RequestParam long thatreId, @RequestBody ScreenDto screenDto)
	{

		return screenService.addScreen(thatreId, screenDto);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<ScreenDto>> updateScreen(@RequestParam long screenId, @RequestBody ScreenDto dto)
	{
		return screenService.updateScreen(screenId,dto);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<ScreenDto>> getScreenById(@RequestParam long screenId){
		return screenService.getScreenById(screenId);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<ScreenDto>> deleteScreenById(@RequestParam long screenId)
	{
		return screenService.deleteScreenById(screenId);
	}
}
