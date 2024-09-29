package com.jspider.hospital_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspider.hospital_app.dao.AppointmentRecordDao;
import com.jspider.hospital_app.dao.PrescriptionDao;
import com.jspider.hospital_app.entity.AppointmentRecord;
import com.jspider.hospital_app.entity.Prescription;
import com.jspider.hospital_app.util.ResponseStructure;

@Service
public class PrescriptionService {
	@Autowired
	private PrescriptionDao prescriptionDao;
	@Autowired
	private AppointmentRecordDao appointmentRecordDao;
	
	public ResponseEntity<ResponseStructure<Prescription>> savePrescription(int appointment_record_id,Prescription prescription){
		ResponseStructure<Prescription> responseStructure=new ResponseStructure<Prescription>();
		Prescription prescription1=prescriptionDao.savePrescription(prescription);
		AppointmentRecord appointmentRecord=appointmentRecordDao.getAppointmentRecordById(appointment_record_id);
		if(appointmentRecord.getPrescription()==null) {
			appointmentRecord.setPrescription(prescription1);
		}else {
			appointmentRecord.setPrescription(prescription1);
		}
		appointmentRecordDao.saveAppointmentRecord(appointmentRecord);
		responseStructure.setData(prescriptionDao.savePrescription(prescription1));
		responseStructure.setMessage("sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Prescription>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Prescription>> getPrescriptionById(int id){
		ResponseStructure<Prescription> responseStructure=new ResponseStructure<Prescription>();
		responseStructure.setData(prescriptionDao.getPrescriptionById(id));
		responseStructure.setMessage("sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Prescription>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Prescription>> updatePrescription(int id,Prescription prescription){
		ResponseStructure<Prescription> responseStructure=new ResponseStructure<Prescription>();
		responseStructure.setData(prescriptionDao.updatePrescription(id, prescription));
		responseStructure.setMessage("sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Prescription>>(responseStructure,HttpStatus.OK);
	}
	
	public boolean deletePrescription(int id) {
		return prescriptionDao.deletePrescription(id);
	}
	
	public ResponseEntity<ResponseStructure<List<Prescription>>> getAllPrescription(){
		ResponseStructure<List<Prescription>> responseStructure=new ResponseStructure<List<Prescription>>();
		responseStructure.setData(prescriptionDao.getAllPrescription());
		responseStructure.setMessage("sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Prescription>>>(responseStructure,HttpStatus.OK);
	}
}
