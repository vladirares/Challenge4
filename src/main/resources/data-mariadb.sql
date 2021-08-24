USE challenge4;

INSERT INTO players (player_name,
                     player_age,
                     player_username,
                     player_gender,
                     player_no_played_games,
                     player_accepts_newsletter)

VALUES ('vladimir', 23, 'vladimirrares', 'male', 10, FALSE),
       ('ionel', 26, 'ionelion', 'male', 100, TRUE),
       ('Maria', 29, 'mariamaria', 'female', 15, TRUE),
       ('Ioana', 21, 'ioanamaria', 'female', 23, TRUE);


INSERT INTO cards (card_serial,
                   card_no_numbers,
                   card_generated_date)

VALUES ('123957291', 24, CURRENT_DATE),
       ('223989598', 24, CURRENT_DATE),
       ('986457291', 24, CURRENT_DATE);

INSERT INTO bingo_numbers (number_column, number_value)
VALUES ('B', 8),
       ('I', 20),
       ('N', 40);
