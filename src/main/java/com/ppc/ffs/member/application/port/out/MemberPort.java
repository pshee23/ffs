package com.ppc.ffs.member.application.port.out;

import com.ppc.ffs.member.adapter.out.persistence.entity.Member;
import com.ppc.ffs.member.domain.MemberInfo;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MemberPort {

    Member saveMember(Member member);

    Member findByLoginIdAndLoginPassword(String loginId, String loginPassword);

    List<Member> findAll();

    List<Member> findByNameOrLoginId(String name,String loginId);

    List<Member> findByNameOrLoginId(String name, String loginId, Pageable pageable);

    MemberInfo findByLoginId(String loginId);

    Optional<Member> findById(Long memberId);
}
