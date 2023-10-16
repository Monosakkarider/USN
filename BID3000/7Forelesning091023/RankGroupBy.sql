SELECT CustName, SUM(SalesDollar) AS SumSales,
	RANK() OVER (ORDER BY SUM(SalesDollar) DESC) AS SalesRank
	FROM SSSales, sscustomer
	WHERE SSSales.CustId = sscustomer.custid
	GROUP BY CustName;