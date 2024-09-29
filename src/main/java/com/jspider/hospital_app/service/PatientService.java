package com.jspider.hospital_app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.jspider.hospital_app.dao.BranchDao;
import com.jspider.hospital_app.dao.PatientDao;
import com.jspider.hospital_app.entity.Branch;
import com.jspider.hospital_app.entity.Patient;
import com.jspider.hospital_app.util.ResponseStructure;
@Service
public class PatientService {
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private BranchDao branchDao;
	
	public ResponseEntity<ResponseStructure<Patient>> savePatient(int branch_id,Patient patient){
		ResponseStructure<Patient> responseStructure=new ResponseStructure<Patient>();
		Patient patient1=patientDao.savePatient(patient);
		Branch branch=branchDao.getBranchById(branch_id);
		if(branch.getPatient()==null) {
			List<Patient> list=new ArrayList<Patient>();
			list.add(patient1);
			branch.setPatient(list);
		}else {
			branch.getPatient().add(patient1);
		}
		branchDao.saveBranch(branch);
		responseStructure.setData(patientDao.savePatient(patient1));
		responseStructure.setMessage("sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Patient>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Patient>> getPatientById(int id){
		ResponseStructure<Patient> responseStructure=new ResponseStructure<Patient>();
		responseStructure.setData(patientDao.getPatientById(id));
		responseStructure.setMessage("sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Patient>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Patient>> updatePatient(int id,Patient patient){
		ResponseStructure<Patient> responseStructure=new ResponseStructure<Patient>();
		responseStructure.setData(patientDao.updatePatient(id, patient));
		responseStructure.setMessage("sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Patient>>(responseStructure,HttpStatus.OK);
	}
	
	public boolean deletPatient(int id) {
		return patientDao.deletePatient(id);
	}
	
	public ResponseEntity<ResponseStructure<List<Patient>>> getAllPatient(){
		ResponseStructure<List<Patient>> responseStructure=new ResponseStructure<List<Patient>>();
		responseStructure.setData(patientDao.getAllPatient());
		responseStructure.setMessage("sucess");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Patient>>>(responseStructure,HttpStatus.OK);
	}
}
