SELECT
    c.report_date,
    c.confirmed_cases,

    CASE
        WHEN c.confirmed_cases >
            COALESCE(
                (
                    SELECT previous_day.confirmed_cases
                    FROM covid_cases previous_day
                    WHERE previous_day.state = c.state
                      AND previous_day.report_date < c.report_date
                    ORDER BY previous_day.report_date DESC
                    LIMIT 1
                ),
                -1
            )

        AND c.confirmed_cases >=
            COALESCE(
                (
                    SELECT next_day.confirmed_cases
                    FROM covid_cases next_day
                    WHERE next_day.state = c.state
                      AND next_day.report_date > c.report_date
                    ORDER BY next_day.report_date
                    LIMIT 1
                ),
                -1
            )

        THEN 'Peak'
        ELSE 'Not Peak'
    END AS wave_status

FROM covid_cases c
WHERE c.state = 'Mumbai'
ORDER BY c.report_date;
