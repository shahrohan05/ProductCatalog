package com.store.productcatalog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "attribute")
@SequenceGenerator(name = "ATTRIBUTE_SEQ", sequenceName = "attribute_sequence_table")
public class Attribute {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ATTRIBUTE_SEQ")
	private int id;

	private String name;

	public Attribute() {
	}

	public Attribute(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Attribute [id=" + id + ", name=" + name + "]";
	}

}
