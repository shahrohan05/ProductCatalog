package com.store.productcatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.productcatalog.model.Attribute;

public interface AttributeRepository extends JpaRepository<Attribute, Integer> {

}
