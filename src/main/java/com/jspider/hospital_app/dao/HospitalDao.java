package com.jspider.hospital_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspider.hospital_app.entity.Hospital;
import com.jspider.hospital_app.repo.HospitalJPA;

@Repository
public class HospitalDao {
	@Autowired
	private HospitalJPA hospitalJPA;
	public Hospital saveHospital(Hospital hospital) {
		return hospitalJPA.save(hospital);
	}
	
	public Hospital getHospitalById(int id) {
		Optional<Hospital> optional=hospitalJPA.findById(id);
		return optional.isPresent()?optional.get():null;
	}
	
	public Hospital updateHospital(int id,Hospital hospital) {
		Hospital hospital1=hospitalJPA.getById(id);
		if(hospital1!=null) {
			hospital.setHospital_id(id);
			return hospitalJPA.save(hospital);
		}
		return null;
	}
	
	public boolean deleteHospital(int id) {
		Hospital hospital=getHospitalById(id);
		if(hospital!= null) {
			hospitalJPA.delete(hospital);
			return true;
		}
		return false;
	}
	
	public List<Hospital> getAllHospital(){
		return hospitalJPA.findAll();
	}
}
