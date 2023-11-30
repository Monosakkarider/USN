/*
Using the SSSALES, SSITEM, SSTIMEDIM, and SSSTORE tables, 
rank the item brands based on their total sales dollars within 
each store state. 
For each item brand and year, compute the sum of sales dollars. 
Then, rank the item brands within their respective store states 
based on this sum in descending order. 
Display the year, item brand, store state, total sales dollars, 
and the rank of each item brand within its store state. 
ordered by store state and the rank of total sales dollars
*/
SELECT TimeYear, ItemBrand, StoreState, SUM(SalesDollar) AS SumSales,
	RANK() OVER (PARTITION BY StoreState
				ORDER BY SUM(SalesDollar)DESC) AS RankSales
FROM SSSales,SSStore, SSItem, SSTimeDim
WHERE SSSales.StoreId = SSStore.StoreId
	AND SSSales.TimeNo = SSTimeDim.TimeNo
	AND SSSales.ItemId = SSItem.ItemId
GROUP BY TimeYear, ItemBrand, StoreState
ORDER BY StoreState, RankSales;