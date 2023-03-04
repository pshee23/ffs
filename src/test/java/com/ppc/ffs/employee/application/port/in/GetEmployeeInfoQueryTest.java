package com.ppc.ffs.employee.application.port.in;

import com.ppc.ffs.branch.adapter.out.persistence.entity.Branch;
import com.ppc.ffs.branch.adapter.out.persistence.repository.BranchRepository;
import com.ppc.ffs.employee.adapter.out.persistence.entity.Employee;
import com.ppc.ffs.employee.adapter.out.persistence.repository.EmployeePersistenceAdapter;
import com.ppc.ffs.employee.adapter.out.persistence.repository.EmployeeRepository;
import com.ppc.ffs.employee.domain.EmployeeInfo;
import com.ppc.ffs.employee.domain.RegisterEmployeeInfo;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GetEmployeeInfoQueryTest {

    @Autowired
    private GetEmployeeInfoQuery getEmployeeInfoQuery;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BranchRepository branchRepository;

    private Long employeeId;

    @BeforeAll
    public void insertEmployee() {
        Branch registerBranch = getBranch("피트니스짐 마포점", "서울시 마포구", "02-1111-0000");
        Branch branch = branchRepository.save(registerBranch);

        String responsibility = Employee.Responsibility.TRAINER.getText();
        String status = Employee.Status.DURING_OFFICE.getText();
        Employee employee =
                getEmployee("박준현", branch, responsibility, "010-0000-0000",
                        status, "서울시 마포구","qkrtpgml", "h2");

        Employee newEmployee = employeeRepository.save(employee);
        employeeId = newEmployee.getEmployeeId();
    }

    @DisplayName("직원 ID로 직원 정보를 가져온다.")
    @Test
    void getEmployeeInfoById() {
        EmployeeInfo employeeInfo = getEmployeeInfoQuery.getEmployeeInfo(employeeId);
        assertEquals(employeeInfo.getEmployeeName(), "박준현");
    }

    @DisplayName("직원 ID에 해당하는 직원이 없을 시 예외가 발생해야 한다.")
    @Test
    void Should_ThrowException_When_NotExistEmployeeId() {
        assertThrows(EntityNotFoundException.class, () -> {
            getEmployeeInfoQuery.getEmployeeInfo(2L);
        }, "예외가 발생하지 않았습니다.");
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