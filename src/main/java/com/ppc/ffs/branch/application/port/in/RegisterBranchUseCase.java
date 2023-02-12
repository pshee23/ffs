package com.ppc.ffs.branch.application.port.in;

import com.ppc.ffs.branch.domain.BranchInfo;
import com.ppc.ffs.branch.domain.BranchModifyInfo;
import com.ppc.ffs.branch.domain.BranchRegisterInfo;

public interface RegisterBranchUseCase {
	BranchInfo registerBranch(BranchRegisterInfo createInfo);
	BranchInfo modifyBranch(BranchModifyInfo modifyInfo);
}
