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
