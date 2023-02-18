package com.ppc.ffs.employee.adapter.in.web.controller;

import com.ppc.ffs.employee.adapter.in.web.form.RegisterEmployeeRequest;
import com.ppc.ffs.employee.application.port.in.RegisterEmployeeUseCase;
import com.ppc.ffs.employee.domain.RegisterEmployeeInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employee")
public class RegisterEmployeeController {

    private final RegisterEmployeeUseCase registerEmployeeUseCase;

    @PostMapping
    public ResponseEntity<Object> registerEmployee(@RequestBody RegisterEmployeeRequest registerEmployeeRequest) {
        RegisterEmployeeInfo registerEmployeeInfo = mapToRegisterEmployeeInfo(registerEmployeeRequest);
        boolean isSuccess = registerEmployeeUseCase.registerEmployee(registerEmployeeInfo);

        return  isSuccess ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Object> updateEmployee(
            @PathVariable Long employeeId, @RequestBody RegisterEmployeeRequest registerEmployeeRequest) {
        RegisterEmployeeInfo registerEmployeeInfo = mapToRegisterEmployeeInfo(registerEmployeeRequest);
        boolean isSuccess = registerEmployeeUseCase.updateEmployee(employeeId, registerEmployeeInfo);

        return  isSuccess ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
    }

    private RegisterEmployeeInfo mapToRegisterEmployeeInfo(RegisterEmployeeRequest request) {
        return RegisterEmployeeInfo
                .builder()
                .branchId(request.getBranchId())
                .employeeName(request.getEmployeeName())
                .responsibility(request.getResponsibility())
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .status(request.getStatus())
                .id(request.getLoginId())
                .password(request.getPassword())
                .build();
    }
}
