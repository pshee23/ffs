package com.ppc.ffs.branch.application.port.out;

import com.ppc.ffs.branch.adapter.out.persistence.entity.Branch;

public interface RegisterBranchPort {
	Branch saveBranch(Branch branch);
}
