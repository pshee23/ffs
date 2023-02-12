package com.ppc.ffs.employee.application.port.out;

import com.ppc.ffs.employee.domain.EmployeeInfo;

public interface SelectEmployeePort {

    EmployeeInfo selectEmployeeInfo(Long employeeId);
}
