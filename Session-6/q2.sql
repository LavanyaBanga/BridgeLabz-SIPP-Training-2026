START TRANSACTION;

INSERT INTO covid_vaccines (
    Country,
    `Date`,
    Doses_Distributed,
    Doses_Administered
)
VALUES (
    'PhantomCountry',
    '2026-07-22',
    10000,
    4000
);

COMMIT;
