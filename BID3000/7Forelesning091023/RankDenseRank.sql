SELECT CustZip, SUM(SalesUnits) AS SumSalesUnits,
	RANK() OVER (ORDER BY SUM (SalesUnits) DESC) SalesUnitRank,
	DENSE_Rank() OVER (ORDER BY SUM(SalesUnits) DESC) SalesUnitDenseRank,
	NTILE(4) OVER (ORDER BY SUM(SalesUnits) DESC) SalesUnitNtile,
	ROW_NUMBER() OVER (ORDER BY SUM(SalesUnits) DESC) SalesUnitRowNum
FROM SSSales, SSCustomer
WHERE SSSales.CustId = SSCustomer.CustId
GROUP BY CustZip;