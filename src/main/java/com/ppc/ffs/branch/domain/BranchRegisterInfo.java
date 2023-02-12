package com.ppc.ffs.branch.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BranchRegisterInfo {
	private String name;
	private String address;
	private String phoneNumber;
}
