package com.jspider.hospital_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspider.hospital_app.entity.Address;
import com.jspider.hospital_app.entity.Hospital;
import com.jspider.hospital_app.repo.AddressJPA;

@Repository
public class AddressDao {
	@Autowired
	private AddressJPA addressJPA;
	public Address saveAddress(Address address) {
		return addressJPA.save(address);
	}
	
	public Address getAddressById(int id) {
		Optional<Address> optional=addressJPA.findById(id);
		return optional.isPresent()?optional.get():null;
	}
	
	public Address updateAddress(int id,Address address) {
		Address address1=addressJPA.getById(id);
		if(address1!=null) {
			address.setAddress_id(id);;
			return addressJPA.save(address);
		}
		return null;
	}
	
	public boolean deleteAddress(int id) {
		Address address=getAddressById(id);
		if(address!= null) {
			addressJPA.delete(address);
			return true;
		}
		return false;
	}
	
	public List<Address> getAllHospital(){
		return addressJPA.findAll();
	}

}
