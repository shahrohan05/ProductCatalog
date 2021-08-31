package com.store.productcatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.productcatalog.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
