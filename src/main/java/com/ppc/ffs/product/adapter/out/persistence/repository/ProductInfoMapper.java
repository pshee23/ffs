package com.ppc.ffs.product.adapter.out.persistence.repository;

import org.springframework.stereotype.Component;

import com.ppc.ffs.branch.adapter.out.persistence.entity.Branch;
import com.ppc.ffs.product.adapter.out.persistence.entity.Product;
import com.ppc.ffs.product.domain.ProductInfo;
import com.ppc.ffs.product.domain.ProductRegisterInfo;

@Component
public class ProductInfoMapper {

	public Product mapProductRegisterInfoToProduct(ProductRegisterInfo createInfo, Branch branch) {
		Product product = new Product();
		product.setBranch(branch);
		product.setName(createInfo.getName());
		product.setPrice(createInfo.getPrice());
		product.setProductType(createInfo.getProductType());
		product.setStartDate(createInfo.getStartDate());
		product.setEndDate(createInfo.getEndDate());
		product.setIsUse(createInfo.getIsUse());
		return product;
	}
	
	public ProductInfo mapProductToProductInfo(Product product) {
		ProductInfo productInfo = ProductInfo.builder()
				.productId(product.getProductId())
				.branchId(product.getBranch().getBranchId())
				.name(product.getName())
				.price(product.getPrice())
				.productType(product.getProductType())
				.startDate(product.getStartDate())
				.endDate(product.getEndDate())
				.isUse(product.getIsUse())
				.build();
		return productInfo;
	}
}
