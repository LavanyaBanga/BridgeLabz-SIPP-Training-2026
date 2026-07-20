CREATE TABLE covid_cases (
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    confirmed_cases INT NOT NULL,
    deaths INT NOT NULL DEFAULT 0,
    recoveries INT NOT NULL DEFAULT 0,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT pk_covid_cases
        PRIMARY KEY (country, report_date),

    CONSTRAINT fk_covid_country
        FOREIGN KEY (country)
        REFERENCES countries(country),

    CONSTRAINT chk_deaths
        CHECK (deaths <= confirmed_cases)
);
