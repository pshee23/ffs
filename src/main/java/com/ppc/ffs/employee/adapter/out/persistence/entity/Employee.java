package com.ppc.ffs.employee.adapter.out.persistence.entity;

import com.ppc.ffs.branch.adapter.out.persistence.entity.Branch;
import com.ppc.ffs.lesson.adapter.out.persistence.entity.Lesson;
import com.ppc.ffs.member.adapter.out.persistence.entity.Member;
import com.ppc.ffs.purchase.adapter.out.persistence.entity.PurchaseHistory;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Getter
    @RequiredArgsConstructor
    public enum Responsibility {
        CEO("대표"),
        MANAGER("매니저"),
        TRAINER("트레이너");

        private final String text;
    }

    @Getter
    @RequiredArgsConstructor
    public enum Status {

        LEAVE_ABSENCE("휴직"),
        CURRENT_EMPLOYED("재직");

        private final String text;
    }

    @Id
    @Column(name = "EMPLOYEE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRANCH_ID")
    private Branch branch;

    @Column(name = "NAME")
    private String name;

    @Column(name = "RESPONSIBILITY")
    private String responsibility;

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

    @Column(name = "PASSWORD_TYPE")
    private String passwordType;

    @Column(name = "PASSWORD_SALT")
    private String passwordSalt;

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
