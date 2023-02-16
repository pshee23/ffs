package com.ppc.ffs.employee.adapter.in.web.form;

import lombok.*;

@Builder @Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterEmployeeRequest {

    private String branchName;
    private String employeeName;
    private String responsibility;
    private String address;
    private String phoneNumber;
    private String status;
    private String loginId;
    private String password;

}
