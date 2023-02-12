package com.ppc.ffs.employee.application.service;

import com.ppc.ffs.employee.application.port.in.GetEmployeeInfoQuery;
import com.ppc.ffs.employee.application.port.out.SelectEmployeePort;
import com.ppc.ffs.employee.domain.EmployeeInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetEmployeeInfoService implements GetEmployeeInfoQuery {

    private final SelectEmployeePort selectEmployeePort;

    @Override
    public EmployeeInfo getEmployeeInfo(Long employeeId) {
        return selectEmployeePort.selectEmployeeInfo(employeeId);
    }
}
