package com.jspider.hospital_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspider.hospital_app.entity.Branch;
import com.jspider.hospital_app.entity.Hospital;
import com.jspider.hospital_app.repo.BranchJPA;

@Repository
public class BranchDao {
	@Autowired
	private BranchJPA branchJPA;
	public Branch saveBranch(Branch branch) {
		return branchJPA.save(branch);
	}
	
	public Branch getBranchById(int id) {
		Optional<Branch> optional=branchJPA.findById(id);
		return optional.isPresent()?optional.get():null;
	}
	
	public Branch updateBranch(int id,Branch branch) {
		Branch branch1=branchJPA.getById(id);
		if(branch1!=null) {
			branch.setBranch_id(id);;
			return branchJPA.save(branch);
		}
		return null;
	}
	
	public boolean deleteBranch(int id) {
		Branch branch=getBranchById(id);
		if(branch!= null) {
			branchJPA.delete(branch);
			return true;
		}
		return false;
	}
	
	public List<Branch> getAllBranch(){
		return branchJPA.findAll();
	}

}
