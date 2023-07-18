package com.jsp.CloneApIBookMyShow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.CloneApIBookMyShow.dao.OwnerDao;
import com.jsp.CloneApIBookMyShow.dto.OwnerDto;
import com.jsp.CloneApIBookMyShow.entity.Owner;
import com.jsp.CloneApIBookMyShow.exception.OwnerIdNotFoundException;
import com.jsp.CloneApIBookMyShow.util.ResponseStructure;

@Service
public class OwnerService {
	
	@Autowired
	private OwnerDao ownerdao;

	public ResponseEntity<ResponseStructure<OwnerDto>> saveOwner(Owner owner) {
	Owner dbOwner=	ownerdao.saveOwner(owner);
	OwnerDto dto = new OwnerDto();
	dto.setOwnerId(dbOwner.getOwnerId());
	dto.setOwnerEmail(dbOwner.getOwnerEmail());
	dto.setOwnerName(dbOwner.getOwnerName());
	dto.setOwnerPhoneNumber(dbOwner.getOwnerPhoneNumber());

	
	ResponseStructure<OwnerDto> structure = new ResponseStructure<OwnerDto>();
	structure.setMessage("Owner Data is saved successfully");
	structure.setStatus(HttpStatus.CREATED.value());
	structure.setData(dto);
		return new ResponseEntity<ResponseStructure<OwnerDto>> (structure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<OwnerDto>> findOwnerById(long ownerId) {
	Owner dbowner= ownerdao.findOwnerById(ownerId);
	 if(dbowner!=null)
	 {
		 OwnerDto dto=new OwnerDto();
		 dto.setOwnerId(dbowner.getOwnerId());
		 dto.setOwnerName(dbowner.getOwnerName());
		 dto.setOwnerEmail(dbowner.getOwnerEmail());
		 dto.setOwnerPhoneNumber(dbowner.getOwnerPhoneNumber());
	 
	 
	ResponseStructure<OwnerDto> structure = new ResponseStructure<OwnerDto>();
	structure.setMessage("Owner id fetched sucessfully");
	structure.setStatus(HttpStatus.CREATED.value());
	structure.setData(dto);
	
	return new ResponseEntity<ResponseStructure<OwnerDto>> (structure,HttpStatus.FOUND);
	 }else {
		 throw new OwnerIdNotFoundException("Sorry failed to fetch Owner");
	 }
	}

	public ResponseEntity<ResponseStructure<OwnerDto>> deleteOwnerById(long ownerId) {
		Owner dbowner= ownerdao.deleteOwnerById(ownerId);
		if(dbowner!=null)
		{
			OwnerDto dto= new OwnerDto();
			dto.setOwnerId(dbowner.getOwnerId());
			dto.setOwnerName(dbowner.getOwnerName());
			dto.setOwnerEmail(dbowner.getOwnerEmail());
			dto.setOwnerPhoneNumber(dbowner.getOwnerPhoneNumber());
			
			ResponseStructure<OwnerDto> structure= new ResponseStructure<OwnerDto>();
			structure.setMessage("Owner deleted successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<OwnerDto>>(structure,HttpStatus.FOUND);
		}
		else {
			//raise owner Id not found exception
			throw new OwnerIdNotFoundException("Sorry failed to delete the owner");
		}
	}

	public ResponseEntity<ResponseStructure<OwnerDto>> updateOwnerById(long ownerId, Owner owner) {
		   Owner dbowner= ownerdao.updateOwnerById(ownerId,owner);
		   if(dbowner!=null)
		   {
			   OwnerDto dto= new OwnerDto();
			dto.setOwnerId(dbowner.getOwnerId());
			   dto.setOwnerName(dbowner.getOwnerName());
			   dto.setOwnerPhoneNumber(dbowner.getOwnerPhoneNumber());
			   dto.setOwnerEmail(dbowner.getOwnerEmail());
			   
			   ResponseStructure<OwnerDto> structure= new ResponseStructure<OwnerDto>();
			   structure.setMessage("Owner Data updated successfully");
			   structure.setStatus(HttpStatus.OK.value());
			   structure.setData(dto);
			   return new ResponseEntity<ResponseStructure<OwnerDto>>(structure,HttpStatus.OK);
		   }
		   else {
			   
			   throw new OwnerIdNotFoundException("sorry failed to update the owner");
		   }
	}

	
	
	
}
