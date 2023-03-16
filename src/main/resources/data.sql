/*FOR THE USERS*/
INSERT INTO users (username,user_password,first_name,last_name,iscontributor,isadmin) 
VALUES ('Kostas1','Hello1234!','Konstantinos1','Kokonos1',true,true),
		('Kostas2','Hello1234!','Konstantinos2','Kokonos2',true,false),
		('Kostas3','Hello1234!','Konstantinos3','Kokonos3',false,false);

/*FOR THE GOAL*/
INSERT INTO goal (goal_name,complete_goal) 
VALUES ('Lose weight',false);
INSERT INTO goal (goal_name,complete_goal) 
VALUES ('Gain Muscle Mass',false);
INSERT INTO goal (goal_name,complete_goal) 
VALUES ('Get Shredded',false);

/*FOR THE PROFILE*/
INSERT INTO profile (goal_id,age,weight,height)
VALUES (2,24,78,160),
		(1,26,80,170),
		(1,28,82,167);

/*FOR THE PROGRAM*/
INSERT INTO program (program_name,category,complete_program) 
VALUES ('Mr/Ms Olympia','Upper-Lower Body',false);
INSERT INTO program (program_name,category,complete_program) 
VALUES ('Up Up Up','Upper Body',false);
INSERT INTO program (program_name,category,complete_program) 
VALUES ('Down Down Down','Lower Body',false);
INSERT INTO program (program_name,category,complete_program) 
VALUES ('Run Run Run','Aerobic',false);

/*FOR THE WORKOUT*/
INSERT INTO workout (workout_name,type,complete_workout) 
VALUES ('Popeye','Arms',false);
INSERT INTO workout (workout_name,type,complete_workout) 
VALUES ('Want to have better posture?','Back',false);
INSERT INTO workout (workout_name,type,complete_workout) 
VALUES ('These are chicken legs?','Legs',false);
INSERT INTO workout (workout_name,type,complete_workout) 
VALUES ('A little bit of everything','Whole Body Workout',false);

/*FOR THE EXERCISE*/

/*FOR THE PROFILE*/


/*FOR THE PROFILE*/


/*FOR THE PROFILE*/


/*FOR THE PROFILE*/


