package com.ppc.ffs.locker.adapter.out.persistence.entity;

import com.ppc.ffs.member.adapter.out.persistence.entity.Member;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "LOCKER")
public class Locker {

    @Id
    @Column(name = "LOCKER_Id")
    private Long lockerId;

    @OneToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    public void setMember(Member member) {
        this.member = member;

        if(!member.getLocker().equals(this)) {
            member.setLocker(this);
        }
    }

}
