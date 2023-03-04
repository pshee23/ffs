package com.ppc.ffs.branch.application.port.in;

import com.ppc.ffs.branch.adapter.in.web.form.BranchSelectResponse;

public interface SelectBranchUseCase {
	BranchSelectResponse selectAllBranch();
	BranchSelectResponse selectBranch(Long id);
	BranchSelectResponse selectBranchEmployee(Long id);
}
