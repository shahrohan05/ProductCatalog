package com.store.productcatalog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.productcatalog.model.Attribute;
import com.store.productcatalog.model.Category;
import com.store.productcatalog.model.CategoryAttributes;
import com.store.productcatalog.repository.AttributeRepository;
import com.store.productcatalog.repository.CategoryAttributesRepository;
import com.store.productcatalog.repository.CategoryRepository;

@Service
@Transactional
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	AttributeRepository attributeRepository;

	@Autowired
	CategoryAttributesRepository categoryAttributeRepository;

	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getCategoryWithAttributes(int categoryId) {
		Map<String, Object> response;
		ObjectMapper mapper = new ObjectMapper();
		Category category = categoryRepository.findById(categoryId).get();
		response = mapper.convertValue(category, Map.class);
		List<Attribute> attributes = new ArrayList<Attribute>();

		List<CategoryAttributes> categoryAttributes = categoryAttributeRepository.findByCategoryId(categoryId);

		categoryAttributes.stream().forEach(
				categoryAttribute -> attributes.add(attributeRepository.findById(categoryAttribute.getAttributeId()).get()));

		response.put("attributes", attributes);

		return response;
	}

}
