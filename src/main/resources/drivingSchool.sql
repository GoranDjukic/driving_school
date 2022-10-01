DROP SCHEMA IF EXISTS drivingSchool;
CREATE SCHEMA drivingSchool DEFAULT CHARACTER SET utf8;
USE drivingSchool;

CREATE TABLE `user` (
    user_id BIGINT AUTO_INCREMENT NOT NULL,
    username VARCHAR (255) NOT NULL,
    password VARCHAR (255) NOT NULL,
    role ENUM ("ADMIN", "USER") NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE `driving_school` (
    driving_school_id BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR (255) NOT NULL UNIQUE,
    year_of_est INT NOT NULL,
    number_of_vehicle INT,
    PRIMARY KEY (driving_school_id)
);

CREATE TABLE `trainee` (
    trainee_id BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR (255) NOT NULL,
    surname VARCHAR (255) NOT NULL,
    birth_year INT NOT NULL,
    place VARCHAR(255) NOT NULL,
    listened_theory TINYINT NOT NULL,
    driving_done TINYINT,
    passed_exam TINYINT,
    driving_school_id BIGINT,
    PRIMARY KEY (trainee_id),
    FOREIGN KEY (driving_school_id) REFERENCES driving_school(driving_school_id)
    		ON DELETE RESTRICT
);

CREATE TABLE `exam` (
    exam_id BIGINT AUTO_INCREMENT NOT NULL,
    number_of_seats INT NOT NULL,
    date_of_exam DATE NOT NULL,
    driving_school_id BIGINT,
    PRIMARY KEY (exam_id),
    FOREIGN KEY (driving_school_id) REFERENCES driving_school(driving_school_id)
        		ON DELETE RESTRICT
);


INSERT INTO `user` (user_id, username, password, role)
    VALUES (1, 'miroslav', '$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6', 'ADMIN' );
INSERT INTO `user` (user_id,username, password, role)
    VALUES (2, 'tamara', '$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky', 'USER');
INSERT INTO `user` (user_id,username, password, role)
    VALUES (3, 'petar', '$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC', 'USER');
    
    
INSERT INTO `driving_school` (driving_school_id, name, year_of_est, number_of_vehicle)
    VALUES (1, 'As', 1991, 10);
INSERT INTO `driving_school` (driving_school_id, name, year_of_est, number_of_vehicle)
    VALUES (2, 'Pink', 1992, 20);
INSERT INTO `driving_school` (driving_school_id, name, year_of_est, number_of_vehicle)
    VALUES (3, 'King', 1993, 30);


INSERT INTO `trainee` (trainee_id, name, surname, birth_year, place, listened_theory, driving_done, passed_exam, driving_school_id)
    VALUES (1, 'Marko', 'Markovic', 2001, 'Novi Sad', false, false, false, 1);
INSERT INTO `trainee` (trainee_id, name, surname, birth_year, place, listened_theory, driving_done, passed_exam, driving_school_id)
    VALUES (2, 'Milos', 'Milosevic', 2002, 'Beograd', false, false, false, 2);
INSERT INTO `trainee` (trainee_id, name, surname, birth_year, place, listened_theory, driving_done, passed_exam, driving_school_id)
    VALUES (3, 'Nenad', 'Nenadovic', 2003, 'Valjevo', false, false, false, 3);


INSERT INTO `exam` (exam_id, number_of_seats, date_of_exam, driving_school_id)
    VALUES (1, 10,'2023-01-01', 1);
INSERT INTO `exam` (exam_id, number_of_seats, date_of_exam, driving_school_id)
    VALUES (2, 20, '2023-02-02', 2);
INSERT INTO `exam` (exam_id, number_of_seats, date_of_exam, driving_school_id)
    VALUES (3, 30, '2023-03-03', 3);