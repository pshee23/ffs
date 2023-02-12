package com.ppc.ffs.branch.application.service;

import org.springframework.stereotype.Service;

import com.ppc.ffs.branch.adapter.out.persistence.entity.Branch;
import com.ppc.ffs.branch.application.port.in.RegisterBranchUseCase;
import com.ppc.ffs.branch.application.port.out.RegisterBranchPort;
import com.ppc.ffs.branch.domain.BranchInfo;
import com.ppc.ffs.branch.domain.BranchModifyInfo;
import com.ppc.ffs.branch.domain.BranchRegisterInfo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterBranchService implements RegisterBranchUseCase {
	
	private final MappingBranchService mappingBranchService;
	private final RegisterBranchPort registerBranchPort;
	
	@Override
	public BranchInfo registerBranch(BranchRegisterInfo createInfo) {
		Branch branch = mappingBranchService.mapBranchRegisterInfoToBranch(createInfo);
		branch = registerBranchPort.saveBranch(branch);
		
		BranchInfo branchInfo = mappingBranchService.mapBranchToBranchInfo(branch);
		return branchInfo;
	}
	
	@Override
	public BranchInfo modifyBranch(BranchModifyInfo modifyInfo) {
		
		return null;
	}
}
