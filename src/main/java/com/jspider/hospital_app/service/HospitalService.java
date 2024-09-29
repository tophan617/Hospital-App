package com.jspider.hospital_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspider.hospital_app.dao.HospitalDao;
import com.jspider.hospital_app.entity.Hospital;
import com.jspider.hospital_app.util.ResponseStructure;

@Service
public class HospitalService {
	@Autowired
	private HospitalDao hospitalDao;
	
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		ResponseStructure<Hospital> responseStructure=new ResponseStructure<Hospital>();
		responseStructure.setData(hospitalDao.saveHospital(hospital));
		responseStructure.setMessage("sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(int id) {
		ResponseStructure<Hospital> responseStructure=new ResponseStructure<Hospital>();
		responseStructure.setData(hospitalDao.getHospitalById(id));
		responseStructure.setMessage("sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int id,Hospital hospital) {
		ResponseStructure<Hospital> responseStructure=new ResponseStructure<Hospital>();
		responseStructure.setData(hospitalDao.updateHospital(id, hospital));
		responseStructure.setMessage("sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
	}
	
	public boolean deleteHospital(int id) {
		return hospitalDao.deleteHospital(id);
	}
	
	public ResponseEntity<ResponseStructure<List<Hospital>>> getAllHospital() {
		ResponseStructure<List<Hospital>> responseStructure=new ResponseStructure<List<Hospital>>();
		responseStructure.setData(hospitalDao.getAllHospital());
		responseStructure.setMessage("sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Hospital>>>(responseStructure,HttpStatus.OK);
	}
}
