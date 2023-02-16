package com.ppc.ffs.employee.adapter.out.persistence.repository;

import com.ppc.ffs.employee.adapter.out.persistence.entity.Employee;
import com.ppc.ffs.employee.application.port.out.InsertEmployeePort;
import com.ppc.ffs.employee.application.port.out.SelectEmployeePort;
import com.ppc.ffs.employee.application.port.out.UpdateEmployeePort;
import com.ppc.ffs.employee.domain.EmployeeInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EmployeePersistenceAdapter implements
        InsertEmployeePort, UpdateEmployeePort,
        SelectEmployeePort {

    private final EmployeeRepository employeeRepository;
    private final EmployeeInfoMapper employeeInfoMapper;

    @Override
    public EmployeeInfo selectEmployeeInfo(Long employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        Employee employee = employeeOptional.orElseThrow(EntityNotFoundException::new);

        return employeeInfoMapper.mapToDomainEntity(employee);
    }

    @Override
    public Employee insertEmployee(Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    @Override
    public Employee updateEmployee(Employee updateEmployee) {
        Long id = updateEmployee.getEmployeeId();
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        Employee employee = employeeOptional.orElseThrow(EntityNotFoundException::new);
        employee.setResponsibility(updateEmployee.getResponsibility());
        employee.setAddress(updateEmployee.getAddress());
        employee.setPhoneNumber(updateEmployee.getPhoneNumber());
        employee.setStatus(updateEmployee.getStatus());
        employee.setPassword(updateEmployee.getPassword());

        return employeeRepository.save(employee);
    }
}

