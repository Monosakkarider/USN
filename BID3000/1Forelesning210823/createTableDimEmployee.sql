USE cofeemerchant_dw;

CREATE TABLE dim_employee (
	employee_sk INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employeeID INT,
    firstName VARCHAR(30),
    lastName VARCHAR(30),
    workPhone VARCHAR(8),
    commissionRate FLOAT(4,4),
    hireRate DATE,
    birthDate DATE,
    gender VARCHAR(1)
);

INSERT INTO dim_employee
SELECT
	NULL,
    employeeID,
    firstName,
    lastName,
    workPhone,
    commissionRate,
    hireDate,
    birthDate,
    gender
FROM cofeemerchant.employees;
