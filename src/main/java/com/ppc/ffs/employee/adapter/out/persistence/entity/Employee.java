package com.ppc.ffs.employee.adapter.out.persistence.entity;

import com.ppc.ffs.branch.adapter.out.persistence.entity.Branch;
import com.ppc.ffs.lesson.adapter.out.persistence.entity.Lesson;
import com.ppc.ffs.member.adapter.out.persistence.entity.Member;
import com.ppc.ffs.purchase.adapter.out.persistence.entity.PurchaseHistory;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @Column(name = "EMPLOYEE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @ManyToOne
    @JoinColumn(name = "BRANCH_ID")
    private Branch branch;

    @Column(name = "NAME")
    private String name;

    @Column(name = "RESPONSIBILITY")
    private String Responsibility;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "LOGIN_ID")
    private String loginId;

    @Column(name = "LOGIN_PASSWORD")
    private String password;

    @OneToMany(mappedBy = "employee")
    private List<Member> memberList = new ArrayList<>();

    @OneToMany(mappedBy = "employee")
    private List<PurchaseHistory> purchaseHistoryList = new ArrayList<>();

    @OneToMany(mappedBy = "employee")
    private List<Lesson> lessonList = new ArrayList<>();

    public void setBranch(Branch branch) {
        this.branch = branch;

        if(!branch.getEmployeeList().contains(this)) {
            branch.addEmployee(this);
        }
    }

    public void addMember(Member member) {
        this.memberList.add(member);

        if(!member.getEmployee().equals(this)) {
            member.setEmployee(this);
        }
    }

    public void addPurchaseHistory(PurchaseHistory purchaseHistory) {
        this.purchaseHistoryList.add(purchaseHistory);

        if(!purchaseHistory.getEmployee().equals(this)) {
            purchaseHistory.setEmployee(this);
        }
    }

    public void addLesson(Lesson lesson) {
        this.lessonList.add(lesson);

        if(lesson.getEmployee() == null || !lesson.getEmployee().equals(this)) {
            lesson.setEmployee(this);
        }
    }
}
