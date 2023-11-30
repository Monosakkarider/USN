/*
Moving average of sum of 2014 dollar sales by month
Centered window on 3 preceding and 3 following months
Show month, sum of sales, and average of sum of sales
*/
SELECT TimeMonth, SUM(SalesDollar) AS SumSales,
	AVG(SUM(SalesDollar)) 
	OVER(ORDER BY TimeMonth RANGE BETWEEN 3 PRECEDING AND 3 FOLLOWING)
	AS AvgSumSales
FROM SSSales, SSTimeDim, SSStore
WHERE SSSales.TimeNo = SSTimeDim.TimeNo
	AND SSSales.StoreId = SSStore.StoreId
	AND TimeYear = 2014
GROUP BY TimeMonth;