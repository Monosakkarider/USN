/*Example 3
Dense rank itemBrand descending by the number of sales rows
Partition ranking by year
Only include brands with more than 5 sales in a year
Show item brand, year, count, and dense rank in the result
*/

SELECT ItemBrand, TimeYear, COUNT(*) AS RowCount,
	RANK() OVER (PARTITION BY TimeYear 
	ORDER BY COUNT(*) DESC) AS RankRowCount,
    DENSE_RANK() OVER(Partition BY TimeYear 
	ORDER BY COUNT(*) DESC) AS DenseRankRowCount
FROM SSSales, SSItem, SSTimeDim
WHERE SSSales.ItemId = SSItem.ItemId AND SSSales.TimeNo = SSTimeDim.TimeNo
GROUP BY ItemBrand, TimeYear
HAVING COUNT(*) > 5;
