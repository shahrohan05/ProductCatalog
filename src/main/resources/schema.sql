DROP TABLE IF EXISTS category_attributes;

DROP TABLE IF EXISTS product_attributes;

DROP TABLE IF EXISTS product;

DROP TABLE IF EXISTS category;

DROP TABLE IF EXISTS attribute;

CREATE TABLE category
  (
     id   INT auto_increment PRIMARY KEY,
     name VARCHAR(255) NOT NULL
  );

CREATE TABLE attribute
  (
     id   INT auto_increment PRIMARY KEY,
     name VARCHAR(255) NOT NULL
  );

CREATE TABLE category_attributes
  (
     category_id  INT NOT NULL,
     attribute_id INT NOT NULL,
     FOREIGN KEY (category_id) REFERENCES category(id),
     FOREIGN KEY (attribute_id) REFERENCES attribute(id),
     PRIMARY KEY(category_id, attribute_id)
  );

CREATE TABLE product
  (
     id          INT auto_increment PRIMARY KEY,
     name        VARCHAR(255) NOT NULL,
     code        VARCHAR(255) NOT NULL,
     category_id INT NOT NULL,
     FOREIGN KEY (category_id) REFERENCES category(id)
  );

CREATE TABLE product_attributes
  (
     product_id   INT NOT NULL,
     attribute_id INT NOT NULL,
     value        VARCHAR(255) NOT NULL,
     FOREIGN KEY (product_id) REFERENCES product(id),
     FOREIGN KEY (attribute_id) REFERENCES attribute(id),
     PRIMARY KEY(product_id, attribute_id)
  ) 