

create database cofeemerchant_dw;
use cofeemerchant_dw;

create table dim_time (
	date_sk int not null auto_increment primary key,
    dato date,
    monthname varchar(9),
	monthno int(2),
	quarter int(1),
    year int(4)
);

drop procedure if exists pre_fill_timedimension;

DELIMITER //

CREATE PROCEDURE pre_fill_timedimension (IN start_date DATE, IN end_date DATE)
BEGIN
	WHILE start_date < end_date DO
		INSERT INTO dim_time VALUES (
			NULL,
            start_date,
            MONTHNAME (start_date),
            MONTH (start_date),
            QUARTER (start_date),
            YEAR (start_date));
            SET start_date = ADDDATE(start_date, 1 );
		END WHILE;
	END //
    DELIMITER ;
    
