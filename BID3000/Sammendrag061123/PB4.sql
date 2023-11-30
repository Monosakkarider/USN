/*
Using the SSSales, SSStore and SSTimeDim tables, rank the stores
based on their total sales cost for each year.
For each store, compute the sum of sales cost.
Then, rank the stores within each year based on this sum in
descending order.
Display StoreZip, salesYear, total sales cost for that year and 
the rank of each store within that year.
Order by salesYear, rank of total sales cost within that year
*/
SELECT StoreZip, TimeYear, SUM(SalesCost) as TotalSalesCost,
	RANK() OVER (PARTITION BY TimeYear 
	ORDER BY SUM(SalesCost) DESC) SalesCostRank
FROM SSSales, SSStore, SSTimeDim
WHERE SSSales.storeId = SSStore.storeID 
	AND SSSales.timeno = SSTimeDim.timeno
GROUP BY StoreZip, TimeYear
ORDER BY TimeYear, SalesCostRank;