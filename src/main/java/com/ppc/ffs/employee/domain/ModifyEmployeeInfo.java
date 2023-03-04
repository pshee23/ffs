package com.ppc.ffs.employee.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ModifyEmployeeInfo {
    private Long employeeId;
    private Long branchId;
    private String responsibility;
    private String address;
    private String phoneNumber;
    private String status;
}
