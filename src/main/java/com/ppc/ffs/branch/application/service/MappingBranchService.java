package com.ppc.ffs.branch.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ppc.ffs.branch.adapter.out.persistence.entity.Branch;
import com.ppc.ffs.branch.domain.BranchInfo;
import com.ppc.ffs.branch.domain.BranchRegisterInfo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MappingBranchService {
	
	public Branch mapBranchRegisterInfoToBranch(BranchRegisterInfo createInfo) {
		Branch branch = new Branch();
		branch.setName(createInfo.getName());
		branch.setAddress(createInfo.getAddress());
		branch.setPhoneNumber(createInfo.getPhoneNumber());
		return branch;
	}
	
	public BranchInfo mapBranchToBranchInfo(Optional<Branch> branch) {
		if(branch.isEmpty()) {
			return BranchInfo.builder().build();
		} else {
			return mapBranchToBranchInfo(branch.get());
		}
	}

	public BranchInfo mapBranchToBranchInfo(Branch branch) {
		BranchInfo branchInfo = BranchInfo.builder()
				.branchId(branch.getBranchId())
				.name(branch.getName())
				.address(branch.getAddress())
				.phoneNumber(branch.getPhoneNumber())
				.build();
		return branchInfo;
	}

	public List<BranchInfo> mapBranchListToBranchInfoList(List<Branch> branchList) {
		List<BranchInfo> branchInfoList = new ArrayList<>();
		
		if(branchList.isEmpty()) {
			return branchInfoList;
		}
		
		for(Branch branch : branchList) {
			BranchInfo branchInfo = mapBranchToBranchInfo(branch);
			branchInfoList.add(branchInfo);
		}
		
		return branchInfoList;
	}
}
