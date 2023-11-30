

SELECT TimeYear, ItemBrand, COUNT(*) AS rowCount, SUM(SalesDollar) AS SumSales,
  ROUND(AVG(SUM(SalesDollar)) OVER 
   (PARTITION BY TimeYear ORDER BY TimeYear, ItemBrand
   ROWS BETWEEN 2 PRECEDING AND 2 FOLLOWING),2) AS SlidingAvgSumSales
 FROM SSTimeDim, SSSales, SSItem
 WHERE SSSales.TimeNo = SSTimeDim.TimeNo 
 	AND SSSales.ItemID = SSItem.ItemID
 GROUP BY TimeYear, ItemBrand
 HAVING COUNT(*) >5;