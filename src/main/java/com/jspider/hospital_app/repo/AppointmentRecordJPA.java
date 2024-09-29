package com.jspider.hospital_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspider.hospital_app.entity.AppointmentRecord;

public interface AppointmentRecordJPA extends JpaRepository<AppointmentRecord, Integer>{

}
