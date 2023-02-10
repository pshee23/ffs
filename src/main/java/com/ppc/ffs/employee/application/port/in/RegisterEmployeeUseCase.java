package com.ppc.ffs.employee.application.port.in;

import com.ppc.ffs.employee.adapter.in.web.form.RegisterEmployeeRequest;

public interface RegisterEmployeeUseCase {

    boolean registerEmployee(RegisterEmployeeRequest registerEmployeeInfo);
}
