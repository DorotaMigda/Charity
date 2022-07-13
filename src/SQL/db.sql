CREATE DATABASE charity-donation CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

INSERT INTO institution (description, name) VALUES ('Cel i misja: Pomoc dzieciom z ubogich rodzin', 'Fundacja "Dbam o Zdrowie');
INSERT INTO institution (description, name) VALUES ('Cel i misja: Pomoc wybudzaniu dzieci ze śpiączki.', 'Fundacja "A kogo"');
INSERT INTO institution (description, name) VALUES ('Cel i misja: Pomoc osobom znajdującym się w trudnej sytuacji życiowej', 'Fundacja “Dla dzieci"');
INSERT INTO institution (description, name) VALUES ('Cel i misja: Pomoc dla osób nie posiadających miejsca zamieszkania', 'Fundacja “Bez domu”');
INSERT INTO institution (description, name) VALUES ('Cel i misja: Pomoc dla osób w trudnej sytuacji', 'PCK');
INSERT INTO institution (description, name) VALUES ('Cel i misja: Działanie na rzecz poprawy stanu zdrowia dzieci, działanie na rzecz promocji zdrowia i profilaktyki zdrowotnej.', 'Wielka Orkiestra Świątecznej Pomocy');

Wybrane dane z tabeli, przykładowe usunięcie:
DELETE FROM ........ WHERE name = "........";

Wszystkie dane z tabeli usunięcie:
DELETE FROM table_name;

INSERT INTO donation (quantity,street,city,zip_code,pick_up_date,pick_up_time,pick_up_comment,institution_id) VALUES (7,'Malwowa','Warszawa','31-445','2022-07-30', '11:22', 'przykładowy komentarz',1);
INSERT INTO donation (quantity,street,city,zip_code,pick_up_date,pick_up_time,pick_up_comment,institution_id) VALUES (3,'Niebieska','Kraków','31-122','2022-07-25', '11:00', 'przykładowy komentarz',1);

INSERT INTO category (name) VALUES ('ubrania');
INSERT INTO category (name) VALUES ('zabawki');
INSERT INTO category (name) VALUES ('sprzęt');
INSERT INTO category (name) VALUES ('inne');

