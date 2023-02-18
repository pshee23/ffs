package com.ppc.ffs.branch.adapter.in.web.form;

import com.ppc.ffs.branch.domain.BranchModifyInfo;

import lombok.Data;

@Data
public class BranchUpdateRequest {
	private String name;
	private String address;
	private String phoneNumber;
	
	public BranchModifyInfo of(Long branchId) {
		return BranchModifyInfo.builder()
				.branchId(branchId)
				.name(name)
				.address(address)
				.phoneNumber(phoneNumber)
				.build();
	}
}
