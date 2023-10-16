SELECT StoreZip, TimeYear, SUM(SalesDollar) AS SumSales, 
  SUM(SUM(SalesDollar)) OVER 
   (ORDER BY StoreZip, TimeYear
    ROWS UNBOUNDED PRECEDING ) AS CumSumSales
 FROM SSStore, SSTimeDim, SSSales
 WHERE SSSales.StoreID = SSStore.StoreId 
   AND SSSales.TimeNo = SSTimeDim.TimeNo
 GROUP BY StoreZip, TimeYear;
