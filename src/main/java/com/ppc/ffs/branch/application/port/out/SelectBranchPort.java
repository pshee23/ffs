package com.ppc.ffs.branch.application.port.out;

import java.util.List;

import com.ppc.ffs.branch.adapter.out.persistence.entity.Branch;
import com.ppc.ffs.branch.domain.BranchInfo;
import com.ppc.ffs.employee.adapter.out.persistence.entity.Employee;

public interface SelectBranchPort {
	List<BranchInfo> findAllBranch();
	BranchInfo findBranchInfoById(Long id);
	List<Employee> findEmployeeListById(Long id);
}
