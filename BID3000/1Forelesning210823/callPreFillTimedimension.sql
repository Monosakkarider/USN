USE cofeemerchant_dw;

CALL pre_fill_timedimension('2005-01-01','2006-12-31');

SELECT *
FROM dim_time;