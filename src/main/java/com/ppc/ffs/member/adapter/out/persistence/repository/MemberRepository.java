package com.ppc.ffs.member.adapter.out.persistence.repository;

import com.ppc.ffs.member.adapter.out.persistence.entity.Member;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long> {

    Member findByMemberIdAndLoginIdAndLoginPassword(Long memberId, String loginId, String loginPassword);

    List<Member> findByNameOrLoginId(String name, String loginId);

    List<Member> findByNameOrLoginId(String name, String loginId, Pageable pageable);

    Member findByLoginId(String loginId);
}
