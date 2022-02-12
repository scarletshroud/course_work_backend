DROP FUNCTION get_user(BIGINT);
CREATE OR REPLACE FUNCTION get_user(user_id BIGINT)
RETURNS TABLE (
    id              BIGINT,
    email           VARCHAR(32),
    username        VARCHAR(32),
    password        VARCHAR(32),
    home_spot_id    BIGINT,
    role_id         BIGINT,
    creation_date   DATE
)
AS
$$
BEGIN
    RETURN query SELECT * FROM users WHERE users.id = user_id;
END;
$$ LANGUAGE plpgsql;


DROP FUNCTION get_sport(INTEGER);
CREATE OR REPLACE FUNCTION get_sport(sport_id BIGINT)
RETURNS TABLE (
    id                  BIGINT,
    kind                VARCHAR(32),
    description         VARCHAR(1024),
    amount_of_riders    BIGINT
)
AS
$$
BEGIN
    RETURN query SELECT * FROM sport WHERE sport.id = sport_id;
END;
$$ LANGUAGE plpgsql;


DROP FUNCTION get_trick(INTEGER);
CREATE OR REPLACE FUNCTION get_trick(trick_id BIGINT)
RETURNS TABLE (
    id              BIGINT,
    name            VARCHAR(32),
    description     VARCHAR(1024),
    how_to          VARCHAR(1024),
    complexity      VARCHAR(32),
    people_studied  INTEGER,
    video_id        BIGINT
)
AS
$$
BEGIN
    RETURN query SELECT * FROM trick WHERE trick.id = trick_id;
END;
$$ LANGUAGE plpgsql;


-------------------------------- UPDATE FUNCTIONS ------------------------------
DROP FUNCTION update_user(BIGINT, VARCHAR(32), VARCHAR(32), VARCHAR(32), BIGINT, DATE);
CREATE OR REPLACE FUNCTION update_user(_id BIGINT, _email VARCHAR(32), _username VARCHAR(32), _password VARCHAR(32), _home_spot_id BIGINT, _creation_date DATE)
RETURNS VOID AS
$$
BEGIN
    UPDATE users SET email = _email, username = _username, password = _password, home_spot_id = _home_spot_id, creation_date = _creation_date
        WHERE users.id = _id;
END;
$$ LANGUAGE plpgsql;


DROP FUNCTION update_spot(BIGINT, VARCHAR(32), VARCHAR(256), DATE, BIGINT, BIGINT);
CREATE OR REPLACE FUNCTION update_spot(_id BIGINT, _name VARCHAR(32), _description VARCHAR(256), _update_date DATE, _activity_id BIGINT, _location_id BIGINT)
RETURNS VOID AS
$$
BEGIN
    UPDATE spot SET name = _name, description = _description, update_date = _update_date, activity_id = _activity_id, location_id = _location_id
        WHERE spot.id = _id;
END;
$$ LANGUAGE plpgsql;


DROP FUNCTION update_comment(BIGINT, VARCHAR(1024));
CREATE OR REPLACE FUNCTION update_comment(_id BIGINT, _text VARCHAR(1024))
RETURNS VOID AS
$$
BEGIN
    UPDATE comment SET text = _text WHERE comment.id = _id;
END;
$$ LANGUAGE plpgsql;


---------------------------- INSERT FUNCTIONS --------------------------------
DROP FUNCTION insert_user(VARCHAR(32), VARCHAR(32), VARCHAR(32), BIGINT, BIGINT, DATE);
CREATE OR REPLACE FUNCTION insert_user(_email VARCHAR(32), _username VARCHAR(32), _password VARCHAR(32), _home_spot_id BIGINT, _role_id BIGINT, _creation_date DATE)
RETURNS VOID AS
$$
BEGIN
    INSERT INTO users (email, username, password, home_spot_id, role_id, creation_date) values (_email, _username, _password,
        _home_spot_id, _role_id, _creation_date);
END;
$$ LANGUAGE plpgsql;


DROP FUNCTION insert_comment(VARCHAR(1024), BIGINT, DATE);
CREATE OR REPLACE FUNCTION insert_user(_text VARCHAR(1024), _author_id BIGINT, _creation_date DATE)
RETURNS VOID AS
$$
BEGIN
    INSERT INTO comment (text, author_id, creation_date) values (_text, _author_id, _creation_date);
END;
$$ LANGUAGE plpgsql;


DROP FUNCTION insert_spot(VARCHAR(32), VARCHAR(256), DATE, BIGINT, BIGINT);
CREATE OR REPLACE FUNCTION insert_user(_name VARCHAR(32), _description VARCHAR(256), _update_date DATE, _activity_id BIGINT, _location_id BIGINT)
RETURNS VOID AS
$$
BEGIN
    INSERT INTO spot (name, description, update_date, activity_id, location_id)
        VALUES (_name, _description, _update_date, _activity_id, _location_id);
END;
$$ LANGUAGE plpgsql;

---------------------------- GET BY TYPE -----------------------------
DROP FUNCTION get_users_by_role(BIGINT);
CREATE OR REPLACE FUNCTION get_users_by_role(_role_id BIGINT)
RETURNS TABLE (
    id              BIGINT,
    email           VARCHAR(32),
    username        VARCHAR(32),
    password        VARCHAR(32),
    home_spot_id    BIGINT,
    role_id         BIGINT,
    creation_date   DATE
) AS
$$
BEGIN
    RETURN query SELECT * FROM users WHERE users.role_id = _role_id;
END;
$$ LANGUAGE plpgsql;


DROP FUNCTION get_users_by_spot(BIGINT);
CREATE OR REPLACE FUNCTION get_users_by_spot(_home_spot_id BIGINT)
RETURNS TABLE (
    id              BIGINT,
    email           VARCHAR(32),
    username        VARCHAR(32),
    password        VARCHAR(32),
    home_spot_id    BIGINT,
    role_id         BIGINT,
    creation_date   DATE
) AS
$$
BEGIN
    RETURN query SELECT * FROM users WHERE users.home_spot_id = _home_spot_id;
END;
$$ LANGUAGE plpgsql;

------------------------------------- DELETE FUNCTIONS -----------------------------------
DROP FUNCTION remove_user_by_id(BIGINT);
CREATE OR REPLACE FUNCTION remove_user_by_id(_id BIGINT)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM users WHERE users.id = _id;
END;
$$ LANGUAGE plpgsql;


DROP FUNCTION remove_comment_by_id(BIGINT);
CREATE OR REPLACE FUNCTION remove_comment_by_id(_id BIGINT)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM comment WHERE comment.id = _id;
END;
$$ LANGUAGE plpgsql;