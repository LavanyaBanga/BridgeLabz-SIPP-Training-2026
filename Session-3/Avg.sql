SELECT 
    report_date,
    AVG(deaths) AS average_deaths
FROM covid_deaths
GROUP BY report_date
ORDER BY report_date;
