package com.ppc.ffs.branch.adapter.out.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ppc.ffs.branch.adapter.out.persistence.entity.Branch;
import com.ppc.ffs.branch.application.port.out.RegisterBranchPort;
import com.ppc.ffs.branch.application.port.out.SelectBranchPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class BranchPersistenceAdapter implements RegisterBranchPort, SelectBranchPort {
	
	private final BranchRepository branchRepository;
	
	@Override
	public Branch saveBranch(Branch branch) {
		return branchRepository.save(branch);
	}

	@Override
	public List<Branch> findAllBranch() {
		return branchRepository.findAll();
	}
	
	@Override
	public Optional<Branch> findById(Long id) {
		return branchRepository.findById(id);
	}
}
