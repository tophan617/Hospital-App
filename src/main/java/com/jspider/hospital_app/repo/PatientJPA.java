package com.jspider.hospital_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspider.hospital_app.entity.Patient;

public interface PatientJPA extends JpaRepository<Patient, Integer>{

}
