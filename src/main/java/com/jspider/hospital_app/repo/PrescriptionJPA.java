package com.jspider.hospital_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspider.hospital_app.entity.Prescription;

public interface PrescriptionJPA extends JpaRepository<Prescription, Integer>{

}
