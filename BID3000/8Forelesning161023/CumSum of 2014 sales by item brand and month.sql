/*
Example 3
Cumulative sum of 2014 sales by item brand and month
Partition by item brand
Show item brand, month, sum of sales, and cumulative sum of sales
*/
SELECT ItemBrand,TimeMonth, SUM(SalesDollar) AS SumSales,
	SUM(Sum(SalesDollar)) OVER (PARTITION BY ItemBrand ORDER BY ItemBrand, TimeMonth
	ROWS UNBOUNDED PRECEDING) AS CumSumSales
FROM SSSales, SSItem, SSTimeDim
WHERE SSSales.Itemid = SSItem.ItemID AND SSSales.TimeNo = SSTimeDim.TimeNo AND TimeYear = 2014
Group By ItemBrand, TimeMonth;