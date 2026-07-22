

CREATE FUNCTION CalculateMortalityRate(
    p_country VARCHAR(100),
    p_date DATE
)
RETURNS DECIMAL(10, 2)
READS SQL DATA
BEGIN
    DECLARE mortality_rate DECIMAL(10, 2);

    SELECT
        ROUND(
            Deaths * 100.0 / NULLIF(Confirmed_Cases, 0),
            2
        )
    INTO mortality_rate
    FROM covid_cases
    WHERE Country = p_country
      AND `Date` = p_date
    LIMIT 1;

    RETURN mortality_rate;

DELIMITER ;
