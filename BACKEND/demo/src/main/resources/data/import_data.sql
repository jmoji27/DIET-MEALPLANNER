\copy diet(d_name, goal, description) FROM '/data/diet.csv' DELIMITER ',' CSV HEADER;
\copy ingredient(name, calories, fat, carbs, protein, tag) FROM '/data/ingredients.csv' DELIMITER ',' CSV HEADER;
\copy recipe(rname, diet_id, instructions) FROM '/data/recipes.csv' DELIMITER ',' CSV HEADER;
\copy app_user(username, password, role) FROM '/data/users.csv' DELIMITER ',' CSV HEADER;
\copy weekly_planning(user_id, recipe_id, meal_type, date) FROM '/data/weekly_planning.csv' DELIMITER ',' CSV HEADER;
