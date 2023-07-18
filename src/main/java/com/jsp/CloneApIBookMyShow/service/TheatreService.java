package com.jsp.CloneApIBookMyShow.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

import com.jsp.CloneApIBookMyShow.dao.AddressDao;
import com.jsp.CloneApIBookMyShow.dao.OwnerDao;
import com.jsp.CloneApIBookMyShow.dao.TheatreDao;
import com.jsp.CloneApIBookMyShow.dto.TheatreDto;
import com.jsp.CloneApIBookMyShow.entity.Address;
import com.jsp.CloneApIBookMyShow.entity.Owner;
import com.jsp.CloneApIBookMyShow.entity.Theatre;
import com.jsp.CloneApIBookMyShow.exception.AddressIdNotFoundException;
import com.jsp.CloneApIBookMyShow.exception.OwnerIdNotFoundException;
import com.jsp.CloneApIBookMyShow.exception.TheatreAlreadyPresentInTheAddress;
import com.jsp.CloneApIBookMyShow.exception.TheatreIdNotFoundException;
import com.jsp.CloneApIBookMyShow.util.ResponseStructure;

@Service
public class TheatreService {
@Autowired
private TheatreDao theatreDao;

@Autowired
private AddressDao addressDao;
@Autowired
private OwnerDao ownerDao;
@Autowired
private ModelMapper modelMapper;
public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(long ownerId, long addressId, TheatreDto theatreDto) {
Owner owner= ownerDao.findOwnerById(ownerId);
if(owner!=null)
{
	Address address= addressDao.fetchAddressById(addressId);
	if(address!=null)
	{
		Theatre theatre=this.modelMapper.map(theatreDto, Theatre.class);
		theatre.setOwner(owner);
		if(address.getTheatre()!=null)
		{
			throw new TheatreAlreadyPresentInTheAddress("SORRY ADDRESS IS MAPPED TO OTHER THEATRE");
		}
		theatre.setAddress(address);
		if(owner.getTheatres().isEmpty())
		{
			List<Theatre> list = new ArrayList<Theatre>();
			list.add(theatre);
			owner.setTheatres(list);
		}
		else {
			List<Theatre> list=owner.getTheatres();
			list.add(theatre);
			owner.setTheatres(list);
		}
	
		//update Address
		address.setTheatre(theatre);
		//saveTheatre
		Theatre dbTheatre=theatreDao.saveTheatre(theatre);
		
		ResponseStructure<Theatre> structure = new ResponseStructure<Theatre>();
		structure.setMessage("Theatre SAVED successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dbTheatre);
		return new ResponseEntity<ResponseStructure<Theatre>>(structure,HttpStatus.CREATED);
		
	}else {
		throw new AddressIdNotFoundException("Sorry failed to add theatre");
	}
}
else {
	throw new OwnerIdNotFoundException("sorry failed to add theatre");
}

}
public ResponseEntity<ResponseStructure<Theatre>> updateTheatre(long theatreId, TheatreDto theatreDto) {
	Theatre theatre=  this.modelMapper.map(theatreDto, Theatre.class);
	Theatre dbTheatre=theatreDao.updateTheatre(theatreId,theatre);
	if(dbTheatre!=null)
	{
		
		ResponseStructure<Theatre> structure = new ResponseStructure<Theatre>();
		structure.setMessage("Theatre updated successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(dbTheatre);
		return new ResponseEntity<ResponseStructure<Theatre>>(structure,HttpStatus.OK);
	}else {
		throw new TheatreIdNotFoundException("Soorrry failed to update theatre");
	}
}
}
