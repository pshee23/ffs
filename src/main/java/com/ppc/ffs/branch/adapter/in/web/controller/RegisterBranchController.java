package com.ppc.ffs.branch.adapter.in.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppc.ffs.branch.adapter.in.web.form.BranchCreateRequest;
import com.ppc.ffs.branch.adapter.in.web.form.BranchUpdateRequest;
import com.ppc.ffs.branch.application.port.in.RegisterBranchUseCase;
import com.ppc.ffs.branch.domain.BranchInfo;
import com.ppc.ffs.branch.domain.BranchModifyInfo;
import com.ppc.ffs.branch.domain.BranchRegisterInfo;

@RequestMapping("/branch")
@RestController
public class RegisterBranchController {

	@Autowired
	private RegisterBranchUseCase registerBranchUseCase;
	
	@PostMapping
	public ResponseEntity<String> registerBranch(@RequestBody @Valid BranchCreateRequest request) {
		BranchRegisterInfo createInfo = request.of();
		BranchInfo branchInfo = registerBranchUseCase.registerBranch(createInfo);
		return getJsonResponseEntity(branchInfo, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<String> modifyBranch(@RequestBody @Valid BranchUpdateRequest request) {
		BranchModifyInfo modifyInfo = request.of();
		BranchInfo branchInfo = registerBranchUseCase.modifyBranch(modifyInfo);
		return getJsonResponseEntity(branchInfo, HttpStatus.OK);
	}
	
	public ResponseEntity<String> getJsonResponseEntity(Object obj, HttpStatus status) {
		HttpHeaders responseHeader = new HttpHeaders();
		responseHeader.add("Content-Type", "application/json");
		return new ResponseEntity<>(obj.toString(), responseHeader, status);
	}
}
