package com.ppc.ffs.branch.adapter.in.web.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.ppc.ffs.branch.domain.BranchRegisterInfo;

import lombok.Data;

@Data
public class BranchCreateRequest {
	@NotBlank
	private String name;
	
	@NotBlank
	private String address;
	
	@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$")
	private String phoneNumber;
	
	public BranchRegisterInfo of() {
		return BranchRegisterInfo.builder()
				.name(name)
				.address(address)
				.phoneNumber(phoneNumber)
				.build();
	}
}
