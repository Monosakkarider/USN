/*
Example 4
Cumulative sum of sales by year and item brand
Partition by year
Only include brands with more than 5 sales in a year
Show year, item brand, count, sum of sales, and cumulative sum of sales in the result
*/
SELECT TimeYear, ItemBrand, COUNT(*) AS RowCount, SUM(SalesDollar) AS SumSales,
	SUM(SUM(SalesDollar)) OVER (PARTITION BY TimeYear ORDER BY TimeYear, ItemBrand
	ROWS UNBOUNDED PRECEDING) AS CumSumSales
FROM SSTimeDim, SSItem, SSSales
WHERE SSItem.ItemId = SSSales.ItemId AND SStimeDim.TimeNo = SSSales.TimeNo
GROUP BY TimeYear, ItemBrand
HAVING COUNT(*) >5;