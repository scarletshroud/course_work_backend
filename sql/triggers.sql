-------------------- INCREMENT SPOT ACTIVITY AFTER USER INSERTING ---------------------
CREATE OR REPLACE FUNCTION increment_spot_activity()
RETURNS TRIGGER AS
$$
    DECLARE
        new_people_visited  BIGINT;
        _activity_id        BIGINT;

    BEGIN
        _activity_id := (SELECT activity_id FROM spot WHERE spot.id = NEW.home_spot_id);
        new_people_visited := (SELECT people_visited FROM spot_activity WHERE spot_activity.id = _activity_id) + 1;
        UPDATE spot_activity SET people_visited = new_people_visited WHERE spot_activity.id = _activity_id;
        RETURN NEW;
    END;
$$ language plpgsql;


CREATE TRIGGER spot_activity_trigger
    AFTER INSERT
    ON users FOR EACH ROW EXECUTE PROCEDURE increment_spot_activity();


--------------------- INCREMENT AMOUNT OF SPORT RIDERS BY SPORT TYPE -------------------
CREATE OR REPLACE FUNCTION increment_amount_of_riders_by_sport_type()
RETURNS TRIGGER AS
$$
    DECLARE
        new_amount_of_riders  BIGINT;

    BEGIN
        new_amount_of_riders := (SELECT amount_of_riders FROM sport WHERE sport.id = NEW.sport_id) + 1;
        UPDATE sport SET amount_of_riders = new_amount_of_riders WHERE sport.id = NEW.sport_id;
        RETURN NEW;
    END;
$$ language plpgsql;



CREATE TRIGGER sport_amount_of_riders_trigger
    AFTER INSERT
    ON users FOR EACH ROW EXECUTE PROCEDURE increment_amount_of_riders_by_sport_type();