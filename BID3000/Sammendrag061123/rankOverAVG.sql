/*
Rank item brands by average dollar sales in 2014 and 2015
Only include brands with more than 10 sales in 2014 and 2015
Show item brand, number of sales (COUNT), average dollar sales, rank
*/
SELECT ItemBrand, COUNT(*) AS RowCount, AVG(SalesDollar) AS AvgSales,
	RANK() OVER (ORDER BY AVG(SalesDollar) DESC) AS AvgSalesRank
FROM SSSales, SSItem, SSTimeDim
WHERE SSSales.ItemId = SSItem.ItemId
	AND SSSales.TimeNo = SSTimeDim.TimeNo
	AND TimeYear BETWEEN 2014 AND 2015
GROUP BY ItemBrand
HAVING COUNT(*) > 10;