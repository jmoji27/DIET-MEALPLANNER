COPY diet(d_name, goal, description)
    FROM '/data/diet.csv' DELIMITER ',' CSV HEADER;

COPY ingredient(name, calories, fat, carbs, protein, tag)
    FROM '/data/ingredients.csv' DELIMITER ',' CSV HEADER;

COPY recipe(rname, diet_id, instructions)
    FROM '/data/recipes.csv' DELIMITER ',' CSV HEADER;

COPY contains(rid, igid, amount )
    FROM '/data/contains.csv' DELIMITER ',' CSV HEADER;

COPY app_user(username, password, role)
    FROM '/data/users.csv' DELIMITER ',' CSV HEADER;

COPY weekly_planning(user_id, recipe_id, meal_type, date)
    FROM '/data/weekly_planning.csv' DELIMITER ',' CSV HEADER;
