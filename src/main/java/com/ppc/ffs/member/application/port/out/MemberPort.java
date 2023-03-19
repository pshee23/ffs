package com.ppc.ffs.member.application.port.out;

import com.ppc.ffs.member.adapter.out.persistence.entity.Member;
import com.ppc.ffs.member.domain.MemberInfo;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MemberPort {

    Long saveMember(MemberInfo memberInfo);

    MemberInfo findByMemberIdAndLoginIdAndLoginPassword(Long memberId, String loginId, String loginPassword);

    List<MemberInfo> findAll();

    List<MemberInfo> findByNameOrLoginId(String name,String loginId);

    List<MemberInfo> findByNameOrLoginId(String name, String loginId, Pageable pageable);

    MemberInfo findByLoginId(String loginId);

    MemberInfo findById(Long memberId);
}
