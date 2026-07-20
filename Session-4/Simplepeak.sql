SELECT
    c.report_date,
    c.confirmed_cases,
    CASE
        WHEN c.confirmed_cases = (
            SELECT MAX(c2.confirmed_cases)
            FROM covid_cases c2
            WHERE c2.state = c.state
              AND c2.report_date <= c.report_date
        )
        THEN 'Highest So Far'
        ELSE 'Not Highest'
    END AS peak_status
FROM covid_cases c
WHERE c.state = 'Mumbai'
ORDER BY c.report_date;
