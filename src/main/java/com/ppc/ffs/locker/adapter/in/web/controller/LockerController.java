package com.ppc.ffs.locker.adapter.in.web.controller;

import com.ppc.ffs.locker.adapter.in.web.form.LockerRequest;
import com.ppc.ffs.locker.adapter.in.web.form.LockerResponse;
import com.ppc.ffs.locker.application.port.in.LockerUseCase;
import com.ppc.ffs.locker.domain.LockerInfo;
import com.ppc.ffs.member.domain.MemberInfo;
import com.ppc.ffs.util.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/locker")
public class LockerController {

    private final LockerUseCase lockerUseCase;

    @PostMapping("add")
    public ResponseEntity<Object> addLocker(@RequestBody LockerRequest lockerRequest) throws Exception{

        LockerInfo lockerInfo = lockerRequest.of();
        lockerUseCase.addLocker(lockerInfo);
        return APIResponse.success();
    }

    @GetMapping("list")
    public ResponseEntity<Object> lockerList() {
        LockerResponse lockerResponse = lockerUseCase.getLockerList();

        return APIResponse.success(lockerResponse);
    }

    @GetMapping("view/{memberId}")
    public ResponseEntity<Object> searchLocker(@PathVariable("memberId") Long memberId) {
        LockerResponse lockerResponse = lockerUseCase.getLocker(memberId);

        return APIResponse.success(lockerResponse);
    }

    @PostMapping("edit")
    public ResponseEntity<Object> editLocker(@RequestBody LockerRequest lockerRequest) throws Exception {
        LockerInfo lockerInfo = lockerRequest.of();
        lockerUseCase.updateLocker(lockerInfo);

        return  APIResponse.success();
    }

    @PostMapping("delete")
    public ResponseEntity<Object> deleteLocker(@RequestBody LockerRequest lockerRequest) throws Exception {
        LockerInfo lockerInfo = lockerRequest.of();
        lockerUseCase.deleteLocker(lockerInfo);

        return  APIResponse.success();
    }
}
