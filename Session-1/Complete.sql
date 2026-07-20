CREATE DATABASE covid_db;

USE covid_db;

CREATE TABLE covid_cases (
    id INT PRIMARY KEY AUTO_INCREMENT,
    country VARCHAR(50) NOT NULL,
    report_date DATE NOT NULL,
    report_time TIME,
    confirmed_cases INT DEFAULT 0,
    deaths INT DEFAULT 0,
    recoveries INT DEFAULT 0,
    population BIGINT
);

INSERT INTO covid_cases
(country, report_date, report_time, recoveries, deaths, confirmed_cases)
VALUES
('India', '2020-03-15', '10:00:00', 50, 2, 100);

UPDATE covid_cases
SET confirmed_cases = 120
WHERE country = 'India'
AND report_date = '2020-03-15';

DELETE FROM covid_cases
WHERE country = 'IN';

ALTER TABLE covid_cases
ADD vaccination_rate DECIMAL(5,2);

SELECT * FROM covid_cases;
