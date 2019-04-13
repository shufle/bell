/*
INSERTING MOCK DATA INTO Country_codes
 */

INSERT INTO Country_codes (version, name, code)
VALUES (0,'США', '840');
INSERT INTO Country_codes (version, name, code)
VALUES (0,'Чехия', '203');
INSERT INTO Country_codes (version, name, code)
VALUES (0,'Россия', '643');
INSERT INTO Country_codes (version, name, code)
VALUES (0, 'Венгрия', '348') ;

/*
INSERTING MOCK DATA INTO Doc_codes
 */

INSERT INTO Doc_codes (version, name, code)
VALUES (0,'Паспорт гражданина Российской Федерации', '21');
INSERT INTO Doc_codes (version, name, code)
VALUES (0,'Паспорт иностранного гражданина', '10');
INSERT INTO Doc_codes (version, name, code)
VALUES (0,'Военный билет', '07');
INSERT INTO Doc_codes (version, name, code)
VALUES (0, 'Вид на жительство в РФ', '12');
INSERT INTO Doc_codes (version, name, code)
VALUES (0, 'Иные документы', '91');

/*
INSERTING MOCK DATA INTO Organisation
 */

INSERT INTO Organisation (version, full_name, inn, kpp)
VALUES (0, 'yandex','123456789123','87654321'),
       (0, 'sberbank','876456789123','97654321'),
       (0, 'acme','132456789123','87654344'),
       (0, 'romashka','432156789123','87444321'),
       (0, 'ooo roga i kopyta','9999999999','58654321');

/*
INSERTING MOCK DATA INTO Office
 */

INSERT INTO Office (version, name, phone, address, is_active, is_head)
VALUES (0, 'Yandex-Moscow', '495495495', 'ul Lva Tolstogo 16',TRUE,TRUE),
       (0, 'Yandex-Sbp', '995495495', 'Tolstogo 17',TRUE,FALSE),
       (0, 'romashka', '123444555', 'pobedy 44', FALSE,TRUE),
       (0, 'biznes-centr Dom', '33333333', 'moskovskaya 22',TRUE, TRUE ),
       (0, 'sberbank-moscow', '55555555533', 'frunze 2',TRUE, TRUE);

/*
INSERTING MOCK DATA INTO Document and USER
 */
CREATE SEQUENCE DOC_USER_SEQ START WITH 1 INCREMENT BY 1;

INSERT INTO Document (id, version, code, number, date, name, is_identified)
VALUES (nextval('DOC_USER_SEQ') ,0, '21', '4444 444444', '30.04.1999', 'Паспорт гражданина Российской Федерации', TRUE),
       (nextval('DOC_USER_SEQ') ,0, '91', '666', NULL , 'Межгалактическое ID', FALSE),
       (nextval('DOC_USER_SEQ') ,0, '91', NULL , NULL , 'Записка от мамы', FALSE),
       (nextval('DOC_USER_SEQ') ,0, '07', '666', '22.22.1989' , 'Военный билет', TRUE),
       (nextval('DOC_USER_SEQ') ,0, '10', '64546', '10/10/2010' , 'Паспорт иностранного гражданина', TRUE),
       (nextval('DOC_USER_SEQ') ,0, '12', '64546', '10/10/2010' , 'Вид на жительство в РФ', TRUE);

ALTER SEQUENCE DOC_USER_SEQ RESTART WITH 1;

INSERT INTO User (id, version, first_name, second_name, middle_name, position, phone, doc_id, citizenship_code, office_id)
VALUES (nextval('DOC_USER_SEQ'),0,'Ivan', 'Ivanov', 'Ivanovich', 'dvornik', NULL, currval('DOC_USER_SEQ'), '643',
       SELECT id FROM Office WHERE name = 'romashka'),
       (nextval('DOC_USER_SEQ'),0,'Ivan', NULL, 'Haritonych', 'CEO', NULL, currval('DOC_USER_SEQ'), '643',
       SELECT id FROM Office WHERE name = 'biznes-centr Dom'),
       (nextval('DOC_USER_SEQ'),0,'John', 'Smith', 'The Terminator', 'developer', NULL, currval('DOC_USER_SEQ'), '840',
       SELECT id FROM Office WHERE name = 'biznes-centr Dom'),
       (nextval('DOC_USER_SEQ'),0,'Petr', 'Bzich', NULL, 'operator', '+456-65-44', currval('DOC_USER_SEQ'), '203',
       SELECT id FROM Office WHERE name = 'Yandex-Sbp'),
       (nextval('DOC_USER_SEQ'),0,'Leonid', 'Smirnov', 'Alexeevich', 'Director', NULL, currval('DOC_USER_SEQ'), '643',
       SELECT id FROM Office WHERE name = 'sberbank-moscow'),
       (nextval('DOC_USER_SEQ'),0,'Georgiy', 'Smirnov', 'Vladimirovich', 'Director', NULL, currval('DOC_USER_SEQ'), '643',
       SELECT id FROM Office WHERE name = 'Yandex-Moscow');

/*
INSERTING MOCK DATA INTO Organisation_Office join table
 */

INSERT INTO Organisation_Office (version, org_id, office_id)
VALUES (0,SELECT id FROM Organisation WHERE full_name = 'yandex', SELECT id FROM Office WHERE name = 'Yandex-Moscow' ),
       (0,SELECT id FROM Organisation WHERE full_name = 'yandex', SELECT id FROM Office WHERE name = 'Yandex-Sbp'),
       (0,SELECT id FROM Organisation WHERE full_name = 'acme', SELECT id FROM Office WHERE name = 'biznes-centr Dom'),
       (0,SELECT id FROM Organisation WHERE full_name = 'romashka', SELECT id FROM Office WHERE name = 'biznes-centr Dom'),
       (0,SELECT id FROM Organisation WHERE full_name = 'ooo roga i kopyta', SELECT id FROM Office WHERE name = 'biznes-centr Dom'),
       (0,SELECT id FROM Organisation WHERE full_name = 'sberbank', SELECT id FROM Office WHERE name = 'sberbank-moscow');