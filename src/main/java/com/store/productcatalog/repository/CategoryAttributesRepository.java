package com.store.productcatalog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.productcatalog.model.CategoryAttributeId;
import com.store.productcatalog.model.CategoryAttributes;

public interface CategoryAttributesRepository extends JpaRepository<CategoryAttributes, CategoryAttributeId> {
	
	List<CategoryAttributes> findByCategoryId(int categoryId);

}
