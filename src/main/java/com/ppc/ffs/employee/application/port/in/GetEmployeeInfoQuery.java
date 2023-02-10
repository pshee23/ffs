package com.ppc.ffs.employee.application.port.in;

import com.ppc.ffs.employee.domain.EmployeeInfo;

public interface GetEmployeeInfoQuery {

    EmployeeInfo getEmployeeInfo(Long employeeId);
}
