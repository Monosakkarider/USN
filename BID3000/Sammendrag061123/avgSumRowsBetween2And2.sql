/*
Moving average of sum of sales by year and item brand
Partition by year
Centered window on 2 preceding and 2 following rows
Only include brands with more than 5 sales in a year
Show year, item brand, count, sum of sales, 
and average sum of sales in the result
*/
SELECT ItemBrand, TimeYear, COUNT(*) AS RowCount, SUM(SalesDollar) AS SumSales,
	AVG(SUM(SalesDollar)) OVER 
	(PARTITION BY TimeYear ORDER BY ItemBrand, TimeYear
	ROWS BETWEEN 2 PRECEDING AND 2 FOLLOWING) AS AvgSumSales
FROM SSSales, SSItem, SSTimeDim
WHERE SSSales.ItemId = SSItem.ItemId
	AND SSSales.TimeNo = SSTimeDim.TimeNo
GROUP BY ItemBrand, TimeYear
HAVING COUNT(*) >5;