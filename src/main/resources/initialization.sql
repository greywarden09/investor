CREATE OR REPLACE FUNCTION init_fund_types() RETURNS VOID AS $$
DECLARE
    names varchar[] := ARRAY['Polskie', 'Zagraniczne', 'Pieniężne'];
	name varchar;
BEGIN
    DELETE FROM fund_type;
    ALTER SEQUENCE fund_type_seq RESTART WITH 1;
    FOREACH name IN ARRAY names LOOP
        INSERT INTO fund_type(id, name) VALUES (nextval('fund_type_seq'), name);
    END LOOP;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION init_ways_of_invest() RETURNS VOID AS $$
DECLARE
    names varchar[] := ARRAY['bezpieczny', 'zrównoważony', 'agresywny'];
    name varchar;
BEGIN
    DELETE FROM way_of_invest;
    ALTER SEQUENCE way_of_invest_seq RESTART WITH 1;
    FOREACH name IN ARRAY names LOOP
        INSERT INTO way_of_invest(id, name) VALUES (nextval('way_of_invest_seq'), name);
    END LOOP;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION init_percentages() RETURNS VOID AS $$
DECLARE
    way_of_invest_id bigint;
    fund_type_id bigint;
BEGIN
    DELETE FROM way_of_invest_percentage;
    ALTER SEQUENCE way_of_invest_percentage_seq RESTART WITH 1;
    -- bezpieczny
    INSERT INTO way_of_invest_percentage(id, fund_type_id, way_of_invest_id, percentage)
        VALUES
            (nextval('way_of_invest_percentage_seq'), (SELECT id FROM fund_type f WHERE f.name = 'Polskie'), (SELECT id FROM way_of_invest w WHERE w.name = 'bezpieczny'), 20),
            (nextval('way_of_invest_percentage_seq'), (SELECT id FROM fund_type f WHERE f.name = 'Zagraniczne'), (SELECT id FROM way_of_invest w WHERE w.name = 'bezpieczny'), 75),
            (nextval('way_of_invest_percentage_seq'), (SELECT id FROM fund_type f WHERE f.name = 'Pieniężne'), (SELECT id FROM way_of_invest w WHERE w.name = 'bezpieczny'), 5);
    -- zrównoważony
    INSERT INTO way_of_invest_percentage(id, fund_type_id, way_of_invest_id, percentage)
        VALUES
            (nextval('way_of_invest_percentage_seq'), (SELECT id FROM fund_type f WHERE f.name = 'Polskie'), (SELECT id FROM way_of_invest w WHERE w.name = 'zrównoważony'), 30),
            (nextval('way_of_invest_percentage_seq'), (SELECT id FROM fund_type f WHERE f.name = 'Zagraniczne'), (SELECT id FROM way_of_invest w WHERE w.name = 'zrównoważony'), 60),
            (nextval('way_of_invest_percentage_seq'), (SELECT id FROM fund_type f WHERE f.name = 'Pieniężne'), (SELECT id FROM way_of_invest w WHERE w.name = 'zrównoważony'), 10);
    -- agresywny
    INSERT INTO way_of_invest_percentage(id, fund_type_id, way_of_invest_id, percentage)
        VALUES
            (nextval('way_of_invest_percentage_seq'), (SELECT id FROM fund_type f WHERE f.name = 'Polskie'), (SELECT id FROM way_of_invest w WHERE w.name = 'agresywny'), 40),
            (nextval('way_of_invest_percentage_seq'), (SELECT id FROM fund_type f WHERE f.name = 'Zagraniczne'), (SELECT id FROM way_of_invest w WHERE w.name = 'agresywny'), 20),
            (nextval('way_of_invest_percentage_seq'), (SELECT id FROM fund_type f WHERE f.name = 'Pieniężne'), (SELECT id FROM way_of_invest w WHERE w.name = 'agresywny'), 40);
END;
$$ LANGUAGE plpgsql;

select init_ways_of_invest();
select init_fund_types();
select init_percentages();

DROP FUNCTION init_ways_of_invest;
DROP FUNCTION init_fund_types;
DROP FUNCTION init_percentages;
