package com.ppc.ffs.branch.application.port.out;

import java.util.List;
import java.util.Optional;

import com.ppc.ffs.branch.adapter.out.persistence.entity.Branch;

public interface SelectBranchPort {
	List<Branch> findAllBranch();
	Optional<Branch> findById(Long id);
}
