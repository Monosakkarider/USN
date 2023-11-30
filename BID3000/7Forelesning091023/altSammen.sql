SELECT ItemBrand, TimeMonth, SUM(SalesDollar) AS SUMSales,
    DENSE_RANK() OVER(PARTITION BY TimeMonth
    	ORDER BY SUM(SalesDollar)DESC) AS DenseRankSales,
    RANK() OVER(PARTITION BY TimeMonth
    	ORDER BY SUM(SalesDollar)DESC) AS RankSales
FROM SSSales, SSTimeDim, SSItem
WHERE SSSales.TimeNo = SSTimeDim.TimeNo 
	AND SSItem.ItemID = SSSales.ItemID AND TimeYear = 2014
GROUP BY ItemBrand, TimeMonth;