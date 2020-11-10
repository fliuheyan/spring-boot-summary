create sequence company_generator start 1;

create sequence employee_generator start 1;

CREATE TABLE company
(
    id           bigint      NOT NULL DEFAULT nextval('company_generator') PRIMARY KEY,
    company_name VARCHAR(30) NOT NULL
);

CREATE TABLE employee
(
    id         bigint      NOT NULL DEFAULT nextval('employee_generator') PRIMARY KEY,
    name       VARCHAR(30) NOT NULL,
    age        bigint,
    salary     bigint,
    gender     VARCHAR(10),
    company_id bigint,
    FOREIGN KEY (company_id) REFERENCES company (id)
);
