package com.ppc.ffs.branch.application.port.out;

import com.ppc.ffs.branch.domain.BranchInfo;
import com.ppc.ffs.branch.domain.BranchRegisterInfo;

public interface RegisterBranchPort {
	BranchInfo saveBranch(BranchRegisterInfo createInfo);
}
