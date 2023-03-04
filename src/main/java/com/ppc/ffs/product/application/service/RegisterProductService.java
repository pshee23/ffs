package com.ppc.ffs.product.application.service;

import org.springframework.stereotype.Service;

import com.ppc.ffs.product.application.port.in.RegisterProductUseCase;
import com.ppc.ffs.product.application.port.out.RegisterProductPort;
import com.ppc.ffs.product.domain.ProductInfo;
import com.ppc.ffs.product.domain.ProductRegisterInfo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterProductService implements RegisterProductUseCase {
	
	private final RegisterProductPort registerProductPort;
	
	@Override
	public ProductInfo registerProduct(ProductRegisterInfo createInfo) {
		return registerProductPort.saveProduct(createInfo);
	}
}
