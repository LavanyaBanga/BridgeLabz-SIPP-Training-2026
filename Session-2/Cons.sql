CREATE TABLE countries (
    country VARCHAR(100) PRIMARY KEY,
    country_code VARCHAR(3) NOT NULL UNIQUE,
    population BIGINT
);
