package com.ppc.ffs.employee.adapter.out.persistence.repository;

import com.ppc.ffs.branch.adapter.out.persistence.entity.Branch;
import com.ppc.ffs.branch.adapter.out.persistence.repository.BranchRepository;
import com.ppc.ffs.employee.adapter.out.persistence.entity.Employee;
import com.ppc.ffs.employee.application.port.out.InsertEmployeePort;
import com.ppc.ffs.employee.application.port.out.SelectEmployeePort;
import com.ppc.ffs.employee.application.port.out.UpdateEmployeePort;
import com.ppc.ffs.employee.domain.EmployeeInfo;
import com.ppc.ffs.employee.domain.RegisterEmployeeInfo;
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
    private final BranchRepository branchRepository;

    @Override
    public EmployeeInfo selectEmployeeInfo(Long employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        Employee employee = employeeOptional.orElseThrow(EntityNotFoundException::new);

        return employeeInfoMapper.mapToDomainEntity(employee);
    }

    @Override
    public Employee insertEmployee(RegisterEmployeeInfo registerEmployeeInfo) {
        Long branchId = registerEmployeeInfo.getBranchId();
        Branch branch = branchRepository.findById(branchId).orElseThrow(EntityNotFoundException::new);

        Employee employee = employeeInfoMapper.mapToEmployee(registerEmployeeInfo, branch);

        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long employeeId, RegisterEmployeeInfo registerEmployeeInfo) {
        Long branchId = registerEmployeeInfo.getBranchId();
        Branch branch = branchRepository.findById(branchId).orElseThrow(EntityNotFoundException::new);

        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        Employee employee = employeeOptional.orElseThrow(EntityNotFoundException::new);

        employee.setBranch(branch);
        employee.setResponsibility(registerEmployeeInfo.getResponsibility());
        employee.setAddress(registerEmployeeInfo.getAddress());
        employee.setPhoneNumber(registerEmployeeInfo.getPhoneNumber());
        employee.setStatus(registerEmployeeInfo.getStatus());
        employee.setPassword(registerEmployeeInfo.getPassword());

        return employeeRepository.save(employee);
    }
}

