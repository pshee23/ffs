package com.ppc.ffs.employee.application.port.out;

import com.ppc.ffs.employee.adapter.out.persistence.entity.Employee;

public interface UpdateEmployeePort {

    Employee updateEmployee(Employee updateEmployee);
}
