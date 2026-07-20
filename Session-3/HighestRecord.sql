SELECT 
    c.country,
    cc.confirmed_cases,
    cc.report_date
FROM covid_cases cc
INNER JOIN countries c
ON cc.country = c.country
WHERE cc.report_date = '2020-03-15'
ORDER BY cc.confirmed_cases DESC
LIMIT 1;
