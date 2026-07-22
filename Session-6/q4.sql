START TRANSACTION;

INSERT INTO covid_vaccines (
    Country,
    `Date`,
    Doses_Distributed,
    Doses_Administered
)
VALUES (
    'India',
    '2026-07-20',
    100000,
    75000
);

INSERT INTO vaccine_audit_log (
    Country,
    Distribution_Date,
    Doses_Distributed,
    Doses_Administered
)
VALUES (
    'India',
    '2026-07-20',
    100000,
    75000
);

COMMIT;
