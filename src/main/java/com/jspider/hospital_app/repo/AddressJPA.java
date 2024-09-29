package com.jspider.hospital_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspider.hospital_app.entity.Address;

public interface AddressJPA extends JpaRepository<Address, Integer>{

}
