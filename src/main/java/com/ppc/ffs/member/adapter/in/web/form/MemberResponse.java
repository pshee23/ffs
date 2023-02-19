package com.ppc.ffs.member.adapter.in.web.form;

import com.ppc.ffs.branch.adapter.out.persistence.entity.Branch;
import com.ppc.ffs.employee.adapter.out.persistence.entity.Employee;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class MemberResponse {

    private Long memberId;

    private String name;

    private String status;

    private String loginId;

    private Date regDate;

    private Branch branch;

    private Employee employee;

    @Builder
    public MemberResponse(Long memberId, String name, String status, String loginId, Date regDate, Branch branch, Employee employee) {
        this.memberId = memberId;
        this.name = name;
        this.status = status;
        this.loginId = loginId;
        this.regDate = regDate;
        this.branch = branch;
        this.employee = employee;
    }
}
