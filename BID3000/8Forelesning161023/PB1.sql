/*
PB1:
Using the SSITEM and SSSALES tables, retrieve the total sales units 
for each item brand. 
Rank the item brands based on the total sales units in 
descending order. 
Display the brand, its total sales units, and its rank. 
The final result should be ordered by the rank of total sales units.
*/
SELECT ItemBrand, SUM(SalesUnits) as SumSalesUnit,
RANK() OVER (ORDER BY SUM(SalesUnits) DESC) SalesRank
FROM SSItem,SSSales
WHERE SSSales.itemID = SSItem.itemId
GROUP BY itembrand
ORDER BY SalesRank;

