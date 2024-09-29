package com.jspider.hospital_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspider.hospital_app.entity.AppointmentRecord;
import com.jspider.hospital_app.repo.AppointmentRecordJPA;

@Repository
public class AppointmentRecordDao {
	@Autowired
	private AppointmentRecordJPA appointmentRecordJPA;
	
	public AppointmentRecord saveAppointmentRecord(AppointmentRecord appointmentRecord) {
		return appointmentRecordJPA.save(appointmentRecord);
	}
	
	public AppointmentRecord getAppointmentRecordById(int id) {
		Optional<AppointmentRecord> optional=appointmentRecordJPA.findById(id);
		return optional.isPresent()?optional.get():null;
	}
	
	public AppointmentRecord updateAppointmentRecord(int id,AppointmentRecord appointmentRecord) {
		AppointmentRecord appointmentRecord1=appointmentRecordJPA.getById(id);
		if(appointmentRecord1!=null) {
			appointmentRecord.setAppointment_record_id(id);;
			return appointmentRecordJPA.save(appointmentRecord);
		}
		return null;
	}
	
	public boolean deleteAppointmentRecord(int id) {
		AppointmentRecord appointmentRecord=getAppointmentRecordById(id);
		if(appointmentRecord!= null) {
			appointmentRecordJPA.delete(appointmentRecord);
			return true;
		}
		return false;
	}
	
	public List<AppointmentRecord> getAllAppointmentRecord(){
		return appointmentRecordJPA.findAll();
	}
}
