package com.ppc.ffs.product.application.port.out;

import com.ppc.ffs.product.domain.ProductInfo;
import com.ppc.ffs.product.domain.ProductRegisterInfo;

public interface RegisterProductPort {
	ProductInfo saveProduct(ProductRegisterInfo createInfo);
}
