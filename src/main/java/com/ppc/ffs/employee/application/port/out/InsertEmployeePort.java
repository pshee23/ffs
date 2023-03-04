package com.ppc.ffs.employee.application.port.out;

import com.ppc.ffs.employee.adapter.out.persistence.entity.Employee;
import com.ppc.ffs.employee.domain.RegisterEmployeeInfo;

public interface InsertEmployeePort {

    Employee insertEmployee(RegisterEmployeeInfo newEmployee);

}
