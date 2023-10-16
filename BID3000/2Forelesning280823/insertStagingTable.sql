TRUNCATE fact_stage_order;
INSERT INTO fact_stage_order
SELECT
	o.orderID,
    o.orderDate,
    NULL,
    o.consumerID,
    NULL,
    o.employeeID,
    NULL,
    ol.inventoryID,
    NULL,
    ol.quantity,
    ol.price,
    ol.price - ol.price*ol.discount,
    (ol.price - ol.price*ol.discount)*ol.quantity
FROM cofeemerchant.orders o, cofeemerchant.orderlines ol
WHERE o.orderID = ol.OrderID;