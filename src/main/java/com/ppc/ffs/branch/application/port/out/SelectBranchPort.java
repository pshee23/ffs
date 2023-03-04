package com.ppc.ffs.branch.application.port.out;

import java.util.List;

import com.ppc.ffs.branch.domain.BranchInfo;
import com.ppc.ffs.employee.domain.EmployeeInfo;

public interface SelectBranchPort {
	List<BranchInfo> findAllBranch();
	BranchInfo findBranchInfoById(Long id);
	List<EmployeeInfo> findEmployeeListById(Long id);
}
