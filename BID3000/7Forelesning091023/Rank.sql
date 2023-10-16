SELECT ItemId, ItemBrand, ItemUnitPrice,
	RANK() OVER (ORDER BY ItemUnitPrice) AS RankUnitPrice
	FROM SSItem;