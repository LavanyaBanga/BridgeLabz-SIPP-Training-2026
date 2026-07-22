CREATE VIEW LatestCovidData AS
SELECT
    c.Country,
    c.`Date`,
    c.Confirmed_Cases,
    c.Deaths,
    c.Recoveries
FROM covid_cases AS c
INNER JOIN (
    SELECT
        Country,
        MAX(`Date`) AS Latest_Date
    FROM covid_cases
    GROUP BY Country
) AS latest
    ON c.Country = latest.Country
    AND c.`Date` = latest.Latest_Date;
