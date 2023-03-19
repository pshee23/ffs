package com.ppc.ffs.employee.application.port.in;

import com.ppc.ffs.branch.adapter.out.persistence.entity.Branch;
import com.ppc.ffs.branch.adapter.out.persistence.repository.BranchRepository;
import com.ppc.ffs.employee.adapter.out.persistence.entity.Employee;
import com.ppc.ffs.employee.domain.RegisterEmployeeInfo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RegisterEmployeeUseCaseTest {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private RegisterEmployeeUseCase registerEmployeeUseCase;

    private Long branchId;

    @BeforeAll
    public void registerBranch() {
        Branch branch = getBranch("피트니스짐 거여점", "서울시 송파구", "02-0000-0000");
        Branch branchResult = branchRepository.save(branch);
        branchId = branchResult.getBranchId();
    }

    @DisplayName("직원정보가 정상적으로 등록되어야 한다.")
    @Test
    void registerEmployee() {
        String responsibility = Employee.Responsibility.CEO.getText();
        String status = Employee.Status.DURING_OFFICE.getText();
        RegisterEmployeeInfo registerEmployeeInfo =
                getRegisterEmployee("최이화", branchId, responsibility, status, "chldlghk", "h2");

        Long employeeId = registerEmployeeUseCase.registerEmployee(registerEmployeeInfo);
        assertEquals(employeeId, 1);
    }

    @DisplayName("직원정보 등록 중 해당 지점 정보가 없으므로 예외가 발생해야 한다.")
    @Test
    void Should_ThrowException_When_NotExistBranchInfo() {
        String responsibility = Employee.Responsibility.CEO.getText();
        String status = Employee.Status.DURING_OFFICE.getText();
        RegisterEmployeeInfo registerEmployeeInfo =
                getRegisterEmployee("박세희", 2L, responsibility, status, "qkrtpgml", "h2");

        assertThrows(EntityNotFoundException.class, () -> {
            registerEmployeeUseCase.registerEmployee(registerEmployeeInfo);
        }, "예외가 발생하지 않았습니다.");
    }

    private RegisterEmployeeInfo getRegisterEmployee
            (String name, Long branchId, String responsibility, String status, String loginId, String password) {

        return RegisterEmployeeInfo
                .builder()
                .branchId(branchId)
                .name(name)
                .responsibility(responsibility)
                .address("서울시 00동")
                .status(status)
                .loginId(loginId)
                .password(password)
                .build();
    }

    private Branch getBranch(String name, String address, String phoneNumber) {
        Branch branch = new Branch();
        branch.setName(name);
        branch.setAddress(address);
        branch.setPhoneNumber(phoneNumber);

        return branch;
    }
}