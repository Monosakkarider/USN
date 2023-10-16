USE cofeemerchant_dw;
UPDATE fact_stage_order, dim_inventory
SET fact_stage_order.inventory_sk = dim_inventory.inventory_sk
WHERE fact_stage_order.inventoryID = dim_inventory.InventoryID;

SELECT * 
FROM fact_stage_order;