package com.ppc.ffs.branch.adapter.out.persistence.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Repository;

import com.ppc.ffs.branch.adapter.out.persistence.entity.Branch;
import com.ppc.ffs.branch.application.port.out.RegisterBranchPort;
import com.ppc.ffs.branch.application.port.out.SelectBranchPort;
import com.ppc.ffs.branch.domain.BranchInfo;
import com.ppc.ffs.branch.domain.BranchRegisterInfo;
import com.ppc.ffs.employee.adapter.out.persistence.entity.Employee;
import com.ppc.ffs.employee.adapter.out.persistence.repository.EmployeeInfoMapper;
import com.ppc.ffs.employee.domain.EmployeeInfo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class BranchPersistenceAdapter implements RegisterBranchPort, SelectBranchPort {
	
	private final BranchRepository branchRepository;
	private final BranchInfoMapper branchInfoMapper;
	private final EmployeeInfoMapper employeeInfoMapper;
	
	@Override
	public long saveBranch(BranchRegisterInfo createInfo) {
		Branch branch = branchInfoMapper.mapBranchRegisterInfoToBranch(createInfo);
		return branchRepository.save(branch).getBranchId();
	}

	@Override
	public List<BranchInfo> findAllBranch() {
		List<Branch> branchList = branchRepository.findAll();
		List<BranchInfo> branchInfoList = branchInfoMapper.mapBranchListToBranchInfoList(branchList);
		return branchInfoList;
	}
	
	@Override
	public BranchInfo findBranchInfoById(Long id) {
		Optional<Branch> branchOptional = branchRepository.findById(id);
		Branch branch = branchOptional.orElseThrow(EntityNotFoundException::new);
		return branchInfoMapper.mapBranchToBranchInfo(branch);
	}
	
	@Override
	public List<EmployeeInfo> findEmployeeListById(Long id) {
		Optional<Branch> branchOptional = branchRepository.findById(id);
		Branch branch = branchOptional.orElseThrow(EntityNotFoundException::new);
		List<Employee> employeeList = branch.getEmployeeList();
		List<EmployeeInfo> infoList = employeeInfoMapper.mapToDomainEntity(employeeList);
		return infoList;
	}
}
