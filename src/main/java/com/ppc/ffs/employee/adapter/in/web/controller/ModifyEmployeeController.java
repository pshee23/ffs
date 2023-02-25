package com.ppc.ffs.employee.adapter.in.web.controller;

import com.ppc.ffs.employee.adapter.in.web.form.ModifyEmployeeRequest;
import com.ppc.ffs.employee.application.port.in.ModifyEmployeeUseCase;
import com.ppc.ffs.employee.domain.ModifyEmployeeInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class ModifyEmployeeController {

    private final ModifyEmployeeUseCase modifyEmployeeUsecase;

    @PutMapping("/employee/{employeeId}")
    public ResponseEntity<Object> modifyEmployee
            (@PathVariable Long employeeId, @RequestBody ModifyEmployeeRequest modifyEmployeeRequest) {
        ModifyEmployeeInfo modifyEmployeeInfo = mapRequestToModifyEmployeeInfo(employeeId, modifyEmployeeRequest);

        modifyEmployeeUsecase.modifyEmployeeInfo(modifyEmployeeInfo);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private ModifyEmployeeInfo mapRequestToModifyEmployeeInfo(Long employeeId, ModifyEmployeeRequest request) {
        return ModifyEmployeeInfo
                .builder()
                .employeeId(employeeId)
                .branchId(request.getBranchId())
                .responsibility(request.getResponsibility())
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .status(request.getStatus())
                .build();
    }

}
