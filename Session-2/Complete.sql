CREATE DATABASE IF NOT EXISTS covid_db;

USE covid_db;

CREATE TABLE countries (
    country VARCHAR(100) PRIMARY KEY,
    country_code VARCHAR(3) NOT NULL UNIQUE,
    population BIGINT
);

INSERT INTO countries
(country, country_code, population)
VALUES
('India', 'IND', 1400000000),
('USA', 'USA', 340000000),
('UK', 'GBR', 68000000);

CREATE TABLE covid_cases (
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    confirmed_cases INT NOT NULL,
    deaths INT NOT NULL DEFAULT 0,
    recoveries INT NOT NULL DEFAULT 0,

    last_updated TIMESTAMP
        DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT pk_covid_cases
        PRIMARY KEY (country, report_date),

    CONSTRAINT fk_covid_country
        FOREIGN KEY (country)
        REFERENCES countries(country)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,

    CONSTRAINT chk_covid_numbers
        CHECK (
            confirmed_cases >= 0
            AND deaths >= 0
            AND recoveries >= 0
            AND deaths <= confirmed_cases
        )
);

INSERT INTO covid_cases
(country, report_date, confirmed_cases, deaths)
VALUES
('India', '2020-03-15', 100, 2);

SELECT * FROM countries;

SELECT * FROM covid_cases;
