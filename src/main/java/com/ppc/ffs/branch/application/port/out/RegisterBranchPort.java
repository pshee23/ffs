package com.ppc.ffs.branch.application.port.out;

import com.ppc.ffs.branch.domain.BranchRegisterInfo;

public interface RegisterBranchPort {
	long saveBranch(BranchRegisterInfo createInfo);
}
