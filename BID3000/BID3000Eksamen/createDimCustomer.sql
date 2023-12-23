USE classicmodels_dw;

DROP TABLE IF EXISTS Dim_Customer;
CREATE TABLE Dim_Customer(
    Customer_sk INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    CustomerNumber INT,
    CustomerName VARCHAR(40),
    City VARCHAR(40),
    State VARCHAR(40),
    Country VARCHAR(40));
    
INSERT INTO Dim_Customer
SELECT
	NULL,
	CustomerNumber,
	CustomerName,
	City,
	State,
	Country
FROM classicmodels.customers;

SELECT *
FROM Dim_Customer;

