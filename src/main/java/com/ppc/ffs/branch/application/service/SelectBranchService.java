package com.ppc.ffs.branch.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ppc.ffs.branch.application.port.in.SelectBranchUseCase;
import com.ppc.ffs.branch.application.port.out.SelectBranchPort;
import com.ppc.ffs.branch.domain.BranchInfo;
import com.ppc.ffs.employee.adapter.out.persistence.entity.Employee;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SelectBranchService implements SelectBranchUseCase {

	private final SelectBranchPort selectBranchPort;
	
	@Override
	public List<BranchInfo> selectAllBranch() {
		return selectBranchPort.findAllBranch();
	}

	@Override
	public BranchInfo selectBranch(Long id) {
		return selectBranchPort.findBranchInfoById(id);
	}

	@Override
	public List<Employee> selectBranchEmployee(Long id) {
		List<Employee> branch = selectBranchPort.findEmployeeListById(id);
		return branch;
	}

}
