package com.ppc.ffs.product.domain;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductInfo {
	private Long productId;
    private Long branchId;
    private String name;
    private Long price;
    private String productType;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isUse;
}
