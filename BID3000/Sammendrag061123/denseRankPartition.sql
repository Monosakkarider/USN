/*
Dense rank item brands descending by the number of sales rows
Partition ranking by year
Only include brands with more than 5 sales in a year
Show item brand, year, count, and dense rank in the result
*/
SELECT ItemBrand, TimeYear, COUNT(*) As RowCount, 
	DENSE_RANK() OVER(PARTITION BY TimeYear ORDER BY(ItemBrand)DESC) AS DRItemBrand
FROM SSTimeDim, SSSales, SSItem
WHERE SSTimeDim.TimeNO=SSSales.TimeNO 
	AND SSSales.ItemID = SSItem.ItemID
GROUP BY ItemBrand, TimeYear
HAVING COUNT(*) >5;