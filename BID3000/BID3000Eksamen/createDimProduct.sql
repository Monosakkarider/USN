USE classicmodels_dw;

CREATE TABLE Dim_Product (
	product_sk INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	ProductCode VARCHAR(15),
	ProductName VARCHAR(70),
	ProductLine VARCHAR(50),
	ProductVendor VARCHAR(50)
);

INSERT INTO Dim_Product
SELECT
	NULL,
	productCode ,
	productName,
	productLine ,
	productVendor
FROM classicmodels.products;

SELECT *
FROM Dim_Product;

