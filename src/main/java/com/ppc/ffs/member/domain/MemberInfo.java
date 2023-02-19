package com.ppc.ffs.member.domain;

import com.ppc.ffs.access.adapter.out.persistence.entity.AccessHistory;
import com.ppc.ffs.branch.adapter.out.persistence.entity.Branch;
import com.ppc.ffs.employee.adapter.out.persistence.entity.Employee;
import com.ppc.ffs.locker.adapter.out.persistence.entity.Locker;
import com.ppc.ffs.membership.adapter.out.persistence.entity.Membership;
import com.ppc.ffs.pt.adapter.out.persistence.entity.Pt;
import com.ppc.ffs.purchase.adapter.out.persistence.entity.PurchaseHistory;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Getter
@NoArgsConstructor
public class MemberInfo {

    /** 사용자 기본 정보 시작 */
    private Long memberId;

    private Branch branch;

    private Employee employee;

    private String name;

    private String status;

    private String loginId;

    private String loginPassword;

    private String passwordType;

    private String passwordSalt;

    private Date regDate;

    /** 사용자 기본 정보 끝 */

    /** 추가 데이터 시작 */
    private Membership membership;

    private List<AccessHistory> accessList;

    private List<PurchaseHistory> purchaseHistoryList;

    private List<Pt> ptList;

    private Locker locker;
    /** 추가 데이터 끝 */


    @Builder
    public MemberInfo(Long memberId, Branch branch, Employee employee, String name, String status, String loginId, String loginPassword, String passwordType, String passwordSalt,Date regDate) {
        this.memberId = memberId;
        this.branch = branch;
        this.employee = employee;
        this.name = name;
        this.status = status;
        this.loginId = loginId;
        this.loginPassword = loginPassword;
        this.passwordType = passwordType;
        this.passwordSalt = passwordSalt;
        this.regDate = regDate;
    }
}
