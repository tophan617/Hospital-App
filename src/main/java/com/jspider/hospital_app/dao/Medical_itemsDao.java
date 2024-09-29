package com.jspider.hospital_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspider.hospital_app.entity.Hospital;
import com.jspider.hospital_app.entity.Medical_items;
import com.jspider.hospital_app.repo.Medical_itemsJPA;

@Repository
public class Medical_itemsDao {
	@Autowired
	private Medical_itemsJPA medical_itemsJPA;
	public Medical_items saveMedical_items(Medical_items medical_items) {
		return medical_itemsJPA.save(medical_items);
	}
	
	public Medical_items getMedical_itemsById(int id) {
		Optional<Medical_items> optional=medical_itemsJPA.findById(id);
		return optional.isPresent()?optional.get():null;
	}
	
	public Medical_items updateMedical_items(int id,Medical_items medical_items) {
		Medical_items medical_items1=medical_itemsJPA.getById(id);
		if(medical_items1!=null) {
			medical_items.setMedical_item_id(id);;
			return medical_itemsJPA.save(medical_items);
		}
		return null;
	}
	
	public boolean deleteMedical_items(int id) {
		Medical_items medical_items=getMedical_itemsById(id);
		if(medical_items!= null) {
			medical_itemsJPA.delete(medical_items);
			return true;
		}
		return false;
	}
	
	public List<Medical_items> getAllMedical_items(){
		return medical_itemsJPA.findAll();
	}

}
