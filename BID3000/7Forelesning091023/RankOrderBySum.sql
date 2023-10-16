SELECT CustState, CustName, SUM(SalesDollar) AS SumSales,
	RANK() OVER(ORDER BY SUM(SalesDollar) DESC) AS SalesRank
	FROM SSSales, SSCustomer
	WHERE SSSales.CustId = SSCustomer.CustId
	GROUP BY CustState, CustName
	ORDER BY CustState;