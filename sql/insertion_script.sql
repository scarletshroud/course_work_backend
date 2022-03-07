INSERT INTO SPOT_ACTIVITY values (1, 7391, 'High Activity');
INSERT INTO SPOT_ACTIVITY values (2, 426, 'Low Activity');
INSERT INTO SPOT_ACTIVITY values (3, 3122, 'Medium Activity');
INSERT INTO SPOT_ACTIVITY values (4, 15132, 'High Activity');

INSERT INTO LOCATION values (1, 59.852180, 30.322710);
INSERT INTO LOCATION values (2, 59.855629, 30.355724);
INSERT INTO LOCATION values (3, 57.616889, 39.871598);
INSERT INTO LOCATION values (4, 51.514030, -0.099528);

INSERT INTO SPOT values (1, 'Moskovskaya', 'A legendary street spot..', '09-10-2021', 1, 1);
INSERT INTO SPOT values (2, 'Kosar', 'A wooden skate-park with asphalt..', '09-10-2021', 2, 2);
INSERT INTO SPOT values (3, 'Jest', 'Place to training at winter', '23-12-2021', 3, 3);
INSERT INTO SPOT values (4, 'Saint-Paul', 'The famous spot of London', '23-12-2021', 4, 4);

INSERT INTO ROLE values (1, 'User');
INSERT INTO ROLE values (2, 'Moderator');

INSERT INTO SPORT values (1, 'Skateboarding', 'Sport includes riding a skateboard and doing some tricks on it', 1);
INSERT INTO SPORT values (2, 'BMX', 'Sport includes riding a bmx and doing some tricks on it', 1);
INSERT INTO SPORT values (3, 'Scooter', 'Sport includes riding a scooter and doing some tricks on it', 1);

INSERT INTO USERS values (1, 'egor@gmail.com', 'sicknick', '8fbcde4b93bb48d351fc2450f09975c4dc1504478138f384838ae29fb2ee4772', 'Hello from SPb!', 1, 1, 1, '22-05-2003');
INSERT INTO USERS values (2, 'klim@gmail.com', 'milkymilk', '8fbcde4b93bb48d351fc2450f09975c4dc1504478138f384838ae29fb2ee4772', 'roll barspin all day', 2, 1, 2, '11-07-2006');
INSERT INTO USERS values (3, 'flip@gmail.com', 'scarletshroud', '8fbcde4b93bb48d351fc2450f09975c4dc1504478138f384838ae29fb2ee4772', 'privet', 3, 1, 3, '01-08-2020');
INSERT INTO USERS values (4, 'unknown@gmail.com', null, '8fbcde4b93bb48d351fc2450f09975c4dc1504478138f384838ae29fb2ee4772', 'love kickflips', 3, 1, null, '01-08-2020');

INSERT INTO VIDEO values (1, 'VasSLuFO4wY', 'trick', 1, '22-05-2015');
INSERT INTO VIDEO values (2, 'v1RN7F4vYLI', 'spot', 2, '24-05-2018');
INSERT INTO VIDEO values (3, 'Z95JS__wMTw', 'trick', 3, '12-05-2021');
INSERT INTO VIDEO values (4, 'DwCJvALEJWk', 'trick', 3, '12-05-2021');
INSERT INTO VIDEO values (5, 'ZSe9vPoXKiU', 'trick', 3, '12-05-2021');
INSERT INTO VIDEO values (6, 'PnuobIzTPMs', 'trick', 3, '12-05-2021');
INSERT INTO VIDEO values (7, 'WgCqD8vo2Qg', 'spot', 2, '24-05-2014');

INSERT INTO TRICK values (1, 'Ollie', 'Making a jump on skateboard', 'Put your foot here...', 'Beginner Level', 1, 1);
INSERT INTO TRICK values (2, 'Barspin', 'Making a spin by a steering wheel', 'Put your hands on steering wheel like this...', 'Medium Level', 1, 2);
INSERT INTO TRICK values (3, 'Tailwhip', 'Making a spin by a tail of scooter', 'Spin the tail like this..', 'Experienced Level', 1, 3);
INSERT INTO TRICK values (4,
                            'Pop Shove It',
                            'Set your front foot on the board just below the front bolts, angling it slightly like you would for a kickflip. With your back foot on the tail, you’ll need to curl your toes over the toeside edge of the board and push straight back. ',
                            'Ride at a comfortable speed with your feet in the pop shove it position
                            Pop with your back foot, dipping your ankle down and back.
                            As the board rotates, hover over it with your front foot
                            Catch the board with your front foot
                            Land on the bolts and roll away.',
                            'Medium Level',
                            0, 4);
INSERT INTO TRICK values (5,
                            'Frontside 180',
                            'Place your front foot on the board below the front bolts, similar to the foot position for an ollie. Place your back foot in the middle of the tail with the ball of your foot near the heel-side pocket of the tail for a solid pop to your frontside 180.',
                            'Ride at a comfortable speed, and set your feet up in the frontside 180 position
                            Pop the board with your back foot, turning your head and shoulders frontside as you pop.
                            Drag your front foot up the board like an ollie, while your back foot brings the board around.
                            Land on the bolts and roll away switch.',
                            'Beginner Level',
                             0, 5);
