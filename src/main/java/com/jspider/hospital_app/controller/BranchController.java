package com.jspider.hospital_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.hospital_app.dao.BranchDao;
import com.jspider.hospital_app.entity.Branch;
import com.jspider.hospital_app.service.BranchService;
import com.jspider.hospital_app.util.ResponseStructure;

@RestController
public class BranchController {
	@Autowired
	private BranchService branchService;
	
	@PostMapping("/branch/hospital_id/{id}/patient_id/{pid}")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@PathVariable int id,@PathVariable int pid,@RequestBody Branch branch) {
		return branchService.saveBranch(id,pid, branch);
	}
	
	@GetMapping("/branch/id/{id}")
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(@PathVariable int id){
		return branchService.getBranchById(id);
	}
	
	@PutMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestParam int id,@RequestBody Branch branch){
		return branchService.updateBranch(id, branch);
	}
	
	@DeleteMapping("/branch/id/{id}")
	public boolean deleteBranch(@PathVariable int id) {
		return branchService.deleteBranch(id);
	}
	
	@GetMapping("/branch/getall")
	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranch(){
		return branchService.getAllBranch();
	}
}
