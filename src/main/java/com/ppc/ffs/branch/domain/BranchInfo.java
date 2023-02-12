package com.ppc.ffs.branch.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BranchInfo {
	private Long branchId;
	private String name;
	private String address;
	private String phoneNumber;
}
