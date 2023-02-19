package com.ppc.ffs.member.application.service;

import com.ppc.ffs.branch.adapter.out.persistence.entity.Branch;
import com.ppc.ffs.branch.application.port.out.SelectBranchPort;
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
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService implements MemberUseCase {

    private MemberPort memberPort;

    private SelectBranchPort selectBranchPort;

    private SelectEmployeePort selectEmployeePort;

    @Override
    public void addMember(MemberRequest memberRequest) throws Exception {
        //브랜치,직원 정보는 조회해서 가져온다.
        //TODO 서비스단에서 사용할 리턴 타입 객체
        Optional<Branch> optionalBranch = selectBranchPort.findById(memberRequest.getBranchId());
        EmployeeInfo employeeInfo = selectEmployeePort.selectEmployeeInfo(memberRequest.getEmployeeId());
        if (optionalBranch.isEmpty() || employeeInfo == null) {
            //todo 브랜치 정보 없는 오류 처리
            throw new Exception();
        }

        MemberInfo memberInfo = memberPort.findByLoginId(memberRequest.getLoginId());

        if(memberInfo != null){
            //todo 이미 존재하는 아이디
            throw new Exception();
        }

        String passwordType = "";//todo 설정파일에서 가져오기
        String passwordSalt = CommonService.makeKey(24);

        //todo 패스워드 암호화 처리 필요
        //String encrypt_password = memberInfo.getLoginPassword() + passwordSalt;


        Member member  = Member.builder()
                .name(memberRequest.getName())
                .loginId(memberRequest.getLoginId())
                .loginPassword(memberRequest.getLoginPassword())
                .passwordType(passwordType)
                .passwordSalt(passwordSalt)
                .status(memberRequest.getStatus())
                .regDate(new Date())
                .build();

        memberPort.saveMember(member);
    }


    @Override
    public List<MemberResponse> selectMemberList(MemberRequest memberRequest) {
        List<Member> memberList = memberPort.findByNameOrLoginId(memberRequest.getName(),memberRequest.getLoginId());
        List<MemberResponse> memberResponseList = new ArrayList<>();
        if(memberList == null || memberList.size() == 0){
            return memberResponseList;
        }
        //TODO Member > MemberInfo > MemberResponse로 바꿔야할까??
        for(Member member : memberList){
            MemberResponse memberResponse = MemberUtil.getInstance().convertMemberToResponse(member);
            memberResponseList.add(memberResponse);
        }
        return memberResponseList;
    }

    @Override
    public List<MemberResponse> searchMemberList(MemberSearchForm form, Pageable pageable) {
        List<Member> memberList = memberPort.findByNameOrLoginId(form.getName(),form.getLoginId(),pageable);
        List<MemberResponse> memberResponseList = new ArrayList<>();
        if(memberList == null || memberList.size() == 0){
            return memberResponseList;
        }
        //TODO Member > MemberInfo > MemberResponse로 바꿔야할까??
        for(Member member : memberList){
            MemberResponse memberResponse = MemberUtil.getInstance().convertMemberToResponse(member);
            memberResponseList.add(memberResponse);
        }
        return memberResponseList;
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
