USE classicmodels_dw;
DROP TABLE IF EXISTS Fact_Stage_Order;
CREATE TABLE Fact_Stage_Order(
	fact_pk INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	customer_sk INT,
	product_sk INT,
	employee_sk INT,
	time_sk  INT,
	orderNumber INT,
	orderDate DATE,
	customerNumber INT,
	productCode VARCHAR(15),
	salesRepEmployeeNumber INT,
	quantityOrdered INT,
	priceEach FLOAT(10,2),
	total_sale FLOAT(10,2)
);

TRUNCATE Fact_Stage_Order;
INSERT INTO Fact_Stage_Order
SELECT
	NULL,
	NULL,
	NULL,
	NULL,
	NULL,
	orders.orderNumber,
	orders.orderDate,
	orders.customerNumber,
	orderDetails.productCode,
	customers.salesRepEmployeeNumber,
	orderDetails.quantityOrdered,
	orderDetails.priceEach,
	(orderDetails.quantityOrdered*orderDetails.priceEach)
FROM classicmodels.orders,classicmodels.orderdetails,classicmodels.customers
WHERE orders.orderNumber = orderDetails.orderNumber AND customers.customerNumber = orders.customerNumber;

UPDATE fact_stage_order,dim_customer
SET fact_stage_order.customer_sk = dim_customer.customer_sk
WHERE fact_stage_order.customerNumber = dim_customer.customerNumber;

UPDATE fact_stage_order,dim_product
SET fact_stage_order.product_sk = dim_product.product_sk
WHERE fact_stage_order.productCode = dim_product.ProductCode;

UPDATE fact_stage_order,dim_employee
SET fact_stage_order.employee_sk = dim_employee.employee_sk
WHERE fact_stage_order.salesRepEmployeeNumber = dim_employee.employeeNumber;

UPDATE fact_stage_order,dim_time
SET fact_stage_order.time_sk = dim_time.time_sk
WHERE fact_stage_order.orderDate = dim_time.date;


