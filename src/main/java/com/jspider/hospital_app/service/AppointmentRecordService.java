package com.jspider.hospital_app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspider.hospital_app.dao.AppointmentRecordDao;
import com.jspider.hospital_app.dao.PatientDao;
import com.jspider.hospital_app.entity.AppointmentRecord;
import com.jspider.hospital_app.entity.Patient;
import com.jspider.hospital_app.util.ResponseStructure;

@Service
public class AppointmentRecordService {
	@Autowired
	private AppointmentRecordDao appointmentRecordDao;
	@Autowired
	private PatientDao patientDao;
	
	public ResponseEntity<ResponseStructure<AppointmentRecord>> saveAppointmentRecord(int patient_id,AppointmentRecord appointmentRecord){
		ResponseStructure<AppointmentRecord> responseStructure=new ResponseStructure<AppointmentRecord>();
		AppointmentRecord appointmentRecord1=appointmentRecordDao.saveAppointmentRecord(appointmentRecord);
		Patient patient=patientDao.getPatientById(patient_id);
		if(patient.getAppointmentRecord()!=null) {
			List<AppointmentRecord> list=new ArrayList<AppointmentRecord>();
			list.add(appointmentRecord1);
			patient.setAppointmentRecord(list);
		}else {
			patient.getAppointmentRecord().add(appointmentRecord1);
		}
		patientDao.savePatient(patient);
		responseStructure.setData(appointmentRecordDao.saveAppointmentRecord(appointmentRecord1));
		responseStructure.setMessage("sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<AppointmentRecord>>(responseStructure,HttpStatus.OK);
		
	}
	
	public ResponseEntity<ResponseStructure<AppointmentRecord>> getAppointmentRecordById(int id){
		ResponseStructure<AppointmentRecord> responseStructure=new ResponseStructure<AppointmentRecord>();
		responseStructure.setData(appointmentRecordDao.getAppointmentRecordById(id));
		responseStructure.setMessage("sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<AppointmentRecord>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<AppointmentRecord>> updateAppointmentRecord(int id,AppointmentRecord appointmentRecord){
		ResponseStructure<AppointmentRecord> responseStructure=new ResponseStructure<AppointmentRecord>();
		responseStructure.setData(appointmentRecordDao.updateAppointmentRecord(id, appointmentRecord));
		responseStructure.setMessage("sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<AppointmentRecord>>(responseStructure,HttpStatus.OK);
	}
	
	public boolean deleteAppointmentRecord(int id) {
		return appointmentRecordDao.deleteAppointmentRecord(id);
	}
	
	public ResponseEntity<ResponseStructure<List<AppointmentRecord>>> getAllAppointmentRecord(){
		ResponseStructure<List<AppointmentRecord>> responseStructure=new ResponseStructure<List<AppointmentRecord>>();
		responseStructure.setData(appointmentRecordDao.getAllAppointmentRecord());
		responseStructure.setMessage("sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<AppointmentRecord>>>(responseStructure,HttpStatus.OK);
	}
}	