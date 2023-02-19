package com.ppc.ffs.branch.application.port.in;

import java.util.List;

import com.ppc.ffs.branch.domain.BranchInfo;
import com.ppc.ffs.employee.adapter.out.persistence.entity.Employee;

public interface SelectBranchUseCase {
	List<BranchInfo> selectAllBranch();
	BranchInfo selectBranch(Long id);
	List<Employee> selectBranchEmployee(Long id);
}
