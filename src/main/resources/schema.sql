CREATE  TABLE IF NOT EXISTS  Doc_codes (
            version  INTEGER NOT NULL        COMMENT 'Служебное поле hibernate',
            code     INTEGER NOT NULL        COMMENT 'Код документа' ,
            name     VARCHAR(50) NOT NULL    COMMENT 'Тип документа'
);
COMMENT ON TABLE Doc_codes IS 'Список документов';

CREATE  TABLE IF NOT EXISTS  Country_codes (
            code     INTEGER NOT NULL          COMMENT 'Код страны' ,
            version  INTEGER NOT NULL          COMMENT 'Служебное поле hibernate',
            name     VARCHAR(50) NOT NULL      COMMENT 'Название страны'
);
COMMENT ON TABLE Country_codes IS 'Таблица кодов стран';

CREATE TABLE IF NOT EXISTS Organisation (
            id         INTEGER              COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
            version    INTEGER NOT NULL     COMMENT 'Служебное поле hibernate',
            full_name  VARCHAR(50) NOT NULL COMMENT 'Полное название',
            inn        VARCHAR(12) NOT NULL COMMENT 'ИНН',
            kpp        VARCHAR(9)  NOT NULL COMMENT 'КПП',
);
COMMENT ON TABLE Organisation IS 'Организация';

CREATE TABLE IF NOT EXISTS Office (
            id         INTEGER              COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
            version    INTEGER NOT NULL     COMMENT 'Служебное поле hibernate',
            name       VARCHAR(50) NOT NULL COMMENT 'Название офиса',
            phone      VARCHAR(50)          COMMENT 'Номер телефона',
            address    VARCHAR(50) NOT NULL COMMENT 'Адрес офиса',
            is_active  BOOLEAN              COMMENT 'Активность офиса',
            is_head    BOOLEAN              COMMENT 'Главный офис?',
);
COMMENT ON TABLE Office IS 'Офис';

CREATE TABLE IF NOT EXISTS Organisation_Office (
           version      INTEGER  NOT NULL    COMMENT 'Служебное поле hibernate',
           org_id       INTEGER  NOT NULL    COMMENT 'Уникальный идентификатор организации',
           office_id    INTEGER  NOT NULL    COMMENT 'Уникальный идентификатор офиса',

           PRIMARY KEY (org_id, office_id)
);

COMMENT ON TABLE Organisation_Office IS 'join-таблица для связи офиса и организации';

CREATE INDEX IX_Organisation_Office_Id ON Organisation_Office (org_id);
ALTER TABLE Organisation_Office ADD FOREIGN KEY (org_id) REFERENCES Organisation(id);

CREATE INDEX IX_Office_Organisation_Id ON Organisation_Office (office_id);
ALTER TABLE Organisation_Office ADD FOREIGN KEY (office_id) REFERENCES Office(id);

CREATE TABLE IF NOT EXISTS Document (
            id            LONG NOT NULL        COMMENT 'Уникальный идентификатор' PRIMARY KEY ,
            version       INTEGER NOT NULL     COMMENT 'Служебное поле hibernate',
            code          INTEGER              COMMENT 'Код документа из таблицы' ,
            number        VARCHAR(50)          COMMENT 'Номер документа',
            date          VARCHAR(50)          COMMENT 'Дата выдачи',
            name          VARCHAR(50)          COMMENT 'Имя документа',
            is_identified BOOLEAN              COMMENT 'Документ подтвержден',

FOREIGN KEY (code) REFERENCES Doc_codes(code),
);
COMMENT ON TABLE Document IS 'Документ';
CREATE INDEX IX_DOCUMENT_DOC_CODE on Document(code);


CREATE TABLE IF NOT EXISTS User (
            id                LONG NOT NULL        COMMENT 'Уникальный идентификатор' PRIMARY KEY ,
            version           INTEGER NOT NULL     COMMENT 'Служебное поле hibernate',
            first_name        VARCHAR(50) NOT NULL COMMENT 'Имя',
            second_name       VARCHAR(50)          COMMENT 'Фамилия',
            middle_name       VARCHAR(50)          COMMENT 'Второе имя',
            position          VARCHAR(50) NOT NULL COMMENT 'Должность',
            phone             VARCHAR(50)          COMMENT 'Номер телефона',
            doc_id            INTEGER              COMMENT 'id документа из таблицы Document',
            citizenship_code  INTEGER              COMMENT 'Код страны гражданства',
            office_id         INTEGER              COMMENT 'id офиса работы',

  FOREIGN KEY (doc_id) REFERENCES Document(id),
  FOREIGN KEY (office_id) REFERENCES Office(id),
  FOREIGN KEY (citizenship_code) REFERENCES Country_codes(code)
  );
COMMENT ON TABLE User IS 'Человек';
CREATE INDEX IX_USER_DOC_ID on User(doc_id);
CREATE INDEX IX_USER_OFFICE_ID on User(office_id);
CREATE INDEX IX_USER_CIT_CODE on User(citizenship_code);

