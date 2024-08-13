USE WANTED;

CREATE TABLE company
(
    company_id   INT PRIMARY KEY AUTO_INCREMENT,
    company_name VARCHAR(200) NOT NULL
);

CREATE TABLE recruit_notice
(
    recruit_id INT PRIMARY KEY AUTO_INCREMENT,
    company_id INT           NOT NULL,
    position   VARCHAR(100)  NOT NULL,
    salary     INT           NOT NULL,
    content    VARCHAR(3000) NOT NULL,
    tech_stack VARCHAR(100)  NOT NULL,
    country    VARCHAR(100)  NOT NULL,
    region     VARCHAR(200)  NOT NULL,
    created_at DATETIME      NOT NULL DEFAULT NOW(),
    FOREIGN KEY (company_id) REFERENCES company (company_id)
);

CREATE TABLE job_seeker
(
    job_seeker_id INT PRIMARY KEY AUTO_INCREMENT,
    recruit_id    INT NULL UNIQUE,
    FOREIGN KEY (recruit_id) REFERENCES recruit_notice (recruit_id)
);

INSERT INTO company(company_id, company_name)
VALUES (1, '원티드랩');

INSERT INTO company(company_id, company_name)
VALUES (4, '카카오');

SELECT *
FROM company;

SELECT *
FROM job_seeker;