package com.ppc.ffs.member.adapter.in.web.controller;

import com.ppc.ffs.member.adapter.in.web.form.MemberRequest;
import com.ppc.ffs.member.adapter.in.web.form.MemberResponse;
import com.ppc.ffs.member.adapter.in.web.form.MemberSearchForm;
import com.ppc.ffs.member.application.port.in.MemberUseCase;
import com.ppc.ffs.util.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller("/member/")
@RequiredArgsConstructor
public class MemberController {

    private final MemberUseCase memberUseCase;

    @PostMapping("add")
    public ResponseEntity<Object> addMember(@RequestBody MemberRequest memberRequest) throws Exception{

        //TODO 데이터 Validation 처리 필요

        memberUseCase.addMember(memberRequest);

        return APIResponse.success();
    }

    @GetMapping("list")
    public ResponseEntity<Object> searchMember(@RequestParam MemberSearchForm form,
                                               @PageableDefault(size = 15, sort = "regDate", direction = Sort.Direction.DESC) Pageable pageable) {

        List<MemberResponse> memberList = memberUseCase.searchMemberList(form,pageable);

        return APIResponse.success(memberList);
    }

    @PostMapping("edit")
    public ResponseEntity<Object> editMember(@RequestBody MemberRequest memberRequest) {

        memberUseCase.updateMember(memberRequest);

        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
