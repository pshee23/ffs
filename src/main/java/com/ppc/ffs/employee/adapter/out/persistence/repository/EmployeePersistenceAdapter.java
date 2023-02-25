package com.ppc.ffs.employee.adapter.out.persistence.repository;

import com.ppc.ffs.branch.adapter.out.persistence.entity.Branch;
import com.ppc.ffs.branch.adapter.out.persistence.repository.BranchRepository;
import com.ppc.ffs.employee.adapter.out.persistence.entity.Employee;
import com.ppc.ffs.employee.application.port.out.InsertEmployeePort;
import com.ppc.ffs.employee.application.port.out.SelectEmployeePort;
import com.ppc.ffs.employee.application.port.out.UpdateEmployeePort;
import com.ppc.ffs.employee.domain.EmployeeInfo;
import com.ppc.ffs.employee.domain.ModifyEmployeeInfo;
import com.ppc.ffs.employee.domain.RegisterEmployeeInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EmployeePersistenceAdapter implements
        InsertEmployeePort,
        SelectEmployeePort,
        UpdateEmployeePort {

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
        Optional<Branch> branchOptional = branchRepository.findById(branchId);
        Branch branch = branchOptional.orElseThrow(EntityNotFoundException::new);

        Employee employee = employeeInfoMapper.mapToEmployee(registerEmployeeInfo, branch);
        return employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(ModifyEmployeeInfo modifyEmployeeInfo) {
        Optional<Employee> employeeOptional = employeeRepository.findById(modifyEmployeeInfo.getEmployeeId());
        Employee employee = employeeOptional.orElseThrow(EntityNotFoundException::new);

        Long newBranchId = modifyEmployeeInfo.getBranchId();
        Optional<Branch> branchOptional = branchRepository.findById(newBranchId);
        Branch branch = branchOptional.orElseThrow(EntityNotFoundException::new);

        String phoneNumber = modifyEmployeeInfo.getPhoneNumber();
        String responsibility = modifyEmployeeInfo.getResponsibility();
        String address = modifyEmployeeInfo.getAddress();
        String status = modifyEmployeeInfo.getStatus();

        employee.updateEmployeeInfo(branch, responsibility, address, phoneNumber, status);
        employeeRepository.save(employee);
    }
}

