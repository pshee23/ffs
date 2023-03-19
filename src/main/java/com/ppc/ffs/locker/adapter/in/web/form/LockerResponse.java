package com.ppc.ffs.locker.adapter.in.web.form;

import com.ppc.ffs.locker.domain.LockerInfo;
import lombok.Data;

import java.util.List;

@Data
public class LockerResponse {

    private int code;
    private String message;
    private List<LockerInfo> lockerInfoList;
    private LockerInfo lockerInfo;
}
