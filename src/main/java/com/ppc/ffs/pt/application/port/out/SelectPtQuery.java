package com.ppc.ffs.pt.application.port.out;

import com.ppc.ffs.pt.adapter.out.persistence.entity.Pt;

public interface SelectPtQuery {

    Pt selectAblePtByMemberIdOrderByRegisterDate(Long memberId);
}
