/*
Example 4
Rank item brands by average dollar sales in 2014 and 2015
Only include brands with more than 10 sales in 2014 and 2015
Show item brand, number of sales (COUNT), average dollar sales, 
and rank
*/
SELECT ItemBrand, AVG(SalesDollar) AS AvgSales, COUNT(*) AS RowCount,
	RANK() OVER (ORDER BY AVG (SalesDollar) DESC) AS AvgSalesRank
FROM SSSales, SSItem, sstimedim
WHERE SSSales.ItemID = SSItem.ItemId 
	AND SSSales.TimeNo = sstimedim.timeno 
	AND TimeYear BETWEEN 2014 AND 2015
GROUP BY ItemBrand
HAVING COUNT(*) > 10;
