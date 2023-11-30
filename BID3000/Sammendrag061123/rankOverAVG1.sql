/*
Rank item brands descending by average dollar sales in 2014 and 2015
Show item brand, average dollar sales, and rank
*/
SELECT ItemBrand, AVG(SalesDollar) AS AvgSales,
	RANK() OVER (ORDER BY AVG(SalesDollar) DESC) AS AvgSalesRank
FROM SSSales, SSItem, SSTimeDim
WHERE SSSales.ItemId = SSItem.ItemId 
	AND SSSales.TimeNo = SSTimeDim.TimeNo
	AND SSTimeDim.TimeYear BETWEEN 2014 AND 2015
GROUP BY ItemBrand;