package com.ppc.ffs.member.adapter.out.persistence.entity;

import com.ppc.ffs.access.adapter.out.persistence.entity.AccessHistory;
import com.ppc.ffs.branch.adapter.out.persistence.entity.Branch;
import com.ppc.ffs.employee.adapter.out.persistence.entity.Employee;
import com.ppc.ffs.locker.adapter.out.persistence.entity.Locker;
import com.ppc.ffs.membership.adapter.out.persistence.entity.Membership;
import com.ppc.ffs.pt.adapter.out.persistence.entity.Pt;
import com.ppc.ffs.purchase.adapter.out.persistence.entity.PurchaseHistory;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "MEMBER")
public class Member {

    @Id
    @Column(name = "MEMBER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @ManyToOne
    @JoinColumn(name = "BRANCH_ID")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @Column(name = "NAME")
    private String name;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "LOGIN_ID")
    private String loginId;

    @Column(name = "LOGIN_PASSWORD")
    private String loginPassword;

    @Column(name = "PASSWORD_TYPE")
    private String passwordType;

    @Column(name = "PASSWORD_SALT")
    private String passwordSalt;

    @OneToOne(mappedBy = "member")
    private Membership membership;

    @OneToMany(mappedBy = "member")
    private List<AccessHistory> accessList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<PurchaseHistory> purchaseHistoryList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Pt> ptList = new ArrayList<>();

    @OneToOne(mappedBy = "member")
    private Locker locker;

    public void addAccessHistory(AccessHistory accessHistory) {
        this.accessList.add(accessHistory);

        if(accessHistory.getMember() != this) {
            accessHistory.setMember(this);
        }
    }

    public void setBranch(Branch branch) {
        this.branch = branch;

        if(!branch.getMemberList().contains(this)) {
            branch.addMember(this);
        }
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;

        if(!employee.getMemberList().contains(this)) {
            employee.addMember(this);
        }
    }

    public void addPurchaseHistory(PurchaseHistory purchaseHistory) {
        this.purchaseHistoryList.add(purchaseHistory);

        if(!purchaseHistory.getMember().equals(this)) {
            purchaseHistory.setMember(this);
        }
    }

    public void addPt(Pt pt){
        this.ptList.add(pt);

        if(!pt.getMember().equals(this)) {
            pt.setMember(this);
        }
    }

    public void setLocker(Locker locker) {
        this.locker = locker;

        if(!locker.getMember().equals(this)) {
            locker.setMember(this);
        }
    }

    public void setMembership(Membership membership) {
        this.membership = membership;

        if(membership.getMember() == null || !membership.getMember().equals(this)) {
            membership.setMember(this);
        }
    }
}
