package com.jsp.CloneApIBookMyShow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.CloneApIBookMyShow.entity.Address;
import com.jsp.CloneApIBookMyShow.repository.AddressRepo;

@Repository
public class AddressDao {
@Autowired
private AddressRepo repo;

public Address saveAddress(Address address) {
 Address dbaddress=  repo.save(address);
   return dbaddress;
}

public Address updateAddressById(long addressId, Address address) {
	Optional<Address> dbaddress= repo.findById(addressId);
	if(dbaddress.isPresent())
	{
		address.setAddressId(addressId);
		repo.save(address);
		return address;
	}
	
	return null;
}

public Address fetchAddressById(long addressId) {
	Optional<Address> optional= repo.findById(addressId);
	if(optional.isPresent())
	{
		return optional.get();
	}else {
		return null;
	}
}

public Address deleteAddressById(long addressId) {
	   Optional<Address> optional= repo.findById(addressId);
	   if(optional.isPresent())
	   {
		   repo.deleteById(addressId);
		   return optional.get();
	   }
	   return null;
}


}
