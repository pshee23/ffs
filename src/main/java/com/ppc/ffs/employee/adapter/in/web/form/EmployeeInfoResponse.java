package com.ppc.ffs.employee.adapter.in.web.form;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ppc.ffs.common.AbstractResponse;
import lombok.Builder;
import lombok.Getter;

@Builder @Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeInfoResponse extends AbstractResponse {

    private Long employeeId;
    private String branchName;
    private String employeeName;
    private String responsibility;
    private String address;
    private String phoneNumber;
    private String status;
    private String loginId;

}
