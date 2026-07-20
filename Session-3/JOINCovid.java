SELECT 
    d.country,
    d.report_date,
    d.deaths,
    v.vaccination_status
FROM covid_deaths d
LEFT JOIN covid_vaccines v
ON d.country = v.country
AND d.report_date = v.report_date;
