/*
Cumulative sum of 2014 sales by item brand and month
Partition by item brand
Show item brand, month, sum of sales, and cumulative sum of sales
*/
SELECT ItemBrand, TimeMonth, SUM(SalesDollar) AS SumSales,
	SUM(SUM(SalesDollar)) OVER 
		(PARTITION BY ItemBrand ORDER BY ItemBrand, TimeMonth 
		 ROWS UNBOUNDED PRECEDING) AS CumSumSales
FROM SSItem, SSSales, SSTimeDim
WHERE SSSales.ItemId = SSItem.ItemId
	AND SSSales.TimeNo = SSTimeDim.TimeNo
GROUP BY ItemBrand, TimeMonth;