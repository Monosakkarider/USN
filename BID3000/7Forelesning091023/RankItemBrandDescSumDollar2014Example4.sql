/*
Example 4
Rank (both) item brands by descending sum of dollar sales in 2014
Partition rankings by month
Show item brand, month, sum of sales, and ranks (both)
*/
SELECT ItemBrand, TimeMonth, SUM(SalesDollar) AS SumSales,
  RANK() OVER (PARTITION BY TimeMonth 
  	ORDER BY SUM(SalesDollar) DESC) AS RankSumSales,
  DENSE_RANK() OVER (PARTITION BY TimeMonth 
    ORDER BY SUM(SalesDollar) DESC) AS DRankSumSales
FROM SSSales, SSItem, SSTimeDim
WHERE SSSales.ItemID = SSItem.ItemId 
	AND SSSales.TimeNo = SSTimeDim.TimeNo
	AND TimeYear = 2014
GROUP BY ItemBrand, TimeMonth;
