/*
Using the SSSALES, SSSTORE, and SSTIMEDIM tables, 
rank the stores based on their total sales dollars for each year. 
For each store, compute the sum of sales dollars. 
Then, rank the stores within each year based on this sum in asc order. 
Display the store's ZIP code, the sales year, 
the total sales dollars for that year, and 
the rank of each store within that year. 
ordered by sales year and then by the rank of total sales dollars 
within that year.
*/
SELECT StoreZip, TimeYear, SUM(SalesDollar) AS TotalSales,
	RANK() OVER (PARTITION BY TimeYear
				ORDER BY SUM(SalesDollar)ASC) AS RankSales
FROM SSSales, SSStore, SSTimeDim
WHERE SSSales.StoreId = SSStore.StoreId
	AND SSSales.TimeNo = SSTimeDim.TimeNo
GROUP BY StoreZip, TimeYear
ORDER BY TimeYear, RankSales;