package com.ppc.ffs.employee.adapter.in.web.controller;

import com.ppc.ffs.employee.adapter.in.web.form.RegisterEmployeeRequest;
import com.ppc.ffs.employee.application.port.in.RegisterEmployeeUseCase;
import com.ppc.ffs.employee.domain.RegisterEmployeeInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class RegisterEmployeeController {

    private final RegisterEmployeeUseCase registerEmployeeUseCase;

    @PostMapping("/employee")
    public ResponseEntity<Object> registerEmployee(@RequestBody RegisterEmployeeRequest registerEmployeeRequest) {
        RegisterEmployeeInfo registerEmployeeInfo = mapRequestToRegisterEmployeeInfo(registerEmployeeRequest);
        Long employeeId = registerEmployeeUseCase.registerEmployee(registerEmployeeInfo);

        return  ResponseEntity.ok(employeeId);
    }

    private RegisterEmployeeInfo mapRequestToRegisterEmployeeInfo(RegisterEmployeeRequest request) {
        return RegisterEmployeeInfo
                .builder()
                .branchId(request.getBranchId())
                .name(request.getEmployeeName())
                .responsibility(request.getResponsibility())
                .address(request.getAddress())
                .status(request.getStatus())
                .loginId(request.getLoginId())
                .password(request.getPassword())
                .build();
    }
}
