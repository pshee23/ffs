package com.ppc.ffs.employee.application.port.in;

import com.ppc.ffs.branch.adapter.out.persistence.entity.Branch;
import com.ppc.ffs.branch.adapter.out.persistence.repository.BranchRepository;
import com.ppc.ffs.employee.adapter.out.persistence.entity.Employee;
import com.ppc.ffs.employee.adapter.out.persistence.repository.EmployeeRepository;
import com.ppc.ffs.employee.domain.ModifyEmployeeInfo;
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
class ModifyEmployeeUseCaseTest {

    @Autowired
    private ModifyEmployeeUseCase modifyEmployeeUseCase;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BranchRepository branchRepository;

    Long employeeId;

    @BeforeAll
    public void insertEmployee() {
        Branch registerBranch = getBranch("피트니스짐 문정점", "서울시 문정점", "02-1111-0000");
        Branch branch = branchRepository.save(registerBranch);

        String responsibility = Employee.Responsibility.TRAINER.getText();
        String status = Employee.Status.DURING_OFFICE.getText();
        Employee employee =
                getEmployee("최이화", branch, responsibility, "010-0000-0000",
                        status, "서울시 송파구","qkrtpgml", "h2");

        Employee newEmployee = employeeRepository.save(employee);
        employeeId = newEmployee.getEmployeeId();
    }

    @DisplayName("직원정보가 수정되어야 한다.")
    @Test
    void modifyEmployeeInfoTest() {
        String responsibility = Employee.Responsibility.MANAGER.getText();
        String status = Employee.Status.LEAVE_OF_ABSENCE.getText();
        ModifyEmployeeInfo modifyEmployeeInfo = getModifyEmployeeInfo(employeeId, 1L, responsibility,
                "서울시 송파구", "010-0000-0000", status);

        Long result = modifyEmployeeUseCase.modifyEmployeeInfo(modifyEmployeeInfo);
        assertEquals(result, employeeId);
    }

    @DisplayName("해당 직원이 존재하지 않으므로 예외가 발생해야 한다.")
    @Test
    void Should_ThrowException_When_NotExistEmployeeInfo() {
        assertThrows(EntityNotFoundException.class, () -> {
            String responsibility = Employee.Responsibility.MANAGER.getText();
            String status = Employee.Status.LEAVE_OF_ABSENCE.getText();
            ModifyEmployeeInfo modifyEmployeeInfo = getModifyEmployeeInfo(0L, 1L, responsibility,
                    "서울시 송파구", "010-0000-0000", status);

            Long result = modifyEmployeeUseCase.modifyEmployeeInfo(modifyEmployeeInfo);
            assertEquals(result, employeeId);
        }, "예외가 발생하지 않았습니다.");
    }


    private ModifyEmployeeInfo getModifyEmployeeInfo(Long employeeId, Long branchId, String responsibility,
                                                     String address, String phoneNumber, String status) {
        return ModifyEmployeeInfo
                .builder()
                .employeeId(employeeId)
                .branchId(branchId)
                .responsibility(responsibility)
                .address(address)
                .phoneNumber(phoneNumber)
                .status(status)
                .build();
    }

    private Employee getEmployee(String name, Branch branch, String responsibility,String phoneNumber,
                                 String status, String address, String loginId, String password) {
        Employee employee = new Employee();
        employee.setBranch(branch);
        employee.setName(name);
        employee.setResponsibility(responsibility);
        employee.setAddress(address);
        employee.setPhoneNumber(phoneNumber);
        employee.setStatus(status);
        employee.setLoginId(loginId);
        employee.setPassword(password);

        return employee;
    }

    private Branch getBranch(String name, String address, String phoneNumber) {
        Branch branch = new Branch();
        branch.setName(name);
        branch.setAddress(address);
        branch.setPhoneNumber(phoneNumber);

        return branch;
    }

}