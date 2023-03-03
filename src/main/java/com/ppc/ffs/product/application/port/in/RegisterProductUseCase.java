package com.ppc.ffs.product.application.port.in;

import com.ppc.ffs.product.domain.ProductInfo;
import com.ppc.ffs.product.domain.ProductRegisterInfo;

public interface RegisterProductUseCase {
	ProductInfo registerProduct(ProductRegisterInfo registerInfo);
}
