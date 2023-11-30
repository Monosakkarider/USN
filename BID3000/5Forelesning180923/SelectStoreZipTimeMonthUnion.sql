SELECT StoreZip, TimeMonth, SUM(SalesDollar) AS SumSales
FROM sssales, ssstore, sstimedim
WHERE sssales.storeid = ssstore.storeid
AND sssales.timeno = sstimedim.timeno
AND (StoreNation = 'USA' OR StoreNation = 'Canada')
AND TimeYear = 2016
GROUP BY StoreZip, TimeMonth

UNION
SELECT StoreZip, NULL, SUM(SalesDollar) AS SumSales
FROM sssales, ssstore, sstimedim
WHERE sssales.storeid = ssstore.storeid
AND sssales.timeno = sstimedim.timeno
AND (StoreNation = 'USA' OR StoreNation = 'Canada')
AND TimeYear = 2016
GROUP BY StoreZip

UNION
SELECT NULL, TimeMonth, SUM(SalesDollar) AS SumSales
FROM sssales, ssstore, sstimedim
WHERE sssales.storeid = ssstore.storeid
AND sssales.timeno = sstimedim.timeno
AND (StoreNation = 'USA' OR StoreNation = 'Canada')
AND TimeYear = 2016
GROUP BY TimeMonth

UNION
SELECT NULL, NULL, SUM(SalesDollar) AS SumSales
FROM sssales, ssstore, sstimedim
WHERE sssales.storeid = ssstore.storeid
AND sssales.timeno = sstimedim.timeno
AND (StoreNation = 'USA' OR StoreNation = 'Canada')
AND TimeYear = 2016