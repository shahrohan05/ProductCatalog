package com.store.productcatalog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.productcatalog.model.ProductAttributeId;
import com.store.productcatalog.model.ProductAttributes;

public interface ProductAttributesRepository extends JpaRepository<ProductAttributes, ProductAttributeId>{
	
	List<ProductAttributes> findByProductId(int productId); 
}
