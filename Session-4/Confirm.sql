SELECT country
FROM covid_cases
GROUP BY country
HAVING MAX(confirmed_cases) > 1000000
