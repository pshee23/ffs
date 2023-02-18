package com.ppc.ffs.branch.adapter.in.web.form;

import com.ppc.ffs.branch.domain.BranchRegisterInfo;

import lombok.Data;

@Data
public class BranchCreateRequest {
	private String name;
	private String address;
	private String phoneNumber;
	
	public BranchRegisterInfo of() {
		return BranchRegisterInfo.builder()
				.name(name)
				.address(address)
				.phoneNumber(phoneNumber)
				.build();
	}
}
