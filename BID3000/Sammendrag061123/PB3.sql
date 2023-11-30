/*
Using the SSSales and SSCustomer tables, rank the customers based
on their total sales units within each nation.
For each customer, compute the sum of sales units.
Then, rank the customers within their respective nations
based on this sum in ascending order.
Display the custName, custNation, totalSalesUnits and the rank
of each customer within it's nation.
The result should be ordered by nation and then by the rank of 
total sales units within that nation
*/
SELECT CustName, CustNation, SUM(SalesUnits) as TotalSalesUnits,
	RANK() OVER (PARTITION BY CustNation 
	ORDER BY SUM(SalesUnits) ASC) SalesUnitsRank
FROM SSSales, SSCustomer
WHERE SSSales.custId = SSCustomer.custID
GROUP BY CustName, CustNation
ORDER BY CustNation, SalesUnitsRank;
