

CREATE PROCEDURE UpdateCovidStats(
    IN p_country VARCHAR(100),
    IN p_date DATE,
    IN p_confirmed_cases INT,
    IN p_deaths INT,
    IN p_recoveries INT
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        RESIGNAL;
    END;

    IF p_confirmed_cases < 0
       OR p_deaths < 0
       OR p_recoveries < 0 THEN

        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'COVID statistics cannot be negative';

    ELSEIF p_deaths > p_confirmed_cases THEN

        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Deaths cannot exceed confirmed cases';

    ELSEIF p_recoveries > p_confirmed_cases THEN

        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Recoveries cannot exceed confirmed cases';

    ELSE
        START TRANSACTION;

        UPDATE covid_cases
        SET
            Confirmed_Cases = p_confirmed_cases,
            Deaths = p_deaths,
            Recoveries = p_recoveries
        WHERE Country = p_country
          AND `Date` = p_date;

        IF ROW_COUNT() = 0 THEN
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'COVID record not found';
        END IF;

        COMMIT;
    END IF;
END 

DELIMITER ;
