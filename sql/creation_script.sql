CREATE TABLE LOCATION (
    id          BIGSERIAL PRIMARY KEY,
    latitude    REAL NOT NULL,
    longitude   REAL NOT NULL
);

create unique index LOCATION_UINDEX on LOCATION (id);

CREATE TABLE CITY (
    id      SERIAL PRIMARY KEY,
    name    VARCHAR(32) NOT NULL UNIQUE
);

create unique index CITY_UINDEX on CITY (id);

CREATE TABLE SPOT_ACTIVITY (
    id              BIGSERIAL PRIMARY KEY,
    people_visited  BIGINT NOT NULL,
    activity        VARCHAR(32) NOT NULL
);

create unique index SPOT_ACTIVITY_UINDEX on SPOT_ACTIVITY (id);

CREATE TABLE SPOT (
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(32) NOT NULL UNIQUE,
    description VARCHAR(256) NOT NULL,
    update_date DATE NOT NULL,
    activity_id BIGINT REFERENCES SPOT_ACTIVITY (id),
    location_id BIGINT REFERENCES LOCATION (id)
);

CREATE TABLE ROLE (
    id          SERIAL PRIMARY KEY,
    type        VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE SPORT (
    id                  SERIAL PRIMARY KEY,
    kind                VARCHAR(32) NOT NULL UNIQUE,
    description         VARCHAR(1024),
    amount_of_riders    BIGINT NOT NULL
);

CREATE TABLE USERS (
    id              BIGSERIAL PRIMARY KEY,
    email           VARCHAR(32) NOT NULL UNIQUE,
    username        VARCHAR(32) NOT NULL UNIQUE,
    password        VARCHAR(256) NOT NULL,
    home_spot_id    BIGINT REFERENCES SPOT (id),
    role_id         BIGINT REFERENCES ROLE (id),
    sport_id        BIGINT REFERENCES SPORT (id),
    creation_date   DATE NOT NULL
);

create unique index USERS_UINDEX on USERS (id);

CREATE TABLE VIDEO (
    id              BIGSERIAL PRIMARY KEY,
    path            VARCHAR(1024) NOT NULL UNIQUE,
    tag             VARCHAR(128),
    author_id       BIGINT REFERENCES USERS (id),
    creation_date   DATE NOT NULL
);

create unique index VIDEO_UINDEX on VIDEO (id);

CREATE TABLE TRICK (
    id              SERIAL PRIMARY KEY,
    name            VARCHAR(32) NOT NULL UNIQUE,
    description     VARCHAR(1024) NOT NULL,
    how_to          VARCHAR(1024),
    complexity      VARCHAR(32),
    people_studied  INTEGER NOT NULL,
    video_id        BIGINT REFERENCES VIDEO (id)
);

create unique index TRICK_UINDEX on TRICK (id);

CREATE TABLE PROGRESS (
    trick_id        BIGINT REFERENCES TRICK (id),
    user_id         BIGINT REFERENCES USERS (id),
    trick_status    VARCHAR(32) NOT NULL
);

create unique index SPOT_UINDEX on SPOT (id);

CREATE TABLE OBJECT (
    id      SERIAL PRIMARY KEY,
    name    VARCHAR(32) NOT NULL UNIQUE
);

create unique index OBJECT_UINDEX on OBJECT (id);

CREATE TABLE PHOTO (
    id              BIGINT PRIMARY KEY,
    path            VARCHAR(256) NOT NULL,
    tag             VARCHAR(128),
    author_id       BIGINT REFERENCES USERS (id),
    creation_date   DATE NOT NULL
);

create unique index PHOTO_UINDEX on PHOTO (id);

CREATE TABLE COMMENT (
    id              BIGSERIAL PRIMARY KEY,
    text            VARCHAR(1024) NOT NULL,
    author_id       BIGINT REFERENCES USERS (id),
    creation_date   DATE NOT NULL
);

create unique index COMMENT_UINDEX on COMMENT (id);

CREATE TABLE TRICK_COMMENTS (
    trick_id    INTEGER REFERENCES TRICK (id),
    comment_id  BIGINT REFERENCES COMMENT (id)
);

CREATE TABLE SPORT_TRICKS (
    sport_id SERIAL REFERENCES SPORT (id),
    trick_id SERIAL REFERENCES TRICK (id)
);

CREATE TABLE SPOT_COMMENTS (
    spot_id     BIGINT REFERENCES SPOT (id),
    comment_id  BIGINT REFERENCES COMMENT(id)
);

CREATE TABLE SPOT_VIDEOS (
    spot_id     BIGINT REFERENCES SPOT (id),
    comment_id  BIGINT REFERENCES COMMENT(id)
);

CREATE TABLE SPOT_OBJECTS (
    spot_id     BIGINT REFERENCES SPOT (id),
    object_id   INTEGER REFERENCES OBJECT (id)
);

CREATE TABLE SPOT_SPORT (
    spot_id     BIGINT REFERENCES SPOT (id),
    sport_id    INTEGER REFERENCES SPORT (id)
);

CREATE TABLE HOME_SPOT (
    user_id     BIGINT REFERENCES USERS (id),
    spot_id     BIGINT REFERENCES SPOT (id)
);

CREATE TABLE SPOTS_OF_CITY (
    city_id INTEGER REFERENCES CITY (id),
    spot_id BIGINT REFERENCES SPOT (id)
);

CREATE TABLE SPOT_PHOTOS (
    spot_id     BIGSERIAL REFERENCES SPOT (id),
    photo_id    BIGSERIAL REFERENCES PHOTO (id)
);