INSERT INTO TRICK values (6,
                          '360-Flip',
                          'Are you ready to take your skateboarding to the next level and learn one of the most beautiful flat ground tricks in all of skateboarding? Well, ready or not, we’re here to teach you how to master the 360 flip. It was invented by Rodney Mullen in the 1980s, but truly popularized by Jason Lee in the mid 90’s.',
                          'We hope you enjoyed the tutorial and that you gained some insight on how to do a 360 Flip. Let’s go over the material from the video and recap what we learned to really drill those 360 Flip mechanics into your head.  When learning the 360 Flip, it helps to go over these 5 crucial steps:
                            Foot Position
                            Body Position
                            Back Foot Scoop
                            Front Foot Flick
                            Landing',
                          'Experienced Level',
                          0, 6);


INSERT INTO CITY values (1, 'Saint-Petersburg');
INSERT INTO CITY values (2, 'London');

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
INSERT INTO PROGRESS values (1, 4, 'learned');
INSERT INTO PROGRESS values (2, 4, 'in process');
INSERT INTO PROGRESS values (3, 3, 'in process');

INSERT INTO HOME_SPOT values (1, 3);
INSERT INTO HOME_SPOT values (2, 1);
INSERT INTO HOME_SPOT values (3, 2);

INSERT INTO SPORT_TRICKS values (1, 1);
INSERT INTO SPORT_TRICKS values (2, 2);
INSERT INTO SPORT_TRICKS values (3, 3);
INSERT INTO SPORT_TRICKS values (1, 4);
INSERT INTO SPORT_TRICKS values (1, 5);
INSERT INTO SPORT_TRICKS values (1, 6);

INSERT INTO SPOT_COMMENTS values (1, 4);
INSERT INTO SPOT_COMMENTS values (2, 5);
INSERT INTO SPOT_COMMENTS values (3, 6);

INSERT INTO SPOT_OBJECTS values (1, 3);
INSERT INTO SPOT_OBJECTS values (2, 1);
INSERT INTO SPOT_OBJECTS values (2, 2);
INSERT INTO SPOT_OBJECTS values (3, 1);
INSERT INTO SPOT_OBJECTS values (3, 2);
INSERT INTO SPOT_OBJECTS values (3, 3);
INSERT INTO SPOT_OBJECTS values (4, 1);
INSERT INTO SPOT_OBJECTS values (4, 2);
INSERT INTO SPOT_OBJECTS values (4, 3);

INSERT INTO SPOT_SPORT values (1, 1);
INSERT INTO SPOT_SPORT values (1, 2);
INSERT INTO SPOT_SPORT values (1, 3);
INSERT INTO SPOT_SPORT values (2, 1);
INSERT INTO SPOT_SPORT values (2, 2);
INSERT INTO SPOT_SPORT values (2, 3);
INSERT INTO SPOT_SPORT values (3, 1);
INSERT INTO SPOT_SPORT values (3, 2);
INSERT INTO SPOT_SPORT values (3, 3);
INSERT INTO SPOT_SPORT values (4, 1);
INSERT INTO SPOT_SPORT values (4, 2);
INSERT INTO SPOT_SPORT values (4, 3);

INSERT INTO SPOTS_OF_CITY values (1, 1);
INSERT INTO SPOTS_OF_CITY values (1, 2);
INSERT INTO SPOTS_OF_CITY values (1, 3);
INSERT INTO SPOTS_OF_CITY values (2, 4);

INSERT INTO PHOTO values (1, 'https://kuda-spb.ru/uploads/22331c83f7adaa115a71ea480564c46c.jpg', 'spot', 1, '12-11-2021');
INSERT INTO PHOTO values (2, 'https://yarnovosti.com/gallery/news/2017/08/71015/_mg_2923.jpg', 'spot', 2, '03-09-2021');
INSERT INTO PHOTO values (3, '/photo/3', 'trick', 3, '07-05-2021');
INSERT INTO PHOTO values (4, 'https://www.monsterenergy.com/media/uploads_image/2019/10/22/370/625/f5cf5f77cf63860c47a54d2ed617e261.jpg?mod=v1_84211c4e87fb6100d66bcddd8e115008', 'user', 1, '08-09-2021');
INSERT INTO PHOTO values (5, 'https://skatenewswire.com/wp-content/uploads/2021/09/andrew-reynolds.jpg', 'user', 2, '01-05-2021');
INSERT INTO PHOTO values (6, 'https://bolshoisport.ru/uploads/image/file/481/screen_IMG_0332.jpg', 'user', 3, '08-09-2021');
INSERT INTO PHOTO values (7, 'https://img.redbull.com/images/c_limit,w_1500,h_1000,f_auto,q_auto/redbullcom/2021/5/25/smnxpfky9cybgjeje39r/jagger-eaton-skateboard', 'user', 4, '01-05-2021');
INSERT INTO PHOTO values (8, 'https://directory.spb.ru/wp-content/uploads/2020/11/IMG_7522_big.jpg', 'spot', 1, '12-11-2021');
INSERT INTO PHOTO values (9, 'https://static.wixstatic.com/media/cd6341_7b19fb83783242a49616da420209e13a~mv2.jpg/v1/fill/w_800,h_600,al_c,q_90/cd6341_7b19fb83783242a49616da420209e13a~mv2.jpg', 'spot', 2, '03-09-2021');

INSERT INTO SPOT_PHOTOS values (1, 1);
INSERT INTO SPOT_PHOTOS values (2, 2);
INSERT INTO SPOT_PHOTOS values (3, 8);
INSERT INTO SPOT_PHOTOS values (4, 9);

INSERT INTO SPOT_VIDEOS values (4, 7);

INSERT INTO TRICK_COMMENTS values (1, 3);
INSERT INTO TRICk_COMMENTS values (2, 2);
INSERT INTO TRICk_COMMENTS values (3, 1);