/*
Cumulative sum of sales by year and item brand
Partition by year
Only include brands with more than 5 sales in a year
Show year, item brand, count, sum of sales, 
and cumulative sum of sales in the result
*/
SELECT ItemBrand, TimeYear, COUNT(*) AS RowCount, SUM(SalesDollar) AS SumSales,
	SUM(SUM(SalesDollar)) OVER 
	(PARTITION BY TimeYear ORDER BY ItemBrand, TimeYear
	ROWS UNBOUNDED PRECEDING) AS CumSumSales
FROM SSItem, SSSales, SSTimeDim
WHERE SSSales.ItemId = SSItem.ItemId
	AND SSSales.TimeNo = SSTimeDim.TimeNo
GROUP BY ItemBrand, TimeYear
HAVING COUNT(*) > 5;