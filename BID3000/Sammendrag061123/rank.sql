/*
Using the SSITEM and SSSALES tables, 
retrieve the total sales units for each item brand. 
Rank item brands based on the total sales units in descending order 
Display the brand, its total sales units, and its rank. 
The final result should be ordered by the rank of total sales units.
*/
SELECT ItemBrand, SUM(SalesUnits) AS SumUnits,
	RANK() OVER (ORDER BY SUM(SalesUnits)DESC) AS RankSalesUnit
FROM SSSales, SSItem
WHERE SSSales.ItemId = SSItem.ItemId
GROUP BY ItemBrand
ORDER BY RankSalesUnit;