package com.ppc.ffs.locker.adapter.in.web.form;

import com.ppc.ffs.locker.domain.LockerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LockerRequest {

    private Long lockerId;

    private Long memberId;

    private Date startDate;

    private Date endDate;

    public LockerInfo of(){
        return LockerInfo.builder()
                .lockerId(lockerId)
                .memberId(memberId)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
}
