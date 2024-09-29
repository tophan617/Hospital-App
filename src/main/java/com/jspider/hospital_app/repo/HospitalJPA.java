package com.jspider.hospital_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspider.hospital_app.entity.Hospital;

public interface HospitalJPA extends JpaRepository<Hospital, Integer>{

}
