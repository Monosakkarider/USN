/*
Using the SSSALES, SSSTORE, and SSTIMEDIM tables, 
rank the stores based on their total sales cost for each year. 
For each store, compute the sum of sales cost. 
Then, rank the stores within each year based on this sum in desc order
Display the store's ZIP code, the sales year, 
the total sales cost for that year, and the 
rank of each store within that year. 
ordered by sales year and then by the rank of total sales cost 
within that year.
*/
SELECT StoreZip, TimeYear, SUM(SalesCost) AS TotalSalesCost,
	RANK() OVER(PARTITION BY TimeYear 
				ORDER BY SUM(SalesCost) DESC) AS RankSalesCost
FROM SSSales, SSStore, SSTimeDim
WHERE SSSales.StoreId = SSStore.StoreId
	AND SSSales.TimeNO = SSTimeDim.TimeNo
GROUP BY StoreZip, TimeYear
ORDER BY TimeYear, RankSalesCost;