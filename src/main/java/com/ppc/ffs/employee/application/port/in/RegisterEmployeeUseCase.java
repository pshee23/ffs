package com.ppc.ffs.employee.application.port.in;

import com.ppc.ffs.employee.adapter.in.web.form.RegisterEmployeeRequest;
import com.ppc.ffs.employee.domain.RegisterEmployeeInfo;

public interface RegisterEmployeeUseCase {

    boolean registerEmployee(RegisterEmployeeInfo registerEmployeeInfo);

    boolean updateEmployee(Long employeeId, RegisterEmployeeInfo registerEmployeeRequest);
}
