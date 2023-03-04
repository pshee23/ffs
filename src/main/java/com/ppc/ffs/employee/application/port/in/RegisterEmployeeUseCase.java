package com.ppc.ffs.employee.application.port.in;

import com.ppc.ffs.employee.domain.RegisterEmployeeInfo;

public interface RegisterEmployeeUseCase {

    Long registerEmployee(RegisterEmployeeInfo registerEmployeeInfo);
}
