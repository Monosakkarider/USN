SELECT TimeMonth, DivId, StoreZip, 
       SUM(SalesDollar) AS SumSales
 FROM SSSales, SSStore, SSTimeDim
 WHERE SSSales.StoreId = SSStore.StoreId 
   AND SSSales.TimeNo = SSTimeDim.TimeNo
   AND (StoreNation = 'USA' 
    OR StoreNation = 'Canada') 
   AND TimeYear = 2016
 GROUP BY GROUPING SETS((TimeMonth,DivId, StoreZip),
						(TimeMonth,DivId),(TimeMonth,StoreZip),
						TimeMonth)
 ORDER BY TimeMonth, DivId, StoreZip;
