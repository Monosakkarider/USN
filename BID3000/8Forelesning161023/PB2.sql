/*
PB2:
Using the SSSALES and SSSTORE tables, rank the stores by the 
total sales in dollars within each state. 
For each zip code in a state, compute the sum of sales in dollars. 
Then, rank the zip codes within their respective states based on 
this sum in descending order. 
Display the zip code, state, total sales in dollars, and the rank 
of each zip code within its state. 
The result should be ordered by state and then by the rank of 
total sales within that state.
*/
SELECT StoreZip, StoreState, SUM(SalesDollar) as TotalSalesDollar,
	RANK() OVER (PARTITION BY StoreState 
	ORDER BY SUM(SalesDollar) DESC) SalesRank
FROM SSStore,SSSales
WHERE SSStore.storeID = SSSales.storeId
GROUP BY StoreZip, StoreState
ORDER BY StoreState, SalesRank;