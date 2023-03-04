package com.ppc.ffs.branch.application.service;

import org.springframework.stereotype.Service;

import com.ppc.ffs.branch.application.port.in.RegisterBranchUseCase;
import com.ppc.ffs.branch.application.port.out.RegisterBranchPort;
import com.ppc.ffs.branch.domain.BranchInfo;
import com.ppc.ffs.branch.domain.BranchModifyInfo;
import com.ppc.ffs.branch.domain.BranchRegisterInfo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterBranchService implements RegisterBranchUseCase {
	
	private final RegisterBranchPort registerBranchPort;
	
	@Override
	public long registerBranch(BranchRegisterInfo createInfo) {
		return registerBranchPort.saveBranch(createInfo);
	}
	
	@Override
	public BranchInfo modifyBranch(BranchModifyInfo modifyInfo) {
		
		return null;
	}
}
