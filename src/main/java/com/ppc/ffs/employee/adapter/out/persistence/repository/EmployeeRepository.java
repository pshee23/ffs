package com.ppc.ffs.employee.adapter.out.persistence.repository;

import com.ppc.ffs.employee.adapter.out.persistence.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
