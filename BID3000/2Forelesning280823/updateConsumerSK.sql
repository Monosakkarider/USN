USE cofeemerchant_dw;
UPDATE fact_stage_order, dim_customers
SET fact_stage_order.consumer_sk = dim_customers.customer_sk
WHERE fact_stage_order.consumerID = dim_customers.customerID;

SELECT *
FROM fact_stage_order;
