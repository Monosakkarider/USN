/*
Sliding logical window
Moving average of sum of dollar sales by year
Centered logical window of 3 years
No partitioning
*/
SELECT TimeYear, SUM(SalesDollar) AS SumSales,
  ROUND(AVG(SUM(SalesDollar)) OVER 
   (ORDER BY TimeYear
   RANGE BETWEEN 1 PRECEDING AND 1 FOLLOWING),2) AS CenterMovAvgSumSales
 FROM SSStore, SSTimeDim, SSSales
 WHERE SSSales.StoreID = SSStore.StoreId 
   AND SSSales.TimeNo = SSTimeDim.TimeNo
 GROUP BY TimeYear;
