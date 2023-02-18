package com.ppc.ffs.branch.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ppc.ffs.branch.adapter.out.persistence.entity.Branch;
import com.ppc.ffs.branch.application.port.in.SelectBranchUseCase;
import com.ppc.ffs.branch.application.port.out.SelectBranchPort;
import com.ppc.ffs.branch.domain.BranchInfo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SelectBranchService implements SelectBranchUseCase {

	private final MappingBranchService mappingBranchService;
	private final SelectBranchPort selectBranchPort;
	
	@Override
	public List<BranchInfo> selectAllBranch() {
		List<Branch> branchList = selectBranchPort.findAllBranch();
		List<BranchInfo> branchInfoList = mappingBranchService.mapBranchListToBranchInfoList(branchList);
		return branchInfoList;
	}

	@Override
	public BranchInfo selectBranch(Long id) {
		Optional<Branch> branch = selectBranchPort.findById(id);
		BranchInfo branchInfo = mappingBranchService.mapBranchToBranchInfo(branch);
		return branchInfo;
	}

}
