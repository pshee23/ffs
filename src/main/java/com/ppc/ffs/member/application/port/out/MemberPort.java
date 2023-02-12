package com.ppc.ffs.member.application.port.out;

import com.ppc.ffs.member.adapter.out.persistence.entity.Member;

import java.util.List;

public interface MemberPort {

    Member insertMember(Member member);

    Member findByLoginIdAndLoginPassword(String loginId, String loginPassword);

    List<Member> findAll();

    List<Member> findByNameOrLoginId(String name,String loginId);
}
