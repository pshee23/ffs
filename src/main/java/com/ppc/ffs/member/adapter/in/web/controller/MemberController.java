package com.ppc.ffs.member.adapter.in.web.controller;

import com.ppc.ffs.member.adapter.in.web.form.MemberRequest;
import com.ppc.ffs.member.adapter.in.web.form.MemberResponse;
import com.ppc.ffs.member.application.port.in.MemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberUseCase memberUseCase;

    @PostMapping("/member/add")
    public ResponseEntity<Object> addMember(@RequestBody MemberRequest memberRequest) {

        memberUseCase.addMember(memberRequest);

        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/member/list")
    public ResponseEntity<Object> SearchMember(@RequestParam MemberRequest memberRequest) {

        List<MemberResponse> memberList = memberUseCase.selectMemberList(memberRequest);

        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
