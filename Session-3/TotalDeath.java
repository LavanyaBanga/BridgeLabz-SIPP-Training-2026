SELECT 
    con.continent_name,
    SUM(cc.deaths) AS total_deaths
FROM covid_cases cc
INNER JOIN countries c
ON cc.country = c.country
INNER JOIN continents con
ON c.continent_id = con.continent_id
GROUP BY con.continent_name
ORDER BY total_deaths DESC;
