package com.ppc.ffs.employee.adapter.in.web.form;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ModifyEmployeeRequest {

    private Long branchId;
    private String responsibility;
    private String address;
    private String status;
    private String phoneNumber;

}
