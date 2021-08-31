package com.store.productcatalog.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.productcatalog.model.Attribute;
import com.store.productcatalog.model.Category;
import com.store.productcatalog.model.CategoryAttributes;
import com.store.productcatalog.model.Product;
import com.store.productcatalog.model.ProductAttributes;
import com.store.productcatalog.repository.AttributeRepository;
import com.store.productcatalog.repository.CategoryAttributesRepository;
import com.store.productcatalog.repository.CategoryRepository;
import com.store.productcatalog.repository.ProductAttributesRepository;
import com.store.productcatalog.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	AttributeRepository attributeRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	CategoryAttributesRepository categoryAttributesRepository;

	@Autowired
	ProductAttributesRepository productAttributesRepository;

	@SuppressWarnings("unchecked")
	public Map<String, Object> createProduct(Map<String, Object> productData) {
		Map<String, Object> response = new HashMap<String, Object>();

		int _categoryId = (Integer) productData.get("categoryId");

		Category category;

		if (categoryRepository.existsById(_categoryId)) {
			category = categoryRepository.getById(_categoryId);
		} else {
			category = categoryRepository.save(new Category((String) productData.get("categoryName")));
			_categoryId = category.getId();
		}

		final int categoryId = _categoryId;

		Product product = new Product((String) productData.get("name"), (String) productData.get("code"), categoryId);
		Product responseProduct = productRepository.save(product);

		List<Map<String, Object>> attributes = (List<Map<String, Object>>) productData.get("attributes");

		attributes.stream().forEach(attribute -> {
			int attributeId = (Integer) attribute.get("attributeId");
			Attribute attributeObj;

			if (attributeRepository.existsById(attributeId)) {
				attributeObj = attributeRepository.getById(attributeId);
				attribute.put("name", attributeObj.getName());
			} else {
				attributeObj = attributeRepository.save(new Attribute((String) attribute.get("name")));
				attributeId = attributeObj.getId();
			}

			CategoryAttributes categoryAttribute = new CategoryAttributes(categoryId, attributeId);
			ProductAttributes productAttributes = new ProductAttributes(responseProduct.getId(), attributeId,
					(String) attribute.get("value"));

			categoryAttributesRepository.save(categoryAttribute);
			productAttributesRepository.save(productAttributes);

		});

		
		ObjectMapper mapper = new ObjectMapper();

		response = mapper.convertValue(responseProduct, Map.class);
		response.put("attributes", attributes);

		return response;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getProduct(int productId) {
		Map<String, Object> response;
		ObjectMapper mapper = new ObjectMapper();

		Product product = productRepository.findById(productId).get(); // non lazy operation
		Category category = categoryRepository.getById(product.getCategoryId());

		response = mapper.convertValue(product, Map.class);

		response.put("categoryName", category.getName());

		List<ProductAttributes> productAttributes = productAttributesRepository.findByProductId(productId);

		List<Map<String, Object>> responseProductAttributes = new ArrayList<Map<String, Object>>();

		productAttributes.stream().forEach(productAttribute -> {
			Map<String, Object> _productAttribure = mapper.convertValue(productAttribute, Map.class);
			Attribute attribute = attributeRepository.getById(productAttribute.getAttributeId());
			_productAttribure.put("attributeName", attribute.getName());
			responseProductAttributes.add(_productAttribure);
		});

		response.put("attributes", responseProductAttributes);

		return response;
	}

}
