SELECT StoreZip, TimeMonth, 
	SUM(SalesDollar) AS SumSales,
	MIN(SalesDollar) AS MinSales, COUNT(*) AS RowCount
FROM sssales, ssstore, sstimedim
WHERE sssales.storeid = ssstore.storeid
AND sssales.timeno = sstimedim.timeno
AND (StoreNation = 'USA' OR StoreNation = 'Canada')
AND TimeYear = 2016
GROUP BY CUBE (StoreZip, TimeMonth)
ORDER BY StoreZip, TimeMonth;