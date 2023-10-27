USE cofeemerchant_dw;

CREATE TABLE dim_customers (
	customer_sk INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    customerID INT,
    firstname VARCHAR (30),
    lastname VARCHAR (30),
    street VARCHAR (50),
    zipcode VARCHAR (5),
    city VARCHAR (50),
    state VARCHAR (2));

INSERT INTO dim_customers
SELECT
	NULL,
    consumerID,
    firstname,
    lastname,
    street,
    zipcode,
    city,
    state
FROM cofeemerchant.consumers;

SELECT *
FROM dim_customers;