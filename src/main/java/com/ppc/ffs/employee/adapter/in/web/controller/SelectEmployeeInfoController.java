package com.ppc.ffs.employee.adapter.in.web.controller;

import com.ppc.ffs.employee.adapter.in.web.form.EmployeeInfoResponse;
import com.ppc.ffs.employee.application.port.in.GetEmployeeInfoQuery;
import com.ppc.ffs.employee.domain.EmployeeInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
@RequiredArgsConstructor
public class SelectEmployeeInfoController {

    private final GetEmployeeInfoQuery getEmployeeInfoQuery;

    @GetMapping("/employee/info/{employeeId}")
    public ResponseEntity<EmployeeInfoResponse> getEmployeeInfo(@PathVariable Long employeeId) {
        EmployeeInfo employeeInfo = getEmployeeInfoQuery.getEmployeeInfo(employeeId);
        EmployeeInfoResponse employeeInfoResponse = mapToEmployeeInfoResponse(employeeInfo);

        log.info("Response to select employee info. {}", employeeInfoResponse);
        return ResponseEntity.status(employeeInfoResponse.getResultCode().getStatus()).body(employeeInfoResponse);
    }

    private EmployeeInfoResponse mapToEmployeeInfoResponse(EmployeeInfo employeeInfo) {
        return EmployeeInfoResponse
                .builder()
                .employeeId(employeeInfo.getEmployeeId())
                .branchName(employeeInfo.getBranchName())
                .employeeName(employeeInfo.getEmployeeName())
                .responsibility(employeeInfo.getResponsibility())
                .address(employeeInfo.getAddress())
                .phoneNumber(employeeInfo.getPhoneNumber())
                .status(employeeInfo.getStatus())
                .loginId(employeeInfo.getLoginId())
                .build();
    }
}
