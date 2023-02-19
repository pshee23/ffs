package com.ppc.ffs.branch.adapter.in.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppc.ffs.branch.application.port.in.SelectBranchUseCase;
import com.ppc.ffs.branch.domain.BranchInfo;
import com.ppc.ffs.employee.adapter.out.persistence.entity.Employee;

@RequestMapping("/branch/list")
@RestController
public class SelectBranchController {

	@Autowired
	private SelectBranchUseCase selectBranchUseCase;
	
	@GetMapping
	public ResponseEntity<String> selectAllBranch() {
		List<BranchInfo> allBranchList = selectBranchUseCase.selectAllBranch();
		return getJsonResponseEntity(allBranchList, HttpStatus.OK);
	}
	
	@GetMapping("/{branchId}")
	public ResponseEntity<String> selectOneBranch(@PathVariable Long branchId) {
		BranchInfo branchInfo = selectBranchUseCase.selectBranch(branchId);
		return getJsonResponseEntity(branchInfo, HttpStatus.OK);
	}
	
	@GetMapping("/{branchId}/employee")
	public ResponseEntity<String> selectBranchEmployee(@PathVariable Long branchId) {
		List<Employee> employeeList = selectBranchUseCase.selectBranchEmployee(branchId);
		return getJsonResponseEntity(employeeList, HttpStatus.OK);
	}
	
	public ResponseEntity<String> getJsonResponseEntity(Object obj, HttpStatus status) {
		HttpHeaders responseHeader = new HttpHeaders();
		responseHeader.add("Content-Type", "application/json");
		return new ResponseEntity<>(obj.toString(), responseHeader, status);
	}
}
