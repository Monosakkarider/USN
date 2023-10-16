USE cofeemerchant_dw;
UPDATE fact_stage_order, dim_time
SET fact_stage_order.date_sk = dim_time.date_sk
WHERE fact_stage_order.orderdate = dim_time.dato;