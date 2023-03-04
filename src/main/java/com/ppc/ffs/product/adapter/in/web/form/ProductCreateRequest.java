package com.ppc.ffs.product.adapter.in.web.form;

import java.time.LocalDate;

import com.ppc.ffs.product.domain.ProductRegisterInfo;

import lombok.Data;

@Data
public class ProductCreateRequest {
    private Long branchId;
    private String name;
    private Long price;
    private String productType;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isUse;
    
    public ProductRegisterInfo of() {
    	return ProductRegisterInfo.builder()
    			.branchId(branchId)
    			.name(name)
    			.price(price)
    			.productType(productType)
    			.startDate(startDate)
    			.endDate(endDate)
    			.isUse(isUse).build();
    }
}
