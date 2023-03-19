package com.ppc.ffs.locker.application.service;

import com.ppc.ffs.locker.adapter.in.web.form.LockerResponse;
import com.ppc.ffs.locker.application.port.in.LockerUseCase;
import com.ppc.ffs.locker.application.port.out.LockerPort;
import com.ppc.ffs.locker.domain.LockerInfo;
import com.ppc.ffs.member.adapter.in.web.form.MemberResponse;
import com.ppc.ffs.member.domain.MemberInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LockerService implements LockerUseCase {

    private final LockerPort lockerPort;

    @Override
    public void addLocker(LockerInfo lockerInfo) throws Exception {
        LockerInfo existLockerInfo = lockerPort.findById(lockerInfo.getLockerId());

        if(existLockerInfo != null){
            //todo 이미 존재하는 아이디
            throw new Exception();
        }
        lockerPort.saveLocker(lockerInfo);
    }

    @Override
    public LockerResponse getLockerList() {
        List<LockerInfo> lockerList = lockerPort.findAllLocker();

        LockerResponse response = new LockerResponse();
        response.setCode(200);
        response.setMessage("success");
        response.setLockerInfoList(lockerList);
        return response;
    }

    @Override
    public LockerResponse getLocker(Long memberId) {
        LockerInfo lockerInfo = lockerPort.findByMemberId(memberId);
        LockerResponse response = new LockerResponse();
        response.setCode(200);
        response.setMessage("success");
        response.setLockerInfo(lockerInfo);
        return response;
    }

    @Override
    public void updateLocker(LockerInfo lockerInfo) throws Exception {
        LockerInfo existLockerInfo =  lockerPort.findById(lockerInfo.getMemberId());
        if(existLockerInfo == null){
            //user not found
            throw new Exception();
        }
        //TODO 객체변경 어떻게 해야하나요?

        lockerPort.saveLocker(lockerInfo);
    }

    @Override
    public void deleteLocker(LockerInfo lockerInfo) {
        lockerPort.deleteById(lockerInfo.getLockerId());
    }
}
