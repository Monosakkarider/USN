CREATE TABLE dim_inventory (
	inventory_sk INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    InventoryID INT,
		Name VARCHAR(40) NOT NULL,
        Price FLOAT(6,2),
        itemType VARCHAR(1),
        countryname VARCHAR(40));
        
TRUNCATE TABLE dim_inventory;
INSERT INTO dim_inventory
SELECT
	NULL,
    InventoryID,
    Name,
    Price,
    itemType,
    countryname
FROM cofeemerchant.inventory
LEFT JOIN cofeemerchant.countries
ON cofeemerchant.inventory.CountryID = cofeemerchant.countries.CountryID;

SELECT *
FROM dim_inventory;
        