package com.ppc.ffs.locker.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class LockerInfo {

    private Long lockerId;

    private Long memberId;

    private Date startDate;

    private Date endDate;

    @Builder
    public LockerInfo (Long lockerId, Long memberId, Date startDate, Date endDate){
        this.lockerId = lockerId;
        this.memberId = memberId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
