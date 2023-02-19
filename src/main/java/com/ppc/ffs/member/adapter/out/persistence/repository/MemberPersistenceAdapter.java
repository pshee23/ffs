package com.ppc.ffs.member.adapter.out.persistence.repository;

import com.ppc.ffs.member.adapter.out.persistence.entity.Member;
import com.ppc.ffs.member.application.port.out.MemberPort;
import com.ppc.ffs.member.application.service.MemberUtil;
import com.ppc.ffs.member.domain.MemberInfo;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class MemberPersistenceAdapter implements MemberPort {

    private MemberRepository memberRepository;

    @Override
    public Member saveMember(Member member) {
         return memberRepository.save(member);
    }

    public Optional<Member> findById(Long memberId) {
        return memberRepository.findById(memberId);
    }

    @Override
    public Member findByLoginIdAndLoginPassword(String loginId, String loginPassword) {
        return memberRepository.findByLoginIdAndLoginPassword(loginId,loginPassword);
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public List<Member> findByNameOrLoginId(String name, String loginId) {
        return memberRepository.findByNameOrLoginId(name,loginId);
    }

    @Override
    public List<Member> findByNameOrLoginId(String name, String loginId, Pageable pageable) {
        return memberRepository.findByNameOrLoginId(name,loginId,pageable);
    }

    @Override
    public MemberInfo findByLoginId(String loginId) {

        return MemberUtil.getInstance().convertMemberToBean(memberRepository.findByLoginId(loginId));
    }
}
