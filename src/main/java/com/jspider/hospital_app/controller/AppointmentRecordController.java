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

import com.jspider.hospital_app.dao.AppointmentRecordDao;
import com.jspider.hospital_app.entity.AppointmentRecord;
import com.jspider.hospital_app.service.AppointmentRecordService;
import com.jspider.hospital_app.util.ResponseStructure;

@RestController
public class AppointmentRecordController {
	@Autowired
	private AppointmentRecordService appointmentRecordService;
	
	@PostMapping("/appointment/patient_id/{id}")
	public ResponseEntity<ResponseStructure<AppointmentRecord>> saveAppointmentRecord(@PathVariable int id,@RequestBody AppointmentRecord appointmentRecord){
		return appointmentRecordService.saveAppointmentRecord(id, appointmentRecord);
	}
	
	@GetMapping("/appointment/id/{id}")
	public ResponseEntity<ResponseStructure<AppointmentRecord>> getAppointmentRecordById(@PathVariable int id){
		return appointmentRecordService.getAppointmentRecordById(id);
	}
	
	@PutMapping("/appointment/id/{id}")
	public ResponseEntity<ResponseStructure<AppointmentRecord>> updateAppointmentRecord(@PathVariable int id,@RequestBody AppointmentRecord appointmentRecord){
		return appointmentRecordService.updateAppointmentRecord(id, appointmentRecord);
	}
	
	@DeleteMapping("/appointment/id/{id}")
	public boolean deleteAppointmentRecord(@PathVariable int id) {
		return appointmentRecordService.deleteAppointmentRecord(id);
	}
	
	@GetMapping("/appointment/getall")
	public ResponseEntity<ResponseStructure<List<AppointmentRecord>>> getAllAppointmentRecord(){
		return appointmentRecordService.getAllAppointmentRecord();
	}
}
