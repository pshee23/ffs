package com.ppc.ffs.member.adapter.in.web.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberPasswordRequest {

    private Long memberId;

    private String loginId;

    private String originPassword;

    private String newPassword;

    private String newPasswordConfirm;

}
