package com.jspider.hospital_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.hospital_app.dao.AddressDao;
import com.jspider.hospital_app.entity.Address;
import com.jspider.hospital_app.service.AddressService;
import com.jspider.hospital_app.util.ResponseStructure;

@RestController
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/address/branch_id/{id}")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@PathVariable int id,@RequestBody Address address){
		return addressService.saveAddress(id, address);
	}
	
	@GetMapping("/address/id/{id}")
	public ResponseEntity<ResponseStructure<Address>> getAddressById(@PathVariable int id){
		return addressService.getAddressById(id);
	}
	
	@PutMapping("/address/id/{id}")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@PathVariable int id,@RequestBody Address address){
		return addressService.updateAddress(id, address);
	}
	
	@DeleteMapping("/address/id/{id}")
	public boolean deleteAddress(@PathVariable int id) {
		return addressService.deleteAddress(id);
	}
	
	@GetMapping("/address/getall")
	public ResponseEntity<ResponseStructure<List<Address>>> getAllAddress(){
		return addressService.getAllAddress();
	}
}
