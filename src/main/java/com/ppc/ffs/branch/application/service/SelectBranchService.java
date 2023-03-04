package com.ppc.ffs.branch.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ppc.ffs.branch.adapter.in.web.form.BranchSelectResponse;
import com.ppc.ffs.branch.application.port.in.SelectBranchUseCase;
import com.ppc.ffs.branch.application.port.out.SelectBranchPort;
import com.ppc.ffs.branch.domain.BranchInfo;
import com.ppc.ffs.employee.domain.EmployeeInfo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SelectBranchService implements SelectBranchUseCase {

	private final SelectBranchPort selectBranchPort;
	
	@Override
	public BranchSelectResponse selectAllBranch() {
		List<BranchInfo> list = selectBranchPort.findAllBranch();
		BranchSelectResponse response = new BranchSelectResponse();
		response.setCode(200);
		response.setMessage("success");
		response.setBranchList(list);
		return response;
	}

	@Override
	public BranchSelectResponse selectBranch(Long id) {
		BranchInfo branchInfo = selectBranchPort.findBranchInfoById(id);
		BranchSelectResponse response = new BranchSelectResponse();
		response.setCode(200);
		response.setMessage("success");
		response.setBranch(branchInfo);
		return response;
	}

	@Override
	public BranchSelectResponse selectBranchEmployee(Long id) {
		List<EmployeeInfo> employeeInfoList = selectBranchPort.findEmployeeListById(id);
		BranchSelectResponse response = new BranchSelectResponse();
		response.setCode(200);
		response.setMessage("success");
		response.setEmployeeList(employeeInfoList);
		return response;
	}

}
