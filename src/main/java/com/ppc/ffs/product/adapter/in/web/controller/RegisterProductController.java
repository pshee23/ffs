package com.ppc.ffs.product.adapter.in.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppc.ffs.product.adapter.in.web.form.ProductCreateRequest;
import com.ppc.ffs.product.application.port.in.RegisterProductUseCase;
import com.ppc.ffs.product.domain.ProductInfo;
import com.ppc.ffs.product.domain.ProductRegisterInfo;

@RequestMapping("/product")
@RestController
public class RegisterProductController {
	
	@Autowired
	RegisterProductUseCase registerProductUseCase;

	@PostMapping
	public ResponseEntity<String> registerBranch(@RequestBody @Valid ProductCreateRequest request) {
		ProductRegisterInfo registerInfo = request.of();
		ProductInfo productInfo = registerProductUseCase.registerProduct(registerInfo);
		return ResponseEntity.ok(productInfo.toString());
	}
}
