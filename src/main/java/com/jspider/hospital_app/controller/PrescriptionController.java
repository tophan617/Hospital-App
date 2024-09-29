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

import com.jspider.hospital_app.dao.PrescriptionDao;
import com.jspider.hospital_app.entity.Prescription;
import com.jspider.hospital_app.service.PrescriptionService;
import com.jspider.hospital_app.util.ResponseStructure;

@RestController
public class PrescriptionController {
	@Autowired
	private PrescriptionService prescriptionService;
	
	@PostMapping("/prescription/ar_id/{id}")
	public ResponseEntity<ResponseStructure<Prescription>> savePrescription(@PathVariable int id,@RequestBody Prescription prescription){
		return prescriptionService.savePrescription(id, prescription);
	}
	
	@GetMapping("/prescription/id/{id}")
	public ResponseEntity<ResponseStructure<Prescription>> getPrescriptionById(@PathVariable int id){
		return prescriptionService.getPrescriptionById(id);
	}
	
	@PutMapping("/prescription/id/{id}")
	public ResponseEntity<ResponseStructure<Prescription>> updatePrescription(@PathVariable int id,@RequestBody Prescription prescription){
		return prescriptionService.updatePrescription(id, prescription);
	}
	
	@DeleteMapping("/prescription/id/{id}")
	public boolean deletePrescription(@PathVariable int id) {
		return prescriptionService.deletePrescription(id);
	}
	
	@GetMapping("/prescription/getall")
	public ResponseEntity<ResponseStructure<List<Prescription>>> getAllPrescription(){
		return prescriptionService.getAllPrescription();
	}
}
