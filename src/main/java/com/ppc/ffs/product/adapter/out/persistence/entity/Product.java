package com.ppc.ffs.product.adapter.out.persistence.entity;

import com.ppc.ffs.branch.adapter.out.persistence.entity.Branch;
import com.ppc.ffs.membership.adapter.out.persistence.entity.Membership;
import com.ppc.ffs.pt.adapter.out.persistence.entity.Pt;
import com.ppc.ffs.purchase.adapter.out.persistence.entity.PurchaseHistory;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @ManyToOne
    @JoinColumn(name="BRANCH_ID")
    private Branch branch;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private Long price;

    @Column(name = "PRODUCT_TYPE")
    private String productType;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "END_DATE")
    private LocalDate endDate;

    @Column(name = "USE_YN")
    private Boolean isUse;

    @OneToMany(mappedBy = "product")
    private List<PurchaseHistory> purchaseHistoryList = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<Pt> ptList = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<Membership> membershipList = new ArrayList<>();

    public void setBranch(Branch branch) {
        this.branch = branch;

        if(!branch.getProductList().contains(this)) {
            branch.addProduct(this);
        }
    }

    public void addPurchaseHistory(PurchaseHistory purchaseHistory) {
        this.purchaseHistoryList.add(purchaseHistory);

        if(!purchaseHistory.getProduct().equals(this)) {
            purchaseHistory.setProduct(this);
        }
    }

    public void addPt(Pt pt) {
        this.ptList.add(pt);

        if(!pt.getProduct().equals(this)) {
            pt.setProduct(this);
        }
    }

    public void addMembership(Membership membership) {
        this.membershipList.add(membership);

        if(membership.getProduct() == null || !membership.getProduct().equals(this)) {
            membership.setProduct(this);
        }
    }
}
