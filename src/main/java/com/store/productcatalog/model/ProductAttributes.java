package com.store.productcatalog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "product_attributes")
@IdClass(ProductAttributeId.class)
public class ProductAttributes {

	@Id
	@Column(name = "product_id")
	private int productId;

	@Id
	@Column(name = "attribute_id")
	private int attributeId;

	private String value;

	public ProductAttributes() {
	}

	public ProductAttributes(int productId, int attributeId, String value) {
		super();
		this.productId = productId;
		this.attributeId = attributeId;
		this.value = value;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ProductAttributes [productId=" + productId + ", attributeId=" + attributeId + ", value=" + value + "]";
	}

}
