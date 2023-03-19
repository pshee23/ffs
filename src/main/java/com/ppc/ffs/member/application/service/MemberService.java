package com.ppc.ffs.member.application.service;

import com.ppc.ffs.branch.adapter.in.web.form.BranchSelectResponse;
import com.ppc.ffs.branch.adapter.out.persistence.entity.Branch;
import com.ppc.ffs.branch.application.port.out.SelectBranchPort;
import com.ppc.ffs.branch.domain.BranchInfo;
import com.ppc.ffs.employee.application.port.out.SelectEmployeePort;
import com.ppc.ffs.employee.domain.EmployeeInfo;
import com.ppc.ffs.member.adapter.in.web.form.MemberRequest;
import com.ppc.ffs.member.adapter.in.web.form.MemberResponse;
import com.ppc.ffs.member.adapter.in.web.form.MemberSearchForm;
import com.ppc.ffs.member.adapter.out.persistence.entity.Member;
import com.ppc.ffs.member.application.port.in.MemberUseCase;
import com.ppc.ffs.member.application.port.out.MemberPort;
import com.ppc.ffs.member.domain.MemberInfo;
import com.ppc.ffs.util.CommonService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService implements MemberUseCase {

    private final MemberPort memberPort;

    private final SelectBranchPort selectBranchPort;

    private final SelectEmployeePort selectEmployeePort;

    @Override
    public void addMember(MemberInfo memberInfo) throws Exception {
        BranchInfo branchInfo = selectBranchPort.findBranchInfoById(memberInfo.getBranchId());
        EmployeeInfo employeeInfo = selectEmployeePort.selectEmployeeInfo(memberInfo.getEmployeeId());

        if (branchInfo == null || employeeInfo == null) {
            //todo 브랜치 정보 없는 오류 처리
            throw new Exception();
        }

        MemberInfo existMemberInfo = memberPort.findByLoginId(memberInfo.getLoginId());

        if(existMemberInfo != null){
            //todo 이미 존재하는 아이디
            throw new Exception();
        }
        memberPort.saveMember(memberInfo);
    }

    @Override
    public MemberResponse selectMemberList(String name, String loginId) {
        List<MemberInfo> memberList = memberPort.findByNameOrLoginId(name,loginId);

        MemberResponse response = new MemberResponse();
        response.setCode(200);
        response.setMessage("success");
        response.setMemberInfoList(memberList);
        return response;
    }

    @Override
    public MemberResponse searchMemberList(String name, String loginId, Pageable pageable) {
        List<MemberInfo> memberList = memberPort.findByNameOrLoginId(name,loginId,pageable);

        MemberResponse response = new MemberResponse();
        response.setCode(200);
        response.setMessage("success");
        response.setMemberInfoList(memberList);
        return response;
    }

    @Override
    public void updateMember(MemberInfo memberInfo) throws Exception{
        MemberInfo existMemberInfo =  memberPort.findById(memberInfo.getMemberId());
        if(existMemberInfo == null){
            //user not found
            throw new Exception();
        }
        //TODO 객체변경 어떻게 해야하나요?

        memberPort.saveMember(memberInfo);

    }

    @Override
    public MemberResponse getMember(Long memberId) throws Exception{
        MemberInfo memberInfo = memberPort.findById(memberId);
        if(memberInfo == null){
            //user not found
            throw new Exception();
        }
        MemberResponse response = new MemberResponse();
        response.setCode(200);
        response.setMessage("success");
        response.setMemberInfo(memberInfo);
        return response;
    }

    @Override
    public MemberResponse getMemberByIdAndPassword(Long memberId, String loginId, String loginPassword) throws Exception {
        MemberInfo memberInfo = memberPort.findByMemberIdAndLoginIdAndLoginPassword(memberId, loginId, loginPassword);
        if(memberInfo == null){
            //TODO 사용자 없음
            throw new Exception();
        }
        MemberResponse response = new MemberResponse();
        response.setCode(200);
        response.setMessage("success");
        response.setMemberInfo(memberInfo);
        return response;
    }

}
