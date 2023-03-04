package com.ppc.ffs.branch.adapter.in.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppc.ffs.branch.adapter.in.web.form.BranchSelectResponse;
import com.ppc.ffs.branch.application.port.in.SelectBranchUseCase;

@RequestMapping("/branch/list")
@RestController
public class SelectBranchController {

	@Autowired
	private SelectBranchUseCase selectBranchUseCase;
	
	@GetMapping
	public ResponseEntity<String> selectAllBranch() {
		BranchSelectResponse response = selectBranchUseCase.selectAllBranch();
		return getJsonResponseEntity(response, HttpStatus.OK);
	}
	
	@GetMapping("/{branchId}")
	public ResponseEntity<String> selectOneBranch(@PathVariable Long branchId) {
		BranchSelectResponse response = selectBranchUseCase.selectBranch(branchId);
		return getJsonResponseEntity(response, HttpStatus.OK);
	}
	
	@GetMapping("/{branchId}/employee")
	public ResponseEntity<String> selectBranchEmployee(@PathVariable Long branchId) {
		BranchSelectResponse response = selectBranchUseCase.selectBranchEmployee(branchId);
		return getJsonResponseEntity(response, HttpStatus.OK);
	}
	
	public ResponseEntity<String> getJsonResponseEntity(Object obj, HttpStatus status) {
		HttpHeaders responseHeader = new HttpHeaders();
		responseHeader.add("Content-Type", "application/json");
		return new ResponseEntity<>(obj.toString(), responseHeader, status);
	}
}
