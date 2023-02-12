package com.ppc.ffs.member.adapter.in.web.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequest {

    //TODO Branch랑 Employee는 어떻게?

    private String name;

    private String status;

    private String loginId;

    private String loginPassword;

    private String passwordType;

    private String passwordSalt;


}
