package com.jspider.hospital_app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspider.hospital_app.dao.AddressDao;
import com.jspider.hospital_app.dao.BranchDao;
import com.jspider.hospital_app.entity.Address;
import com.jspider.hospital_app.entity.Branch;
import com.jspider.hospital_app.util.ResponseStructure;

@Service
public class AddressService {
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private BranchDao branchDao;
	
	public ResponseEntity<ResponseStructure<Address>> saveAddress(int branch_id,Address address){
		ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
		Branch branch=branchDao.getBranchById(branch_id);
		Address address1=addressDao.saveAddress(address);
		if(branch.getAddress()!=null) {
			branch.setAddress(address1);
		}else {
			branch.setAddress(address1);
		}
		branchDao.saveBranch(branch);
		responseStructure.setData(addressDao.saveAddress(address1));
		responseStructure.setMessage("sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Address>> getAddressById(int id){
		ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
		responseStructure.setData(addressDao.getAddressById(id));
		responseStructure.setMessage("sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Address>> updateAddress(int id,Address address){
		ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
		responseStructure.setData(addressDao.updateAddress(id, address));
		responseStructure.setMessage("sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
	}
	
	public boolean deleteAddress(int id) {
		return addressDao.deleteAddress(id);
	}
	
	public ResponseEntity<ResponseStructure<List<Address>>> getAllAddress(){
		ResponseStructure<List<Address>> responseStructure=new ResponseStructure<List<Address>>();
		responseStructure.setData(addressDao.getAllHospital());
		responseStructure.setMessage("sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Address>>>(responseStructure,HttpStatus.OK);
	}
}
