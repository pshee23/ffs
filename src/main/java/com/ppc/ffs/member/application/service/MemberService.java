package com.ppc.ffs.member.application.service;

import com.ppc.ffs.member.adapter.in.web.form.MemberRequest;
import com.ppc.ffs.member.adapter.in.web.form.MemberResponse;
import com.ppc.ffs.member.adapter.out.persistence.entity.Member;
import com.ppc.ffs.member.application.port.in.MemberUseCase;
import com.ppc.ffs.member.application.port.out.MemberPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService implements MemberUseCase {

    private MemberPort memberPort;

    @Override
    public void addMember(MemberRequest memberRequest) {
        //TODO 브랜치와 같은 부가정보는 조회해서 가져온다.
        Member member  = Member.builder()
                .name(memberRequest.getName())
                .status(memberRequest.getStatus())
                .loginId(memberRequest.getLoginId())
                .loginPassword(memberRequest.getLoginPassword())
                .passwordType(memberRequest.getPasswordType())
                .passwordSalt(memberRequest.getPasswordSalt())
                .build();

        memberPort.saveMember(member);
    }


    @Override
    public List<MemberResponse> selectMemberList(MemberRequest memberRequest) {
        List<Member> memberList = memberPort.findByNameOrLoginId(memberRequest.getName(),memberRequest.getLoginId());

        //TODO 변환할때 for문으로 변경
        return null;
    }

    @Override
    public void updateMember(MemberRequest memberRequest) {
        Optional<Member> optionalMember =  memberPort.findById(memberRequest.getMemberId());
        Member member = null;
        if (optionalMember.isPresent()) {
            member = optionalMember.get();
        }
        //TODO 새로운 값 세팅을 어떻게 할꺼냐

        memberPort.saveMember(member);

    }

}
