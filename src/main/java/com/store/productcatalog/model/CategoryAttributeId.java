package com.store.productcatalog.model;

import java.io.Serializable;

import javax.persistence.Column;

public class CategoryAttributeId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "category_id")
	private int categoryId;

	@Column(name = "attribute_id")
	private int attributeId;

	public CategoryAttributeId() {
	}

	public CategoryAttributeId(int categoryId, int attributeId) {
		super();
		this.categoryId = categoryId;
		this.attributeId = attributeId;
	}

	public int getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
}
