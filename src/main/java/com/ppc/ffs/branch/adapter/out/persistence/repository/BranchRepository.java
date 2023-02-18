package com.ppc.ffs.branch.adapter.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppc.ffs.branch.adapter.out.persistence.entity.Branch;

public interface BranchRepository extends JpaRepository<Branch, Long> {

}