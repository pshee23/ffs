package com.ppc.ffs.member.adapter.in.web.controller;

import com.ppc.ffs.member.adapter.in.web.form.MemberPasswordRequest;
import com.ppc.ffs.member.adapter.in.web.form.MemberRequest;
import com.ppc.ffs.member.adapter.in.web.form.MemberResponse;
import com.ppc.ffs.member.adapter.in.web.form.MemberSearchForm;
import com.ppc.ffs.member.application.port.in.MemberUseCase;
import com.ppc.ffs.member.domain.MemberInfo;
import com.ppc.ffs.util.APIResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/member/")
public class MemberController {

    private final MemberUseCase memberUseCase;

    @PostMapping("add")
    public ResponseEntity<Object> addMember(@RequestBody MemberRequest memberRequest) throws Exception{

        //TODO 데이터 Validation 처리 필요
        MemberInfo memberInfo = memberRequest.of();
        memberUseCase.addMember(memberInfo);

        return APIResponse.success();
    }

    @GetMapping("list")
    public ResponseEntity<Object> searchMember(@RequestParam MemberSearchForm form,
                                               @PageableDefault(size = 15, sort = "regDate", direction = Sort.Direction.DESC) Pageable pageable) {
        String name = form.getName();
        String loginId = form.getLoginId();
        MemberResponse memberResponse = memberUseCase.searchMemberList(name,loginId,pageable);

        return APIResponse.success(memberResponse);
    }

    @GetMapping("view/{memberId}")
    public ResponseEntity<Object> searchMember(@PathVariable("memberId") Long memberId) throws Exception{

        MemberResponse memberResponse = memberUseCase.getMember(memberId);

        return APIResponse.success(memberResponse);
    }

    @PostMapping("edit")
    public ResponseEntity<Object> editMember(@RequestBody MemberRequest memberRequest) throws Exception {
        MemberInfo memberInfo = memberRequest.of();
        memberUseCase.updateMember(memberInfo);

        return  APIResponse.success();
    }

    @PostMapping("changePassword/{memberId}")
    public ResponseEntity<Object> changePassword(@PathVariable("memberId") Long memberId, @RequestBody MemberPasswordRequest passwordRequest) {

        if(!StringUtils.equals(passwordRequest.getNewPassword(), passwordRequest.getNewPasswordConfirm())){
            return APIResponse.error(100,"패스워드 확인 불일치",400);
        }

        try{
            MemberResponse memberResponse = memberUseCase.getMemberByIdAndPassword(memberId, passwordRequest.getLoginId(), passwordRequest.getOriginPassword());
        }catch (Exception e){
            return APIResponse.error(101,"기존 패스워드 불일치",400);
        }
        return APIResponse.success();
    }


}
