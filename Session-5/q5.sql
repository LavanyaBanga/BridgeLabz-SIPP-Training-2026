CREATE TABLE covid_cases_audit (
    Audit_ID INT AUTO_INCREMENT PRIMARY KEY,

    Country VARCHAR(100),
    Record_Date DATE,

    Old_Confirmed_Cases INT,
    New_Confirmed_Cases INT,

    Old_Deaths INT,
    New_Deaths INT,

    Old_Recoveries INT,
    New_Recoveries INT,

    Changed_At TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Changed_By VARCHAR(100)
);
