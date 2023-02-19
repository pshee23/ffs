package com.ppc.ffs.member.adapter.out.persistence.repository;

import com.ppc.ffs.member.adapter.out.persistence.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long> {

    Member findByLoginIdAndLoginPassword(String loginId, String loginPassword);

    List<Member> findByNameOrLoginId(String name, String loginId);

    Member findByLoginId(String loginId);
}
