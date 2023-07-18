package com.jsp.CloneApIBookMyShow.service;

import javax.print.DocFlavor.STRING;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.CloneApIBookMyShow.dao.AddressDao;
import com.jsp.CloneApIBookMyShow.dto.AddressDto;
import com.jsp.CloneApIBookMyShow.entity.Address;
import com.jsp.CloneApIBookMyShow.exception.AddressIdNotFoundException;
import com.jsp.CloneApIBookMyShow.util.ResponseStructure;

@Service
public class AddressService {

	@Autowired
	private AddressDao dao;
	@Autowired
	private ModelMapper modelMapper;

	public ResponseEntity<ResponseStructure<Address>> saveAddress(AddressDto addressDto) {
	Address address=this.modelMapper.map(addressDto, Address.class);
	Address dbaddress= dao.saveAddress(address);
	ResponseStructure<Address> structure = new ResponseStructure<Address>();
	structure.setMessage("Address saved successfully");
	structure.setStatus(HttpStatus.CREATED.value());
	structure.setData(dbaddress);
	
		return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.CREATED);
		
	}


	public ResponseEntity<ResponseStructure<Address>> updateAddressById(long addressId, AddressDto addressDto) {
		Address address=this.modelMapper.map(addressDto, Address.class);
		Address dbaddress=  dao.updateAddressById(addressId,address);
		if(dbaddress!=null) {
		ResponseStructure<Address> structure = new ResponseStructure<Address>();
		structure.setMessage("Address updated successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(dbaddress);
		return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.OK);
	}else {
		throw new AddressIdNotFoundException("Sorry  failed to update Address");
	}
}


	public ResponseEntity<ResponseStructure<Address>> fetchAddress(long addressId) {
		Address dbAddress= dao.fetchAddressById(addressId);
		if(dbAddress!=null)
		{
		ResponseStructure<Address> structure= new ResponseStructure<Address>();
		structure.setMessage("Address fetched successfully");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(dbAddress);
		return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.FOUND);
		
		
		}else {
			throw new AddressIdNotFoundException("Sorry AddressId not found for fetching");
		}
	}


	public ResponseEntity<ResponseStructure<Address>> deleteAddress(long addressId) {
	Address dbAddress= dao.deleteAddressById(addressId);
	
	if(dbAddress!=null)
	{
		ResponseStructure<Address> structure =  new ResponseStructure<Address>();
		structure.setMessage("Address deleted successfully");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(dbAddress);
		return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.FOUND);
	}else {
		throw new AddressIdNotFoundException("Sorry failed to delete Address");
	}
}}