package com.jspider.hospital_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspider.hospital_app.entity.Branch;

public interface BranchJPA extends JpaRepository<Branch, Integer>{

}
