package com.store.productcatalog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "category_attributes")
@IdClass(CategoryAttributeId.class)
public class CategoryAttributes {

	@Id
	@Column(name = "category_id")
	private int categoryId;

	@Id
	@Column(name = "attribute_id")
	private int attributeId;

	public CategoryAttributes() {
	}

	public CategoryAttributes(int categoryId, int attributeId) {
		super();
		this.categoryId = categoryId;
		this.attributeId = attributeId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}

	@Override
	public String toString() {
		return "CategoryAttributes [categoryId=" + categoryId + ", attributeId=" + attributeId + "]";
	}

}
