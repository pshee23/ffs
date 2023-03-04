package com.ppc.ffs.branch.adapter.in.web.form;

import java.util.List;

import com.ppc.ffs.branch.domain.BranchInfo;
import com.ppc.ffs.employee.domain.EmployeeInfo;

import lombok.Data;

@Data
public class BranchSelectResponse {
	private int code;
	private String message;
	private List<BranchInfo> branchList;
	private BranchInfo branch;
	private List<EmployeeInfo> employeeList;
}
