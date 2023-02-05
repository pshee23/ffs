package com.ppc.ffs.access.adapter.out.persistence.entity;

import com.ppc.ffs.branch.adapter.out.persistence.entity.Branch;
import com.ppc.ffs.member.adapter.out.persistence.entity.Member;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ACCESS_HISTORY")
public class AccessHistory {

    @Id
    @Column(name = "ACCESS_HISTORY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accessHistoryId;

    @ManyToOne
    @JoinColumn(name="BRANCH_ID")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Column(name="ACCESS_DATE")
    private LocalDateTime accessDateTime;


    public void setBranch(Branch branch) {
        this.branch = branch;

        if(!branch.getAccessList().contains(this)) {
            branch.addAccessHistory(this);
        }
    }

    public void setMember(Member member) {
        this.member = member;

        if(!member.getAccessList().contains(this)) {
            member.addAccessHistory(this);
        }
    }
}
