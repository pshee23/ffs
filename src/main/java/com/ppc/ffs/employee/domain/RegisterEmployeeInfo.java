package com.ppc.ffs.employee.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RegisterEmployeeInfo {
    private Long branchId;
    private String name;
    private String responsibility;
    private String address;
    private String phoneNumber;
    private String status;
    private String loginId;
    private String password;
}
