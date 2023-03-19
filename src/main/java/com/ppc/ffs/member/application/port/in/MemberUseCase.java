package com.ppc.ffs.member.application.port.in;

import com.ppc.ffs.member.adapter.in.web.form.MemberRequest;
import com.ppc.ffs.member.adapter.in.web.form.MemberResponse;
import com.ppc.ffs.member.adapter.in.web.form.MemberSearchForm;
import com.ppc.ffs.member.domain.MemberInfo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberUseCase {

    public void addMember(MemberInfo memberInfo) throws Exception;

    MemberResponse selectMemberList(String name, String loginId);

    MemberResponse searchMemberList(String name, String loginId, Pageable pageable);

    void updateMember(MemberInfo memberInfo) throws Exception;

    MemberResponse getMember(Long memberId) throws Exception;

    MemberResponse getMemberByIdAndPassword(Long memberId,String loginId,String loginPassword) throws Exception;
}
