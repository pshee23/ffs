package com.ppc.ffs.member.application.port.in;

import com.ppc.ffs.member.adapter.in.web.form.MemberRequest;
import com.ppc.ffs.member.adapter.in.web.form.MemberResponse;

import java.util.List;

public interface MemberUseCase {

    public void addMember(MemberRequest memberRequest);

    List<MemberResponse> selectMemberList(MemberRequest memberRequest);
}
