USE classicmodels_dw;

/*Query that creates the Dim_Employee table */ 
DROP TABLE IF EXISTS Dim_Employee;
CREATE TABLE Dim_Employee (
	employee_sk INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employeeNumber INT,
    lastName VARCHAR(50),
    firstName VARCHAR(50),
    city VARCHAR(50),
    state VARCHAR(50),
    country VARCHAR(50)
);

INSERT INTO Dim_Employee
SELECT
	NULL,
    employeeNumber,
    lastName,
    firstName,
    city,
    state,
    country
FROM classicmodels.employees, classicmodels.offices
WHERE classicmodels.employees.officeCode = classicmodels.offices.officeCode
;

SELECT *
FROM Dim_Employee;