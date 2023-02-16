package com.ppc.ffs.employee.adapter.in.web.controller;

import com.ppc.ffs.employee.adapter.in.web.form.RegisterEmployeeRequest;
import com.ppc.ffs.employee.application.port.in.RegisterEmployeeUseCase;
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

        boolean isSuccess = registerEmployeeUseCase.registerEmployee(registerEmployeeRequest);

        return  isSuccess ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
    }

    @PutMapping("/employee/{employeeId}")
    public ResponseEntity<Object> updateEmployee(
            @PathVariable Long employeeId, @RequestBody RegisterEmployeeRequest registerEmployeeRequest) {

        boolean isSuccess = registerEmployeeUseCase.updateEmployee(employeeId, registerEmployeeRequest);

        return  isSuccess ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
    }
}
