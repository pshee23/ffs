package com.ppc.ffs.employee.application.service;

import com.ppc.ffs.employee.adapter.out.persistence.entity.Employee;
import com.ppc.ffs.employee.application.port.in.RegisterEmployeeUseCase;
import com.ppc.ffs.employee.application.port.out.InsertEmployeePort;
import com.ppc.ffs.employee.application.port.out.UpdateEmployeePort;
import com.ppc.ffs.employee.domain.RegisterEmployeeInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterEmployeeService implements RegisterEmployeeUseCase {

    private final InsertEmployeePort insertEmployeePort;
    private final UpdateEmployeePort updateEmployeePort;

    @Override
    public boolean registerEmployee(RegisterEmployeeInfo registerEmployeeInfo) {
        Employee employee = insertEmployeePort.insertEmployee(registerEmployeeInfo);

        return employee.getEmployeeId() == null;
    }

    @Override
    public boolean updateEmployee(Long employeeId, RegisterEmployeeInfo registerEmployeeInfo) {
        Employee employee = updateEmployeePort.updateEmployee(employeeId, registerEmployeeInfo);

        return employee.getEmployeeId() == null;
    }

}
