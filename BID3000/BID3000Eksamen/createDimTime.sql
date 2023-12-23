USE classicmodels_dw;

DROP TABLE IF EXISTS Dim_Time;  
CREATE TABLE Dim_Time (
	time_sk INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    date DATE,
    month VARCHAR(9),
    quarter INT(1),
    year INT(4)
    );

DROP PROCEDURE IF EXISTS Fill_timedimention;

DELIMITER //
CREATE PROCEDURE Fill_timedimention(IN start_date DATE, in end_date DATE)
BEGIN
	WHILE start_date < end_date do
		INSERT INTO dim_time VALUES (
		NULL,
            start_date,
            month(start_date),
            quarter(start_date),
            year(start_date));
            SET start_date = ADDDATE(start_date,1);
	END WHILE;
END; //
DELIMITER ;
CALL Fill_timedimention("2003-01-06","2005-05-31");

SELECT *
FROM Dim_Time;