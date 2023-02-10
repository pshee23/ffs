package com.ppc.ffs.employee.adapter.out.persistence.repository;

import com.ppc.ffs.employee.adapter.out.persistence.entity.Employee;
import com.ppc.ffs.employee.application.port.out.InsertEmployeePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeePersistenceAdapter implements
        InsertEmployeePort {
    private final EmployeeRepository employeeRepository;


    @Override
    public Employee insertEmployee(Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }
}
