DROP TABLE IF EXISTS contains CASCADE;
DROP TABLE IF EXISTS recipe CASCADE;
DROP TABLE IF EXISTS ingredient CASCADE;
DROP TABLE IF EXISTS diet CASCADE;

CREATE TABLE diet (
                      did SERIAL PRIMARY KEY,
                      d_name VARCHAR(100) NOT NULL,
                      goal VARCHAR(100),
                      description TEXT
);

CREATE TABLE recipe (
                        rid SERIAL PRIMARY KEY,
                        rname VARCHAR(100) NOT NULL,
                        diet_id INTEGER,
                        instructions TEXT,
                        CONSTRAINT fk_recipe_diet FOREIGN KEY (diet_id) REFERENCES diet(did)
);

CREATE TABLE ingredient (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(100) NOT NULL,
                            calories INTEGER,
                            fat REAL,
                            carbs REAL,
                            protein REAL,
                            tag VARCHAR(50)
);

CREATE TABLE contains (
                          rid INTEGER NOT NULL,
                          igid INTEGER NOT NULL,
                          amount FLOAT NOT NULL,
                          total_kcal FLOAT,
                          PRIMARY KEY (rid, igid),
                          CONSTRAINT fk_contains_recipe FOREIGN KEY (rid) REFERENCES recipe(rid),
                          CONSTRAINT fk_contains_ingredient FOREIGN KEY (igid) REFERENCES ingredient(id)
);

CREATE TYPE role
AS
    ENUM('ROLE_USER', 'ROLE_ADMIN');

CREATE TABLE app_user (
                          id BIGSERIAL PRIMARY KEY,
                          username VARCHAR(100) NOT NULL UNIQUE,
                          password VARCHAR(100) NOT NULL,
                          role role NOT NULL
);

CREATE TABLE weekly_planning (
                                 plan_id BIGSERIAL PRIMARY KEY,
                                 user_id BIGINT REFERENCES app_user(id) ON DELETE CASCADE,
                                 recipe_id INTEGER REFERENCES recipe(rid) ON DELETE CASCADE,
                                 meal_type VARCHAR(50),
                                 date DATE
);






