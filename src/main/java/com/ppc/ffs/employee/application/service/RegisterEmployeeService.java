package com.ppc.ffs.employee.application.service;

import com.ppc.ffs.employee.adapter.in.web.form.RegisterEmployeeRequest;
import com.ppc.ffs.employee.adapter.out.persistence.entity.Employee;
import com.ppc.ffs.employee.application.port.in.RegisterEmployeeUseCase;
import com.ppc.ffs.employee.application.port.out.InsertEmployeePort;
import com.ppc.ffs.employee.application.port.out.UpdateEmployeePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterEmployeeService implements RegisterEmployeeUseCase {

    private final InsertEmployeePort insertEmployeePort;
    private final UpdateEmployeePort updateEmployeePort;

    @Override
    public boolean registerEmployee(RegisterEmployeeRequest registerEmployeeInfo) {
        Employee registerEmployee = mapToRegisterEmployee(registerEmployeeInfo);
        Employee employee = insertEmployeePort.insertEmployee(registerEmployee);

        return employee.getEmployeeId() == null;
    }

    @Override
    public boolean updateEmployee(Long employeeId, RegisterEmployeeRequest registerEmployeeRequest) {
        Employee updateEmployee = mapToRegisterEmployee(registerEmployeeRequest);
        updateEmployee.setEmployeeId(employeeId);
        Employee employee = updateEmployeePort.updateEmployee(updateEmployee);

        return employee.getEmployeeId() == null;
    }

    private Employee mapToRegisterEmployee(RegisterEmployeeRequest request) {
        Employee employee = new Employee();
        employee.setName(request.getEmployeeName());
        employee.setResponsibility(request.getResponsibility());
        employee.setAddress(request.getAddress());
        employee.setPhoneNumber(request.getPhoneNumber());
        employee.setStatus(request.getStatus());
        employee.setLoginId(request.getLoginId());
        employee.setPassword(request.getPassword());
        employee.setPasswordType("SHA-25");
        employee.setPasswordSalt("hi");
       return employee;
    }

}
