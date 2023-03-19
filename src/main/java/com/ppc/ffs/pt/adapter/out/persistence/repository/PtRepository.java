package com.ppc.ffs.pt.adapter.out.persistence.repository;

import com.ppc.ffs.pt.adapter.out.persistence.entity.Pt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PtRepository extends JpaRepository<Pt, Long> {

    @Query(value = "SELECT p FROM PT p " +
            "WHERE p.MEMBER_ID = :memberId " +
            "AND p.USE_COUNT < p.TOTAL_COUNT " +
            "ORDER BY p.REGISTER_DATE", nativeQuery = true)
    Optional<Pt> findByMemberIdOrderByRegisterDate(Long memberId);
}
