package com.ppc.ffs.pay.adapter.out.persistence.entity;

import com.ppc.ffs.employee.adapter.out.persistence.entity.Employee;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class PayManagementPk implements Serializable {

    private static final long serialVersionUID = 6664442515449191989L;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @Column(name = "PAY_DATE")
    private LocalDate payDate;


}
