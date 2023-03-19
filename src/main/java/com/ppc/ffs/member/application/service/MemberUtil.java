package com.ppc.ffs.member.application.service;

import com.ppc.ffs.member.adapter.in.web.form.MemberResponse;
import com.ppc.ffs.member.adapter.out.persistence.entity.Member;
import com.ppc.ffs.member.domain.MemberInfo;

public class MemberUtil {

    private static MemberUtil memberUtil = null;
    public static MemberUtil getInstance(){
        if( memberUtil == null ){
            memberUtil = new MemberUtil();
        }
        return memberUtil;
    }

}
