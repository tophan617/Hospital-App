package com.jspider.hospital_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspider.hospital_app.entity.Hospital;
import com.jspider.hospital_app.entity.Patient;
import com.jspider.hospital_app.repo.PatientJPA;

@Repository
public class PatientDao {
	@Autowired
	private PatientJPA patientJPA;
	
	public Patient savePatient(Patient patient) {
		return patientJPA.save(patient);
	}
	
	public Patient getPatientById(int id) {
		Optional<Patient> optional=patientJPA.findById(id);
		return optional.isPresent()?optional.get():null;
	}
	
	public Patient updatePatient(int id,Patient patient) {
		Patient patient1=patientJPA.getById(id);
		if(patient1!=null) {
			patient.setPatient_id(id);;
			return patientJPA.save(patient);
		}
		return null;
	}
	
	public boolean deletePatient(int id) {
		Patient patient=getPatientById(id);
		if(patient!= null) {
			patientJPA.delete(patient);
			return true;
		}
		return false;
	}
	
	public List<Patient> getAllPatient(){
		return patientJPA.findAll();
	}
}
