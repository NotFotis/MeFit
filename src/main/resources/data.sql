INSERT INTO workout(workout_id,workout_name,workout_type,workout_complete) VALUES (1,'SKULL CRUSHERS','BICEPS','false');
INSERT INTO workout(workout_id,workout_name,workout_type,workout_complete) VALUES (2,'SKIP LEG DAY','LEGS','false');
INSERT INTO workout(workout_id,workout_name,workout_type,workout_complete) VALUES (3,'GET ABS','ABS','false');



INSERT INTO program(program_id,program_name,program_category,program_complete) VALUES(1,'Biceps','Strengthen','false');
INSERT INTO program(program_id,program_name,program_category,program_complete) VALUES(2,'Triceps','Fat loss','false');
INSERT INTO program(program_id,program_name,program_category,program_complete) VALUES(3,'Back','Endurance','false');



INSERT INTO goal(goal_id,goal_name,goal_start_date,goal_end_date,goal_total_programs, 
goal_completed_programs,goal_complete) VALUES (1,'Get Fit','2023-12-31 23:59:59.999999','2023-01-01 00:00:00.000000',12,3,'false');
INSERT INTO goal(goal_id,goal_name,goal_start_date,goal_end_date,goal_total_programs, 
goal_completed_programs,goal_complete) VALUES (2,'Get Shredded','2023-01-31 23:59:59.999999','2023-11-31 00:00:00.000000',10,3,'false');


INSERT INTO exercise(exercise_id,exercise_name,exercise_desc,
	exercise_tmg,exercise_repetitions,exercise_img,exercise_vid,exercise_complete,workout_id)
	VALUES (1,'Push-ups','Push-ups work your chest and arms.','Chest and Arms',10,'https://www.fitnesseducation.edu.au/wp-content/uploads/2017/03/Pushups.jpg','https://www.youtube.com/watch?v=IODxDxX7oi4','false',1);
INSERT INTO exercise(exercise_id,exercise_name,exercise_desc,
	exercise_tmg,exercise_repetitions,exercise_img,exercise_vid,exercise_complete,workout_id)
	VALUES (1,'Pull-ups','Pull-ups work your chest and arms.','Chest and Arms',12,'',1);
INSERT INTO exercise(exercise_id,exercise_name,exercise_desc,
	exercise_tmg,exercise_repetitions,exercise_img,exercise_vid,exercise_complete,workout_id)
	VALUES (1,'Squats','Squats make your legs strong.','Legs',12,'',2);


INSERT INTO profile(profile_id,profile_age,profile_weight,profile_height,goal_id) VALUES (1,25,90,190,1);
INSERT INTO profile(profile_id,profile_age,profile_weight,profile_height,goal_id) VALUES (2,28,80,180,2);


INSERT INTO program_workout(program_id,workout_id) VALUES (1,1);
INSERT INTO program_workout(program_id,workout_id) VALUES (1,2);
INSERT INTO program_workout(program_id,workout_id) VALUES (2,2);

INSERT INTO program_goal(program_id,goal_id) VALUES (1,1);
INSERT INTO program_goal(program_id,goal_id) VALUES (2,1);
INSERT INTO program_goal(program_id,goal_id) VALUES (3,2);


