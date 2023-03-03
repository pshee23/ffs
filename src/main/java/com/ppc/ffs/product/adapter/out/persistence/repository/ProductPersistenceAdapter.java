package com.ppc.ffs.product.adapter.out.persistence.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ppc.ffs.branch.adapter.out.persistence.entity.Branch;
import com.ppc.ffs.branch.adapter.out.persistence.repository.BranchRepository;
import com.ppc.ffs.product.adapter.out.persistence.entity.Product;
import com.ppc.ffs.product.application.port.out.RegisterProductPort;
import com.ppc.ffs.product.domain.ProductInfo;
import com.ppc.ffs.product.domain.ProductRegisterInfo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class ProductPersistenceAdapter implements RegisterProductPort {
	
	private final ProductRepository productRepository;
	private final BranchRepository branchRepository;
	private final ProductInfoMapper productInfoMapper;
	
	@Override
	public ProductInfo saveProduct(ProductRegisterInfo createInfo) {
		Optional<Branch> branch = branchRepository.findById(createInfo.getBranchId());
		if(branch.isEmpty()) {
			return ProductInfo.builder().build();
		}
		Product product = productInfoMapper.mapProductRegisterInfoToProduct(createInfo, branch.get());
		return productInfoMapper.mapProductToProductInfo(productRepository.save(product));
	}
}
