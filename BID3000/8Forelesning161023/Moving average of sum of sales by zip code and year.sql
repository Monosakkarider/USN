/*
Moving average of sum of sales by zip code and year
Centered physical window of 3 rows
No partitioning
*/
SELECT StoreZip, TimeYear, SUM(SalesDollar) AS SumSales,
	AVG(SUM(SalesDollar)) OVER 
   (ORDER BY StoreZip, TimeYear
   ROWS BETWEEN 1 PRECEDING AND 1 FOLLOWING) AS CenterMovAvgSumSales
 FROM SSStore, SSTimeDim, SSSales
 WHERE SSSales.StoreID = SSStore.StoreId 
   AND SSSales.TimeNo = SSTimeDim.TimeNo
 GROUP BY StoreZip, TimeYear;
