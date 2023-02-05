package com.ppc.ffs.purchase.adapter.out.persistence.entity;

import com.ppc.ffs.branch.adapter.out.persistence.entity.Branch;
import com.ppc.ffs.employee.adapter.out.persistence.entity.Employee;
import com.ppc.ffs.member.adapter.out.persistence.entity.Member;
import com.ppc.ffs.product.adapter.out.persistence.entity.Product;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "PURCHASE_HISTORY")
public class PurchaseHistory {

    @Id
    @Column(name = "PURCHASE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseId;

    @ManyToOne
    @JoinColumn(name = "BRANCH_ID")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @Column(name = "PURCHASE_DATE")
    private LocalDateTime purchaseDate;

    @Column(name = "AMOUNT")
    private Long amount;

    @Column(name = "COMMENT")
    private String comment;

    public void setBranch(Branch branch) {
        this.branch = branch;

        if(!branch.getPurchaseHistoryList().contains(this)) {
            branch.addPurchaseHistory(this);
        }
    }

    public void setProduct(Product product) {
        this.product = product;

        if(!product.getPurchaseHistoryList().contains(this)) {
            product.addPurchaseHistory(this);
        }
    }

    public void setMember(Member member) {
        this.member = member;

        if(!member.getPurchaseHistoryList().contains(this)) {
            member.addPurchaseHistory(this);
        }
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;

        if(!employee.getPurchaseHistoryList().contains(this)) {
            employee.addPurchaseHistory(this);
        }
    }
}
