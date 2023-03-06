package com.ppc.ffs.employee.adapter.in.web.form;

import lombok.*;

@Getter
@AllArgsConstructor
public class RegisterEmployeeRequest {

    private Long branchId;
    private String employeeName;
    private String responsibility;
    private String address;
    private String status;
    private String phoneNumber;
    private String loginId;
    private String password;

}
