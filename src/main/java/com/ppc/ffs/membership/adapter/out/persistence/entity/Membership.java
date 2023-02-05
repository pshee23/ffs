package com.ppc.ffs.membership.adapter.out.persistence.entity;

import com.ppc.ffs.member.adapter.out.persistence.entity.Member;
import com.ppc.ffs.product.adapter.out.persistence.entity.Product;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "MEMBERSHIP")
public class Membership {

    @Id
    @Column(name = "MEMBER_ID")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    //상품키
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "END_DATE")
    private LocalDate endDate;

    @Column(name = "PAUSE_START_DATE")
    private LocalDate pauseStartDate;

    @Column(name = "PAUSE_END_DATE")
    private LocalDate pauseEndDate;

    public void setMember(Member member) {
        this.member = member;
        this.id = member.getMemberId();

        if(member.getMembership() == null || !member.getMembership().equals(this)) {
            member.setMembership(this);
        }
    }

    public void setProduct(Product product) {
        this.product = product;

        if(!product.getMembershipList().contains(this)) {
            product.addMembership(this);
        }
    }
}
