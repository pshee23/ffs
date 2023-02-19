package com.ppc.ffs.member.application.port.in;

import com.ppc.ffs.member.adapter.in.web.form.MemberRequest;
import com.ppc.ffs.member.adapter.in.web.form.MemberResponse;
import com.ppc.ffs.member.adapter.in.web.form.MemberSearchForm;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberUseCase {

    public void addMember(MemberRequest memberRequest) throws Exception;

    List<MemberResponse> selectMemberList(MemberRequest memberRequest);

    List<MemberResponse> searchMemberList(MemberSearchForm form, Pageable pageable);

    void updateMember(MemberRequest memberRequest);
}
