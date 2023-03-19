package com.ppc.ffs.locker.adapter.out.persistence.repository;

import com.ppc.ffs.locker.adapter.out.persistence.entity.Locker;
import com.ppc.ffs.locker.domain.LockerInfo;

import java.util.ArrayList;
import java.util.List;

public class LockerInfoMapper {

    public LockerInfo mapLockerToLockerInfo(Locker locker){
        LockerInfo lockerInfo = LockerInfo.builder()
                .lockerId(locker.getLockerId())
                .memberId(locker.getMember().getMemberId())
                .startDate(locker.getStartDate())
                .endDate(locker.getEndDate())
                .build();
        return lockerInfo;
    }

    public List<LockerInfo> mapLockerListToLockerInfoList(List<Locker> lockerList) {
        List<LockerInfo> lockerInfoList = new ArrayList<>();

        if(lockerList == null){
            return lockerInfoList;
        }

        for(Locker locker: lockerList){
            LockerInfo lockerInfo = mapLockerToLockerInfo(locker);
            lockerInfoList.add(lockerInfo);
        }

        return lockerInfoList;
    }
}
