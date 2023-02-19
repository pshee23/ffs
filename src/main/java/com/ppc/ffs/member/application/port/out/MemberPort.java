package com.ppc.ffs.member.application.port.out;

import com.ppc.ffs.member.adapter.out.persistence.entity.Member;
import com.ppc.ffs.member.domain.MemberInfo;

import java.util.List;
import java.util.Optional;

public interface MemberPort {

    Member saveMember(Member member);

    Member findByLoginIdAndLoginPassword(String loginId, String loginPassword);

    List<Member> findAll();

    List<Member> findByNameOrLoginId(String name,String loginId);

    MemberInfo findByLoginId(String loginId);

    Optional<Member> findById(Long memberId);
}
