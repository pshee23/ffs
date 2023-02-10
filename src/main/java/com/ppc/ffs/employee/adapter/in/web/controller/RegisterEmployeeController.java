package com.ppc.ffs.employee.adapter.in.web.controller;

import com.ppc.ffs.employee.adapter.in.web.form.RegisterEmployeeRequest;
import com.ppc.ffs.employee.application.port.in.RegisterEmployeeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

        boolean isSuccess = registerEmployeeUseCase.registerEmployee(registerEmployeeRequest);

        return  isSuccess ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
    }
}
