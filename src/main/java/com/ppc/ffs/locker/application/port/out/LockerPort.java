package com.ppc.ffs.locker.application.port.out;

import com.ppc.ffs.locker.domain.LockerInfo;

import java.util.List;

public interface LockerPort {
    LockerInfo findById(Long lockerId);

    Long saveLocker(LockerInfo lockerInfo);

    List<LockerInfo> findAllLocker();

    LockerInfo findByMemberId(Long memberId);

    void deleteById(Long lockerId);
}
