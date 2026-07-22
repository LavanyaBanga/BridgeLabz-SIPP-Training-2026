SELECT
    c.Country,
    c.`Date`,
    c.Confirmed_Cases,
    d.Deaths,
    v.Doses_Administered
FROM covid_cases c
INNER JOIN covid_deaths d
    ON c.Country = d.Country
   AND c.`Date` = d.`Date`
LEFT JOIN covid_vaccines v
    ON c.Country = v.Country
   AND c.`Date` = v.`Date`
WHERE c.Country = 'India'
  AND c.`Date` BETWEEN '2026-07-01' AND '2026-07-20';
