INSERT INTO app_user(uid) VALUES ('1');
INSERT INTO app_user(uid) VALUES ('2');
INSERT INTO app_user(uid) VALUES ('3');
INSERT INTO app_user(uid) VALUES ('4');

INSERT INTO workout(workout_id,workout_name,workout_type,workout_complete) VALUES (1,'SKULL CRUSHERS','BICEPS','false');
INSERT INTO workout(workout_id,workout_name,workout_type,workout_complete) VALUES (2,'SKIP LEG DAY','LEGS','false');
INSERT INTO workout(workout_id,workout_name,workout_type,workout_complete) VALUES (3,'GET ABS','ABS','false');
INSERT INTO workout(workout_id,workout_name,workout_type,workout_complete) VALUES (4,'SQUATS','LEGS','false');
INSERT INTO workout(workout_id,workout_name,workout_type,workout_complete) VALUES (5,'BENCH PRESS','CHEST','false');
INSERT INTO workout(workout_id,workout_name,workout_type,workout_complete) VALUES (6,'PLANKS','ABS','false');


INSERT INTO program(program_id,program_name,program_category,program_complete) VALUES(1,'Biceps','Strengthen','false');
INSERT INTO program(program_id,program_name,program_category,program_complete) VALUES(2,'Triceps','Fat loss','false');
INSERT INTO program(program_id,program_name,program_category,program_complete) VALUES(3,'Back','Endurance','false');
INSERT INTO program(program_id,program_name,program_category,program_complete) VALUES(4,'Chest and Back','Strengthen','false');
INSERT INTO program(program_id,program_name,program_category,program_complete) VALUES(5,'Legs and Glutes','Fat loss','false');
INSERT INTO program(program_id,program_name,program_category,program_complete) VALUES(6,'Core Strength','Endurance','false');


INSERT INTO goal(goal_id,goal_name,goal_start_date,goal_end_date,goal_total_programs,goal_completed_programs,goal_complete) VALUES (1,'Get Fit','2023-12-31 23:59:59.999999','2023-01-01 00:00:00.000000',12,3,'false');
INSERT INTO goal(goal_id,goal_name,goal_start_date,goal_end_date,goal_total_programs,goal_completed_programs,goal_complete) VALUES (2,'Build Muscle','2023-06-30 23:59:59.999999','2023-01-01 00:00:00.000000',8,1,'false');
INSERT INTO goal(goal_id,goal_name,goal_start_date,goal_end_date,goal_total_programs,goal_completed_programs,goal_complete) VALUES (3,'Lose Weight','2023-12-31 23:59:59.999999','2023-07-01 00:00:00.000000',12,0,'false');


INSERT INTO exercise(exercise_id,exercise_name,exercise_desc,exercise_tmg,exercise_repetitions,exercise_img,exercise_vid,exercise_complete,workout_id)VALUES (1,'Push-ups','Push-ups work your chest and arms.','Chest and Arms',10,'https://www.fitnesseducation.edu.au/wp-content/uploads/2017/03/Pushups.jpg','https://www.youtube.com/watch?v=IODxDxX7oi4','false',1);
INSERT INTO exercise(exercise_id,exercise_name,exercise_desc,exercise_tmg,exercise_repetitions,exercise_img,exercise_vid,exercise_complete,workout_id)VALUES (2,'Pull-ups','Pull-ups work your back and arms.','Back and Arms',8,'https://www.fitnesseducation.edu.au/wp-content/uploads/2017/03/Pull-ups.jpg','https://www.youtube.com/watch?v=eGo4IYlbE5g','false',3);
INSERT INTO exercise(exercise_id,exercise_name,exercise_desc,exercise_tmg,exercise_repetitions,exercise_img,exercise_vid,exercise_complete,workout_id)VALUES (3,'Squats','Squats work your legs and glutes.','Legs and Glutes',12,'https://www.fitnesseducation.edu.au/wp-content/uploads/2017/03/Squats.jpg','https://www.youtube.com/watch?v=mGvzVjuY8SY','false',4);
INSERT INTO exercise(exercise_id,exercise_name,exercise_desc,exercise_tmg,exercise_repetitions,exercise_img,exercise_vid,exercise_complete,workout_id)VALUES (4,'Crunches','Crunches work your abs.','Abs',15,'https://www.fitnesseducation.edu.au/wp-content/uploads/2017/03/Crunches.jpg','https://www.youtube.com/watch?v=Xyd_fa5zoEU','false',6);

INSERT INTO profile(profile_id,user_id,user_id,profile_age,profile_weight,profile_height,goal_id) VALUES (1,'1',25,90,190,1);
INSERT INTO profile(profile_id,user_id,user_id,profile_age,profile_weight,profile_height,goal_id) VALUES (2,'2',28,80,180,1);
INSERT INTO profile(profile_id,user_id,user_id,profile_age,profile_weight,profile_height,goal_id) VALUES (3,'3',30,75,175,2);
INSERT INTO profile(profile_id,user_id,user_id,profile_age,profile_weight,profile_height,goal_id) VALUES (4,'4',35,85,180,3);

INSERT INTO program_workout(program_id,workout_id) VALUES (1,1);
INSERT INTO program_workout(program_id,workout_id) VALUES (1,2);
INSERT INTO program_workout(program_id,workout_id) VALUES (2,2);
INSERT INTO program_workout(program_id,workout_id) VALUES (3,2);
INSERT INTO program_workout(program_id,workout_id) VALUES (3,3);
INSERT INTO program_workout(program_id,workout_id) VALUES (4,2);
INSERT INTO program_workout(program_id,workout_id) VALUES (4,1);

INSERT INTO program_goal(program_id,goal_id) VALUES (1,1);



