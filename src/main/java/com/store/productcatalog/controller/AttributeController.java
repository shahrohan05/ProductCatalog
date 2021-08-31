package com.store.productcatalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.productcatalog.model.Attribute;
import com.store.productcatalog.repository.AttributeRepository;

@RestController
@RequestMapping("/attribute")
public class AttributeController {
	
	@Autowired
	AttributeRepository attributeRepository;
	
	@PostMapping
	public ResponseEntity<Object> createAttribute(@RequestBody Attribute attribute) {
		try {
			Attribute _attribute = attributeRepository.save(attribute);
			return new ResponseEntity<Object>(_attribute, HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
