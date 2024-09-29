package com.jspider.hospital_app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspider.hospital_app.dao.BranchDao;
import com.jspider.hospital_app.dao.HospitalDao;
import com.jspider.hospital_app.dao.PatientDao;
import com.jspider.hospital_app.entity.Branch;
import com.jspider.hospital_app.entity.Hospital;
import com.jspider.hospital_app.entity.Patient;
import com.jspider.hospital_app.util.ResponseStructure;

@Service
public class BranchService {
	@Autowired
	private HospitalDao hospitalDao;
	@Autowired
	private BranchDao branchDao;
	@Autowired
	private PatientDao patientDao;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(int hospital_id,int patient_id, Branch branch) {
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		Branch branch1 = branchDao.saveBranch(branch);
		Hospital hospital = hospitalDao.getHospitalById(hospital_id);
		Patient patient=patientDao.getPatientById(patient_id);
		if (hospital.getBranches() == null && patient.getBranches() == null) {
			List<Branch> list = new ArrayList<Branch>();
			list.add(branch1);
			hospital.setBranches(list);
		} else {
			hospital.getBranches().add(branch1);
			patient.getBranches().add(branch1);
		}
		hospitalDao.saveHospital(hospital);
		patientDao.savePatient(patient);
		responseStructure.setData(branchDao.saveBranch(branch1));
		responseStructure.setMessage("sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(int id){
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		responseStructure.setData(branchDao.getBranchById(id));
		responseStructure.setMessage("sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int id,Branch branch){
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		responseStructure.setData(branchDao.updateBranch(id, branch));
		responseStructure.setMessage("sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
	}
	
	public boolean deleteBranch(int id) {
		return branchDao.deleteBranch(id);
	}
	
	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranch(){
		ResponseStructure<List<Branch>> responseStructure=new ResponseStructure<List<Branch>>();
		responseStructure.setData(branchDao.getAllBranch());
		responseStructure.setMessage("sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Branch>>>(responseStructure,HttpStatus.OK);
	} 
}
