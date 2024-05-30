CREATE SCHEMA IF NOT EXISTS "gamehub";

CREATE SCHEMA keycloak;

ALTER SCHEMA keycloak OWNER TO postgres;


CREATE TYPE gamehub.account_status AS ENUM (
    'ACTIVE',
    'INACTIVE',
    'SUSPENDED'
    );

CREATE TABLE gamehub.skill
(
    id         uuid PRIMARY KEY,
    skill_name VARCHAR(100) NOT NULL
);

CREATE TABLE gamehub.users
(
    id              uuid PRIMARY KEY,
    nickname        VARCHAR(30)            NOT NULL,
    email           VARCHAR(255)           NOT NULL UNIQUE,
    last_login_date TIMESTAMP WITH TIME ZONE,
    online          BOOLEAN                NOT NULL,
    account_status  gamehub.account_status NOT NULL DEFAULT 'ACTIVE'::gamehub.account_status
);

CREATE TABLE gamehub.user_skills
(
    user_id  uuid,
    skill_id uuid,
    PRIMARY KEY (user_id, skill_id),
    FOREIGN KEY (user_id) REFERENCES gamehub.users (id),
    FOREIGN KEY (skill_id) REFERENCES gamehub.skill (id)
);

INSERT INTO gamehub.users (id, nickname, email, last_login_date, online, "account_status")
VALUES ('54439de5-67c5-4f4f-9c08-23066ae0dd41'::uuid, 'user', 'user@mail.ru', NULL, FALSE,
        'ACTIVE'::gamehub.account_status);

CREATE TYPE gamehub.project_status AS ENUM (
    'NEW',
    'ACTIVE',
    'INACTIVE',
    'CANCELED'
    );

CREATE TABLE gamehub.project
(
    description VARCHAR(700)                         NOT NULL,
    id          uuid,
    name        VARCHAR(200)                         NOT NULL,
    status      gamehub.project_status DEFAULT 'NEW',
    start_date  timestamptz            DEFAULT NOW() NOT NULL,
    end_date    timestamptz,
    creator_id  uuid                                 NOT NULL,
    CONSTRAINT id
        PRIMARY KEY (id),
    CONSTRAINT project_users_id_fk
        FOREIGN KEY (creator_id) REFERENCES gamehub.users
            ON DELETE CASCADE
);

COMMENT ON TABLE gamehub.project IS 'Таблица содержит информацию о созданных проектах';

COMMENT ON COLUMN gamehub.project.description IS 'Краткое описание проекта';

COMMENT ON COLUMN gamehub.project.id IS 'ID проекта';

COMMENT ON COLUMN gamehub.project.name IS 'Наименование проекта';

COMMENT ON COLUMN gamehub.project.status IS 'Статус проекта';

COMMENT ON COLUMN gamehub.project.start_date IS 'Дата начала проекта';

COMMENT ON COLUMN gamehub.project.end_date IS 'Дата завершения проекта';

COMMENT ON COLUMN gamehub.project.creator_id IS 'Ссылка на пользователя, создавшего проект';

COMMENT ON CONSTRAINT id ON gamehub.project IS 'ID проекта';

CREATE INDEX project_creator_id_index
    ON gamehub.project (creator_id);

CREATE INDEX project_end_date_index
    ON gamehub.project (end_date);

CREATE INDEX project_end_date_start_date_index
    ON gamehub.project (end_date, start_date);

CREATE INDEX project_start_date_index
    ON gamehub.project (start_date);

INSERT INTO gamehub.users (id, nickname, email, online, account_status)
VALUES ('5d6c87f4-4eab-4f03-986e-914895fe94ab'::uuid, 'test', 'test@test.com', FALSE, 'ACTIVE'::gamehub.account_status);

alter table gamehub.project
    drop constraint project_users_id_fk;

ALTER TABLE gamehub.project
    ALTER COLUMN creator_id TYPE VARCHAR(255);

alter table gamehub.project
    add constraint project_user_entity_id_fk
        foreign key (creator_id) references keycloak.user_entity(id)
            on delete cascade;

alter table gamehub.project
    alter column start_date drop not null;

