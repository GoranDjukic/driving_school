START TRANSACTION;

CREATE TABLE `user` (
    id BIGINT AUTO_INCREMENT NOT NULL,
    username VARCHAR (255) NOT NULL UNIQUE,
    password VARCHAR (255) NOT NULL,
    role ENUM ("ADMIN", "USER") NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE `driving_school` (
    id BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR (255) NOT NULL UNIQUE,
    year_of_est INT NOT NULL,
    number_of_vehicles INT,
    PRIMARY KEY (id)
);

CREATE TABLE `trainee` (
    id BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR (255) NOT NULL,
    surname VARCHAR (255) NOT NULL,
    birth_year INT NOT NULL,
    place VARCHAR(255) NOT NULL,
    listened_theory BIT(1) DEFAULT false,
    driving_done BIT(1) DEFAULT false,
    passed_exam BIT(1) DEFAULT false,
    driving_school_id BIGINT,
    PRIMARY KEY (id)
);

ALTER TABLE trainee
ADD CONSTRAINT FK_trainee_driving_school_id
    FOREIGN KEY (driving_school_id) REFERENCES driving_school(id);

CREATE TABLE `exam` (
    id BIGINT AUTO_INCREMENT NOT NULL,
    number_of_seats INT NOT NULL,
    `date` DATE NOT NULL,
    driving_school_id BIGINT,
    PRIMARY KEY (id)
);

ALTER TABLE exam
ADD CONSTRAINT FK_exam_driving_school_id
FOREIGN KEY (driving_school_id) REFERENCES driving_school(id);

COMMIT;