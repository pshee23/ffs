package com.ppc.ffs.branch.adapter.out.persistence.entity;

import com.ppc.ffs.access.adapter.out.persistence.entity.AccessHistory;
import com.ppc.ffs.employee.adapter.out.persistence.entity.Employee;
import com.ppc.ffs.member.adapter.out.persistence.entity.Member;
import com.ppc.ffs.product.adapter.out.persistence.entity.Product;
import com.ppc.ffs.purchase.adapter.out.persistence.entity.PurchaseHistory;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "BRANCH")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchId;

    @Column(name="NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @OneToMany(mappedBy = "branch")
    private List<AccessHistory> accessList = new ArrayList<>();

    @OneToMany(mappedBy = "branch")
    private List<Employee> employeeList = new ArrayList<>();

    @OneToMany(mappedBy = "branch")
    private List<Member> memberList = new ArrayList<>();

    @OneToMany(mappedBy = "branch")
    private List<Product> productList = new ArrayList<>();

    @OneToMany(mappedBy = "branch")
    private List<PurchaseHistory> purchaseHistoryList = new ArrayList<>();

    public void addAccessHistory(AccessHistory accessHistory) {
        this.accessList.add(accessHistory);

        if(accessHistory.getBranch() == null || !accessHistory.getBranch().equals(this)) {
            accessHistory.setBranch(this);
        }
    }

    public void addEmployee(Employee employee) {
        this.employeeList.add(employee);

        if(employee.getBranch() == null || !employee.getBranch().equals(this)) {
            employee.setBranch(this);
        }
    }

    public void addMember(Member member) {
        this.memberList.add(member);

        if(member.getBranch() == null || !member.getBranch().equals(this)) {
            member.setBranch(this);
        }
    }

    public void addProduct(Product product) {
        this.productList.add(product);

        if(product.getBranch()== null || !product.getBranch().equals(this)) {
            product.setBranch(this);
        }
    }

    public void addPurchaseHistory(PurchaseHistory purchaseHistory) {
        this.purchaseHistoryList.add(purchaseHistory);

        if(purchaseHistory.getBranch() == null || !purchaseHistory.getBranch().equals(this)) {
            purchaseHistory.setBranch(this);
        }
    }

}
