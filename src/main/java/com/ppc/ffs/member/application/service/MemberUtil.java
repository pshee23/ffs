package com.ppc.ffs.member.application.service;

import com.ppc.ffs.member.adapter.in.web.form.MemberResponse;
import com.ppc.ffs.member.adapter.out.persistence.entity.Member;
import com.ppc.ffs.member.domain.MemberInfo;
import org.springframework.stereotype.Service;

@Service
public class MemberUtil {

    private static MemberUtil memberUtil = null;
    public static MemberUtil getInstance(){
        if( memberUtil == null ){
            memberUtil = new MemberUtil();
        }
        return memberUtil;
    }

    public MemberInfo convertMemberToBean(Member member) {
        return MemberInfo.builder()
                .memberId(member.getMemberId())
                .name(member.getName())
                .loginId(member.getLoginId())
                .loginPassword(member.getLoginPassword())
                .passwordType(member.getPasswordType())
                .passwordSalt(member.getPasswordSalt())
                .branch(member.getBranch())
                .employee(member.getEmployee())
                .build();
    }

    public MemberResponse convertMemberToResponse(Member member) {
        return MemberResponse.builder()
                .memberId(member.getMemberId())
                .name(member.getName())
                .loginId(member.getLoginId())
                .status(member.getStatus())
                .regDate(member.getRegDate())
                .branch(member.getBranch())
                .employee(member.getEmployee())
                .build();
    }
}
