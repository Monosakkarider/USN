/*
Example 3
Rank item brands descending by average dollar sales in 2014 and 2015
Show item brand, average dollar sales, and rank
*/
SELECT ItemBrand, AVG(SalesDollar) AS AVGSales,
	RANK() OVER (ORDER BY AVG(SalesDollar) DESC) AS AVGSalesRank
FROM SSSales, SSItem, ssTimeDim
WHERE SSSales.ItemId = SSItem.ItemId 
	AND SSSales.TimeNo = SSTimeDim.TimeNo 
	AND TimeYear BETWEEN 2014 AND 2015
GROUP BY ItemBrand;
