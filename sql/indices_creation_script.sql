create index  USER_HOME_SPOT_INDEX on USERS using hash(home_spot_id);
create index  USER_ROLE_INDEX on USERS using hash(role_id);
create index  USER_SPORT_INDEX on USERS using hash(sport_id);

create index  TRICK_VIDEO_INDEX on TRICK using hash(video_id);

create index  PROGRESS_TRICK_INDEX on PROGRESS using hash(trick_id);
create index  PROGRESS_USER_INDEX on PROGRESS using hash(user_id);

create index  SPOT_ACTIVITY_INDEX on SPOT using hash(activity_id);
create index  SPOT_LOCATION_INDEX on SPOT using hash(location_id);

create index  VIDEO_AUTHOR_INDEX on VIDEO using hash(author_id);
create index  PHOTO_USERS_INDEX on PHOTO using hash(author_id);