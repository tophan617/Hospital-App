package com.jspider.hospital_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspider.hospital_app.entity.Hospital;
import com.jspider.hospital_app.entity.Prescription;
import com.jspider.hospital_app.repo.PrescriptionJPA;

@Repository
public class PrescriptionDao {
	@Autowired
	private PrescriptionJPA prescriptionJPA;
	
	public Prescription savePrescription(Prescription prescription) {
		return prescriptionJPA.save(prescription);
	}
	
	public Prescription getPrescriptionById(int id) {
		Optional<Prescription> optional=prescriptionJPA.findById(id);
		return optional.isPresent()?optional.get():null;
	}
	
	public Prescription updatePrescription(int id,Prescription prescription) {
		Prescription prescription1=prescriptionJPA.getById(id);
		if(prescription1!=null) {
			prescription.setPrescription_id(id);;
			return prescriptionJPA.save(prescription);
		}
		return null;
	}
	
	public boolean deletePrescription(int id) {
		Prescription prescription=getPrescriptionById(id);
		if(prescription!= null) {
			prescriptionJPA.delete(prescription);
			return true;
		}
		return false;
	}
	
	public List<Prescription> getAllPrescription(){
		return prescriptionJPA.findAll();
	}

}
