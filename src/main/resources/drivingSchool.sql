start transaction;

INSERT INTO `user` (username, password, role)
    VALUES ('miroslav', '$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6', 'ADMIN' );
INSERT INTO `user` (username, password, role)
    VALUES ('tamara', '$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky', 'USER');
INSERT INTO `user` (username, password, role)
    VALUES ('petar', '$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC', 'USER');
    
    
INSERT INTO `driving_school` (name, year_of_est, number_of_vehicles)
    VALUES ('As', 1991, 10);
INSERT INTO `driving_school` (name, year_of_est, number_of_vehicles)
    VALUES ('Pink', 1992, 20);
INSERT INTO `driving_school` (name, year_of_est, number_of_vehicles)
    VALUES ('King', 1993, 30);


INSERT INTO `trainee` (name, surname, birth_year, place, listened_theory, driving_done, passed_exam, driving_school_id)
    VALUES ('Marko', 'Markovic', 2001, 'Novi Sad', false, false, false, 1);
INSERT INTO `trainee` (name, surname, birth_year, place, listened_theory, driving_done, passed_exam, driving_school_id)
    VALUES ('Milos', 'Milosevic', 2002, 'Beograd', false, false, false, 2);
INSERT INTO `trainee` (name, surname, birth_year, place, listened_theory, driving_done, passed_exam, driving_school_id)
    VALUES ('Nenad', 'Nenadovic', 2003, 'Valjevo', false, false, false, 3);


INSERT INTO `exam` (number_of_seats, date_of_exam, driving_school_id)
    VALUES (10,'2023-01-01', 1);
INSERT INTO `exam` (number_of_seats, date_of_exam, driving_school_id)
    VALUES (20, '2023-02-02', 2);
INSERT INTO `exam` (number_of_seats, date_of_exam, driving_school_id)
    VALUES (30, '2023-03-03', 3);

commit;