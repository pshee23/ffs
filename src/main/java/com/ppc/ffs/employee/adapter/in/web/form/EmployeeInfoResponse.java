package com.ppc.ffs.employee.adapter.in.web.form;

import lombok.Builder;
import lombok.Getter;

@Builder @Getter
public class EmployeeInfoResponse {

    private Long employeeId;
    private String branchName;
    private String employeeName;
    private String responsibility;
    private String address;
    private String phoneNumber;
    private String status;
    private String loginId;

}
