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

import com.jspider.hospital_app.dao.Medical_itemsDao;
import com.jspider.hospital_app.entity.Medical_items;
import com.jspider.hospital_app.service.Medical_itemsService;
import com.jspider.hospital_app.util.ResponseStructure;

@RestController
public class Medical_itemsController {
	@Autowired
	private Medical_itemsService medical_itemsService;
	
	@PostMapping("/medical_items/p_id/{id}")
	public ResponseEntity<ResponseStructure<Medical_items>> saveMedical_items(@PathVariable int id,@RequestBody Medical_items medical_items){
		return medical_itemsService.saveMedical_items(id, medical_items);
	}
	
	@GetMapping("/medical_items/id/{id}")
	public ResponseEntity<ResponseStructure<Medical_items>> getMedical_itemsById(@PathVariable int id){
		return medical_itemsService.getMedical_itemsById(id);
	}
	
	@PutMapping("/medical_items/id/{id}")
	public ResponseEntity<ResponseStructure<Medical_items>> updateMedical_items(@PathVariable int id,@RequestBody Medical_items medical_items){
		return medical_itemsService.updateMedical_items(id, medical_items);
	}
	
	@DeleteMapping("/medical_items/id/{id}")
	public boolean deleteMedical_items(@PathVariable int id) {
		return medical_itemsService.deleteMedical_items(id);
	}
	
	@GetMapping("/medical_items/getall")
	public ResponseEntity<ResponseStructure<List<Medical_items>>> getAllMedical_items(){
		return medical_itemsService.getAllMedical_items();
	}
}
