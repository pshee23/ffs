package com.ppc.ffs.branch.application.port.in;

import java.util.List;

import com.ppc.ffs.branch.domain.BranchInfo;

public interface SelectBranchUseCase {
	List<BranchInfo> selectAllBranch();
	BranchInfo selectBranch(Long id);
}
