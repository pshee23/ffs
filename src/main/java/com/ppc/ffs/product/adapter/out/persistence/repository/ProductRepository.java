package com.ppc.ffs.product.adapter.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppc.ffs.product.adapter.out.persistence.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}