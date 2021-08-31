package com.store.productcatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.productcatalog.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
