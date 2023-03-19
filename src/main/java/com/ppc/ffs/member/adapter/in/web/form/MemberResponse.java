package com.ppc.ffs.member.adapter.in.web.form;

import com.ppc.ffs.member.domain.MemberInfo;
import lombok.Data;
import java.util.List;

@Data
public class MemberResponse {

    private int code;
    private String message;
    private List<MemberInfo> memberInfoList;
    private MemberInfo memberInfo;
}
