package com.ppc.ffs.employee.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RegisterEmployeeInfo {
    private Long branchId;
    private String employeeName;
    private String responsibility;
    private String address;
    private String phoneNumber;
    private String status;
    private String id;
    private String password;
}
