/*
Using the SSSALES and SSCUSTOMER tables, 
rank the customers based on their total sales units within each nation.
For each customer, compute the sum of sales units. 
Then, rank the customers within their respective nations based on 
this sum in ascending order. 
Display the customer name, nation, total sales units, and 
the rank of each customer within its nation. 
The result should be ordered by nation and then by the 
rank of total sales units within that nation.
*/
SELECT CustName, CustNation, SUM(SalesUnits) AS TotalSalesUnits,
	RANK() OVER (PARTITION BY CustNation 
				 ORDER BY SUM(SalesUnits) ASC) AS RankCust
FROM SSSales, SSCustomer
WHERE SSSales.CustId = SSCustomer.CustId
GROUP BY CustName, CustNation
ORDER BY CustNation, RankCust;