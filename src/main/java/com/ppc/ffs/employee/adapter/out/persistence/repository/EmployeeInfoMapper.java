package com.ppc.ffs.employee.adapter.out.persistence.repository;

import com.ppc.ffs.branch.adapter.out.persistence.entity.Branch;
import com.ppc.ffs.employee.adapter.out.persistence.entity.Employee;
import com.ppc.ffs.employee.domain.EmployeeInfo;
import org.springframework.stereotype.Component;

@Component
public class EmployeeInfoMapper {

    EmployeeInfo mapToDomainEntity(Employee employee) {
        String branch = employee.getBranch() == null ? null : employee.getBranch().getName();

        return EmployeeInfo.builder()
                .employeeId(employee.getEmployeeId())
                .branchName(branch)
                .employeeName(employee.getName())
                .responsibility(employee.getResponsibility())
                .address(employee.getAddress())
                .phoneNumber(employee.getPhoneNumber())
                .status(employee.getStatus())
                .loginId(employee.getLoginId())
                .loginPassword(employee.getPassword())
                .passwordType(employee.getPasswordType())
                .passwordSalt(employee.getPasswordSalt())
                .build();
    }
}
