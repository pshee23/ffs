package com.ppc.ffs.member.adapter.out.persistence.repository;

import com.ppc.ffs.member.adapter.out.persistence.entity.Member;
import com.ppc.ffs.member.domain.MemberInfo;

import java.util.ArrayList;
import java.util.List;

public class MemberInfoMapper {

    public MemberInfo mapMemberToMemberInfo(Member member){
         MemberInfo memberInfo = MemberInfo.builder()
                 .memberId(member.getMemberId())
                 .name(member.getName())
                 .employeeId(member.getEmployee().getEmployeeId())
                 .status(member.getStatus())
                 .branchId(member.getBranch().getBranchId())
                 .passwordType(member.getPasswordType())
                 .loginPassword(member.getLoginPassword())
                 .loginId(member.getLoginId())
                 .passwordSalt(member.getPasswordSalt())
                 .regDate(member.getRegDate())
                 .build();
         return memberInfo;
    }

    public List<MemberInfo> mapMemberListToMemberInfoList(List<Member> memberList) {
        List<MemberInfo> memberInfoList = new ArrayList<>();

        if(memberList == null){
            return memberInfoList;
        }

        for(Member member: memberList){
            MemberInfo memberInfo = mapMemberToMemberInfo(member);
            memberInfoList.add(memberInfo);
        }

        return memberInfoList;
    }
}
