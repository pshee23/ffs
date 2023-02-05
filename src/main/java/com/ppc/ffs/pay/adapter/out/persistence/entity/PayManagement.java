package com.ppc.ffs.pay.adapter.out.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PAY_MANAGEMEMT")
public class PayManagement {

    @Id
    @EmbeddedId
    private PayManagementPk id;

    @Column(name = "AMOUNT")
    private Integer amount;


}
