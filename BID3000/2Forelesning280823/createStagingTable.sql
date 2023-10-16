DROP TABLE IF EXISTS fact_stage_order;
CREATE TABLE fact_stage_order (
	orderID INT,
    orderdate DATE,
    date_sk INT,
    consumerID INT,
    consumer_sk INT,
    employeeID INT,
    employee_sk INT,
    inventoryID INT,
    inventory_sk INT,
    quantity INT,
    price FLOAT(10,2),
    actual_price FLOAT(10,2),
    actual_sold FLOAT(10,2));