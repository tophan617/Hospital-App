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

import com.jspider.hospital_app.dao.PatientDao;
import com.jspider.hospital_app.entity.Patient;
import com.jspider.hospital_app.service.PatientService;
import com.jspider.hospital_app.util.ResponseStructure;

@RestController
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	@PostMapping("/patient/branch_id/{id}")
	public ResponseEntity<ResponseStructure<Patient>> savePatient(@PathVariable int id,@RequestBody Patient patient){
		return patientService.savePatient(id, patient);
	}
	
	@GetMapping("/patient/id/{id}")
	public ResponseEntity<ResponseStructure<Patient>> getPatientById(@PathVariable int id){
		return patientService.getPatientById(id);
	}
	
	@PutMapping("/patient/id/{id}")
	public ResponseEntity<ResponseStructure<Patient>> updatePatient(@PathVariable int id,@RequestBody Patient patient){
		return patientService.updatePatient(id, patient);
	}
	
	@DeleteMapping("/patient/id/{id}")
	public boolean deletePatient(@PathVariable int id) {
		return patientService.deletPatient(id);
	}
	
	@GetMapping("/patient/getall")
	public ResponseEntity<ResponseStructure<List<Patient>>> getAllPatient(){
		return patientService.getAllPatient();
	}
}
