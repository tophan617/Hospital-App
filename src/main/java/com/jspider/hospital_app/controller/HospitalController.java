package com.jspider.hospital_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.hospital_app.dao.HospitalDao;
import com.jspider.hospital_app.entity.Hospital;
import com.jspider.hospital_app.service.HospitalService;
import com.jspider.hospital_app.util.ResponseStructure;

@RestController
public class HospitalController {
	@Autowired
	private HospitalService hospitalService;
	
	@PostMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital){
		return hospitalService.saveHospital(hospital);
	}
	
	@GetMapping("/hospital/id/{id}")
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(@PathVariable int id){
		return hospitalService.getHospitalById(id);
	}
	
	@PutMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@RequestParam int id,@RequestBody Hospital hospital){
		return hospitalService.updateHospital(id, hospital);
	}
	
	@DeleteMapping("/hospital")
	public boolean deleteHospital(@RequestParam int id) {
		return hospitalService.deleteHospital(id);
	}
	
	@GetMapping("hospital/getall")
	public ResponseEntity<ResponseStructure<List<Hospital>>> getAllHospital(){
		return hospitalService.getAllHospital();
	}
}
