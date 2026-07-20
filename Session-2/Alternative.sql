CREATE TABLE covid_cases_alternative (
    id INT PRIMARY KEY AUTO_INCREMENT,
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    confirmed_cases INT NOT NULL,
    deaths INT NOT NULL DEFAULT 0,
    recoveries INT NOT NULL DEFAULT 0,
    last_updated TIMESTAMP
        DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT uq_country_date
        UNIQUE (country, report_date),

    CONSTRAINT fk_alternative_country
        FOREIGN KEY (country)
        REFERENCES countries(country),

    CONSTRAINT chk_alternative_deaths
        CHECK (
            deaths >= 0
            AND confirmed_cases >= 0
            AND deaths <= confirmed_cases
        )
);
