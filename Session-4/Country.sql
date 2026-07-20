SELECT country, SUM(deaths) AS total_deaths
FROM covid_deaths
GROUP BY country
HAVING SUM(deaths) > (
    SELECT AVG(country_deaths)
    FROM (
        SELECT SUM(deaths) AS country_deaths
        FROM covid_deaths
        GROUP BY country
    ) AS death_summary
);
