package com.store.productcatalog.model;

import java.io.Serializable;

import javax.persistence.Column;

public class ProductAttributeId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "product_id")
	private int productId;

	@Column(name = "attribute_id")
	private int attributeId;

	public ProductAttributeId() {
	}

	public ProductAttributeId(int productId, int attributeId) {
		super();
		this.productId = productId;
		this.attributeId = attributeId;
	}

	public int getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
}
