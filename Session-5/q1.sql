covid_cases (
    Country VARCHAR(100),
    `Date` DATE,
    Confirmed_Cases INT,
    Deaths INT,
    Recoveries INT,
    Population BIGINT,
    PRIMARY KEY (Country, `Date`)
);
