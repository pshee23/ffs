package com.ppc.ffs.employee.application.port.out;

import com.ppc.ffs.employee.domain.ModifyEmployeeInfo;

public interface UpdateEmployeePort {

    void updateEmployee(ModifyEmployeeInfo modifyEmployeeInfo);
}
