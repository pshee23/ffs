package com.ppc.ffs.branch.adapter.in.web.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.ppc.ffs.branch.domain.BranchModifyInfo;

import lombok.Data;

@Data
public class BranchUpdateRequest {
	@NotNull
	private Long branchId;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String address;
	
	@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$")
	private String phoneNumber;
	
	public BranchModifyInfo of() {
		return BranchModifyInfo.builder()
				.branchId(branchId)
				.name(name)
				.address(address)
				.phoneNumber(phoneNumber)
				.build();
	}
}
