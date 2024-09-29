package com.jspider.hospital_app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspider.hospital_app.dao.Medical_itemsDao;
import com.jspider.hospital_app.dao.PrescriptionDao;
import com.jspider.hospital_app.entity.Medical_items;
import com.jspider.hospital_app.entity.Prescription;
import com.jspider.hospital_app.util.ResponseStructure;

@Service
public class Medical_itemsService {
	@Autowired
	private Medical_itemsDao medical_itemsDao;
	@Autowired
	private PrescriptionDao prescriptionDao;
	public ResponseEntity<ResponseStructure<Medical_items>> saveMedical_items(int prescription_id,Medical_items medical_items){
		ResponseStructure<Medical_items> responseStructure=new ResponseStructure<Medical_items>();
		Medical_items medical_items1=medical_itemsDao.saveMedical_items(medical_items);
		Prescription prescription=prescriptionDao.getPrescriptionById(prescription_id);
		if(prescription.getMedical_items()==null) {
			List<Medical_items> list=new ArrayList<Medical_items>();
			list.add(medical_items1);
			prescription.setMedical_items(list);
		}else {
			prescription.getMedical_items().add(medical_items1);
		}
		prescriptionDao.savePrescription(prescription);
		responseStructure.setData(medical_itemsDao.saveMedical_items(medical_items1));
		responseStructure.setMessage("sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Medical_items>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Medical_items>> getMedical_itemsById(int id){
		ResponseStructure<Medical_items> responseStructure=new ResponseStructure<Medical_items>();
		responseStructure.setData(medical_itemsDao.getMedical_itemsById(id));
		responseStructure.setMessage("sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Medical_items>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Medical_items>> updateMedical_items(int id,Medical_items medical_items){
		ResponseStructure<Medical_items> responseStructure=new ResponseStructure<Medical_items>();
		responseStructure.setData(medical_itemsDao.updateMedical_items(id, medical_items));
		responseStructure.setMessage("sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Medical_items>>(responseStructure,HttpStatus.OK);
	}
	
	public boolean deleteMedical_items(int id) {
		return medical_itemsDao.deleteMedical_items(id);
	}
	
	public ResponseEntity<ResponseStructure<List<Medical_items>>> getAllMedical_items(){
		ResponseStructure<List<Medical_items>> responseStructure=new ResponseStructure<List<Medical_items>>();
		responseStructure.setData(medical_itemsDao.getAllMedical_items());
		responseStructure.setMessage("sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Medical_items>>>(responseStructure,HttpStatus.OK);
	}
}
