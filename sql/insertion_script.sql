INSERT INTO SPOT_ACTIVITY values (1, 7391, 'High Activity');
INSERT INTO SPOT_ACTIVITY values (2, 426, 'Low Activity');
INSERT INTO SPOT_ACTIVITY values (3, 3122, 'Medium Activity');

INSERT INTO LOCATION values (1, 59.9386300, 30.3141300);
INSERT INTO LOCATION values (2, 59.9186300, 31.4641390);
INSERT INTO LOCATION values (3, 59.1156100, 33.4941790);

INSERT INTO SPOT values (1, 'Moskovskaya', 'A legendary street spot..', '09-10-2021', 1, 1);
INSERT INTO SPOT values (2, 'Kosar', 'A wooden skate-park with asphalt..', '09-10-2021', 2, 2);
INSERT INTO SPOT values (3, 'Jest', 'Place to training at winter', '23-12-2021', 3, 3);

INSERT INTO ROLE values (1, 'User');
INSERT INTO ROLE values (2, 'Moderator');

INSERT INTO SPORT values (1, 'Skateboarding', 'Sport includes riding a skateboard and doing some tricks on it', 1);
INSERT INTO SPORT values (2, 'BMX', 'Sport includes riding a bmx and doing some tricks on it', 1);
INSERT INTO SPORT values (3, 'Scooter', 'Sport includes riding a scooter and doing some tricks on it', 1);

INSERT INTO USERS values (1, 'abcdf@gmail.com', 'sicknick', 'akdjfajdd', 1, 1, 1, '22-05-2003');
INSERT INTO USERS values (2, 'kkkkk@gmail.com', 'milkymilk', 'passs', 2, 2, 1, '11-07-2006');
INSERT INTO USERS values (3, 'tricky@gmail.com', 'johnny', 'pass11s', 3, 1, 1, '01-08-2020');

INSERT INTO VIDEO values (1, '/videos/1', 'trick', 1, '22-05-2015');
INSERT INTO VIDEO values (2, '/videos/2', 'spot', 2, '24-05-2018');
INSERT INTO VIDEO values (3, '/videos/3', 'trick', 3, '12-05-2021');

INSERT INTO TRICK values (1, 'Ollie', 'Making a jump on skateboard', 'Put your foot here...', 'Beginner Level', 1, 1);
INSERT INTO TRICK values (2, 'Barspin', 'Making a spin by a steering wheel', 'Put your hands on steering wheel like this...', 'Medium Level', 1, 2);
INSERT INTO TRICK values (3, 'Tailwhip', 'Making a spin by a tail of scooter', 'Spin the tail like this..', 'Experienced Level', 1, 3);

INSERT INTO CITY values (1, 'Saint-Petersburg');

INSERT INTO COMMENT values (1, 'cool!', 1, '21-06-2021');
INSERT INTO COMMENT values (2, 'not so bad!', 2, '21-06-2021');
INSERT INTO COMMENT values (3, 'i am trying so hard but it does not help me', 3, '21-06-2021');
INSERT INTO COMMENT values (4, 'Great spot! Remember that 11 stairs..', 1, '03-12-2020');
INSERT INTO COMMENT values (5, 'Mini-ramp is broken now', 2, '21-06-2021');
INSERT INTO COMMENT values (6, 'Every week I enjoy this place. It is cool', 3, '21-06-2021');

INSERT INTO OBJECT values (1, 'mini-rail');
INSERT INTO OBJECT values (2, 'mini-ramp');
INSERT INTO OBJECT values (3, '5 stairs gap');

INSERT INTO PROGRESS values (1, 1, 'learned');
INSERT INTO PROGRESS values (2, 2, 'in process');
INSERT INTO PROGRESS values (3, 3, 'in process');

INSERT INTO HOME_SPOT values (1, 3);
INSERT INTO HOME_SPOT values (2, 1);
INSERT INTO HOME_SPOT values (3, 2);

INSERT INTO SPORT_TRICKS values (1, 1);
INSERT INTO SPORT_TRICKS values (2, 2);
INSERT INTO SPORT_TRICKS values (3, 3);

INSERT INTO SPOT_COMMENTS values (1, 4);
INSERT INTO SPOT_COMMENTS values (2, 5);
INSERT INTO SPOT_COMMENTS values (3, 6);

INSERT INTO SPOT_OBJECTS values (1, 3);
INSERT INTO SPOT_OBJECTS values (2, 1);
INSERT INTO SPOT_OBJECTS values (2, 2);
INSERT INTO SPOT_OBJECTS values (3, 1);
INSERT INTO SPOT_OBJECTS values (3, 2);
INSERT INTO SPOT_OBJECTS values (3, 3);

INSERT INTO SPOT_SPORT values (1, 1);
INSERT INTO SPOT_SPORT values (1, 2);
INSERT INTO SPOT_SPORT values (1, 3);
INSERT INTO SPOT_SPORT values (2, 1);
INSERT INTO SPOT_SPORT values (2, 2);
INSERT INTO SPOT_SPORT values (2, 3);
INSERT INTO SPOT_SPORT values (3, 1);
INSERT INTO SPOT_SPORT values (3, 2);
INSERT INTO SPOT_SPORT values (3, 3);

INSERT INTO SPOTS_OF_CITY values (1, 1);
INSERT INTO SPOTS_OF_CITY values (1, 2);
INSERT INTO SPOTS_OF_CITY values (1, 3);

INSERT INTO PHOTO values (1, '/photo/1', 'spot', 1, '12-11-2021');
INSERT INTO PHOTO values (2, '/photo/2', 'spot', 2, '03-09-2021');
INSERT INTO PHOTO values (3, '/photo/3', 'trick', 3, '07-05-2021');
INSERT INTO PHOTO values (4, '/photo/4', 'user', 1, '08-09-2021');
INSERT INTO PHOTO values (5, '/photo/5', 'user', 2, '01-05-2021');

INSERT INTO SPOT_PHOTOS values (1, 1);
INSERT INTO SPOT_PHOTOS values (1, 2);

INSERT INTO SPOT_VIDEOS values (2, 2);

INSERT INTO TRICK_COMMENTS values (1, 3);
INSERT INTO TRICk_COMMENTS values (2, 2);
INSERT INTO TRICk_COMMENTS values (3, 1);