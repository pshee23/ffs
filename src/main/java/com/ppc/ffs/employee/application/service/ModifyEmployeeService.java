package com.ppc.ffs.employee.application.service;

import com.ppc.ffs.employee.application.port.in.ModifyEmployeeUseCase;
import com.ppc.ffs.employee.application.port.out.UpdateEmployeePort;
import com.ppc.ffs.employee.domain.ModifyEmployeeInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModifyEmployeeService implements ModifyEmployeeUseCase {

    private final UpdateEmployeePort updateEmployeePort;

    @Override
    public Long modifyEmployeeInfo(ModifyEmployeeInfo modifyEmployeeInfo) {
        return updateEmployeePort.updateEmployee(modifyEmployeeInfo);
    }
}
