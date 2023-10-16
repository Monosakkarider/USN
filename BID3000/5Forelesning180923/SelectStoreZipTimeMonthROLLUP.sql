SELECT TimeYear, TimeMonth, SUM(SalesDollar) AS 
	SumSales,
	MIN(SalesDollar) AS MinSales, COUNT(*) AS
	RowCount
FROM sssales, ssstore, sstimedim
WHERE sssales.storeid = ssstore.storeid
AND sssales.timeno = sstimedim.timeno
AND (StoreNation = 'USA' OR StoreNation = 'Canada')
AND TimeYear BETWEEN 2016 AND 2017
GROUP BY ROLLUP(TimeYear, TimeMonth)
ORDER BY TimeYear, TimeMonth;