package com.ppc.ffs.employee.adapter.in.web.form;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class EmployeeInfo {
    private Long employeeId;
    private String branchName;
    private String employeeName;
    private String responsibility;
    private String address;
    private String phoneNumber;
    private String status;
    private String loginId;
}
