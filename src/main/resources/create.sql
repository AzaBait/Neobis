CREATE TABLE IF NOT EXISTS customers (
id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(100) NOT NULL,
	email VARCHAR(100) NOT NULL);

SELECT * FROM customers;

CREATE TABLE IF NOT EXISTS cars (
id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(90) NOT NULL,
	model VARCHAR(90) NOT NULL,
	year INT NOT NULL,
	price FLOAT NOT NULL);

SELECT * FROM cars;

CREATE TABLE IF NOT EXISTS orders(
 id SERIAL PRIMARY KEY NOT NULL,
	order_date TIMESTAMP NOT NULL,
	total_price INT NOT NULL,
	customer_id BIGINT NOT NULL,
	car_id BIGINT NOT NULL,
	CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES customers(id),
	CONSTRAINT fk_car_id FOREIGN KEY (car_id) REFERENCES cars(id));
	
SELECT * FROM orders;

DROP TABLE customers;
INSERT INTO customers (name, email) VALUES(?, ?);
DELETE FROM customers WHERE id = ?;
SELECT name, email FROM customers WHERE id = ?;









