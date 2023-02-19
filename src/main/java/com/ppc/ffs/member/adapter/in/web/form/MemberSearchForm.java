package com.ppc.ffs.member.adapter.in.web.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberSearchForm {

    private String name;

    private String loginId;
}
