CREATE DATABASE newNeobis;

CREATE TABLE IF NOT EXISTS customers (
id BIGSERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(100) NOT NULL,
	surname VARCHAR(100) NOT NULL,
	email VARCHAR(100) NOT NULL,
	phone VARCHAR(100) NOT NULL);

SELECT * FROM customers;

CREATE TABLE IF NOT EXISTS cars (
id BIGSERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(90) NOT NULL,
	model VARCHAR(90) NOT NULL,
	year INT NOT NULL,
	price FLOAT NOT NULL);

SELECT * FROM cars;

CREATE TABLE IF NOT EXISTS orders(
 id BIGSERIAL PRIMARY KEY NOT NULL,
	order_date TIMESTAMP DEFAULT NOW() NOT NULL,
	total_price DOUBLE PRECISION NOT NULL,
	customer_id BIGINT NOT NULL,
	car_id BIGINT NOT NULL,
	CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES customers(id),
	CONSTRAINT fk_car_id FOREIGN KEY (car_id) REFERENCES cars(id));
	
SELECT * FROM orders;

DROP TABLE customers;
INSERT INTO customers (name, email) VALUES(?, ?);
DELETE FROM customers WHERE id = ?;
SELECT name, email FROM customers WHERE id = ?;
UPDATE customers SET name = ?, email = ? WHERE customers.id = ?;









