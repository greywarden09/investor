INSERT INTO fund_type(id, name) VALUES
    (NEXTVAL('fund_type_seq'), 'Polskie'),
    (NEXTVAL('fund_type_seq'), 'Zagraniczne'),
    (NEXTVAL('fund_type_seq'), 'Pieniężne');

INSERT INTO way_of_invest(id, code, fund_type_id, percentage) VALUES
    (NEXTVAL('way_of_invest_seq'), 'bezpieczny', (SELECT id from fund_type f WHERE f.name = 'Polskie'), 20),
    (NEXTVAL('way_of_invest_seq'), 'bezpieczny', (SELECT id from fund_type f WHERE f.name = 'Zagraniczne'), 75),
    (NEXTVAL('way_of_invest_seq'), 'bezpieczny', (SELECT id from fund_type f WHERE f.name = 'Pieniężne'), 5);

INSERT INTO way_of_invest(id, code, fund_type_id, percentage) VALUES
    (NEXTVAL('way_of_invest_seq'), 'zrównoważony', (SELECT id from fund_type f WHERE f.name = 'Polskie'), 30),
    (NEXTVAL('way_of_invest_seq'), 'zrównoważony', (SELECT id from fund_type f WHERE f.name = 'Zagraniczne'), 60),
    (NEXTVAL('way_of_invest_seq'), 'zrównoważony', (SELECT id from fund_type f WHERE f.name = 'Pieniężne'), 10);

INSERT INTO way_of_invest(id, code, fund_type_id, percentage) VALUES
    (NEXTVAL('way_of_invest_seq'), 'agresywny', (SELECT id from fund_type f WHERE f.name = 'Polskie'), 40),
    (NEXTVAL('way_of_invest_seq'), 'agresywny', (SELECT id from fund_type f WHERE f.name = 'Zagraniczne'), 20),
    (NEXTVAL('way_of_invest_seq'), 'agresywny', (SELECT id from fund_type f WHERE f.name = 'Pieniężne'), 40);
