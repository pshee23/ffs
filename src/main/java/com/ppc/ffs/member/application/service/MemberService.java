package com.ppc.ffs.member.application.service;

import com.ppc.ffs.member.adapter.in.web.form.MemberRequest;
import com.ppc.ffs.member.adapter.in.web.form.MemberResponse;
import com.ppc.ffs.member.adapter.out.persistence.entity.Member;
import com.ppc.ffs.member.application.port.in.MemberUseCase;
import com.ppc.ffs.member.application.port.out.MemberPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService implements MemberUseCase {

    private MemberPort memberPort;

    @Override
    public void addMember(MemberRequest memberRequest) {
        Member member  = Member.builder()
                .name(memberRequest.getName())
                .status(memberRequest.getStatus())
                .loginId(memberRequest.getLoginId())
                .loginPassword(memberRequest.getLoginPassword())
                .passwordType(memberRequest.getPasswordType())
                .passwordSalt(memberRequest.getPasswordSalt())
                .build();

        memberPort.insertMember(member);
    }


    @Override
    public List<MemberResponse> selectMemberList(MemberRequest memberRequest) {
        //TODO 값이 있는 경우에만 쿼리에 추가하려면 어떻게 해야할까?

        List<Member> memberList = memberPort.findByNameOrLoginId(memberRequest.getName(),memberRequest.getLoginId());

        
    }

}
