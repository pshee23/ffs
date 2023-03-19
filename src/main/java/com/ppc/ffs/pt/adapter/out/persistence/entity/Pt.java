package com.ppc.ffs.pt.adapter.out.persistence.entity;

import com.ppc.ffs.lesson.adapter.out.persistence.entity.Lesson;
import com.ppc.ffs.member.adapter.out.persistence.entity.Member;
import com.ppc.ffs.product.adapter.out.persistence.entity.Product;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "PT")
public class Pt {

    @Id
    @Column(name = "PT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ptId;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Column(name = "TOTAL_COUNT")
    private int totalCount;

    @Column(name = "USE_COUNT")
    private int useCount;

    @Column(name = "PRICE_PER_SESSON")
    private int pricePerSession;

    @Column(name = "REGISTER_DATE")
    private LocalDateTime registerDate;

    @OneToMany(mappedBy = "pt")
    private List<Lesson> lessonList = new ArrayList<>();

    public void setProduct(Product product) {
        this.product = product;

        if(!product.getPtList().contains(this)) {
            product.addPt(this);
        }
    }

    public void setMember(Member member) {
        this.member = member;

        if(!member.getPtList().contains(this)) {
            member.addPt(this);
        }
    }

    public void addLesson(Lesson lesson) {
        this.lessonList.add(lesson);

        if(this.totalCount > useCount) {
            this.useCount--;
        }

        if(lesson.getPt() == null || !lesson.getPt().equals(this)) {
            lesson.setPt(this);
        }
    }
}
