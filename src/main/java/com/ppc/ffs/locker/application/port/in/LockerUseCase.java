package com.ppc.ffs.locker.application.port.in;

import com.ppc.ffs.locker.adapter.in.web.form.LockerResponse;
import com.ppc.ffs.locker.domain.LockerInfo;

public interface LockerUseCase {
    void addLocker(LockerInfo lockerInfo) throws Exception;

    LockerResponse getLockerList();

    LockerResponse getLocker(Long memberId);

    void updateLocker(LockerInfo lockerInfo) throws Exception;

    void deleteLocker(LockerInfo lockerInfo);
}
