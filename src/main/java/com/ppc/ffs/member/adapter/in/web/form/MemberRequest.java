package com.ppc.ffs.member.adapter.in.web.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequest {

    private Long memberId;
    private String name;

    private String status;

    private String loginId;

    private String loginPassword;

    /** 회원 추가 시 필요한 지점정보와 직원 정보의 키값은 화면으로부터 받아온다.*/
    private Long branchId;

    private Long employeeId;

}
