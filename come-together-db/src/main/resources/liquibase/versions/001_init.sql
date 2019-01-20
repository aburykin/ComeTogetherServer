create table base_schema.app_user(
	app_user_id bigserial not null PRIMARY KEY,
	phone_number text not null,
	authorization_token text not null,
	first_name text,
	last_name int,
	age int,
	birthday_date timestamp
);

comment on table base_schema.app_user is 'пользователи приложения';
create unique index app_user_authorization_token_uindex on base_schema.app_user (authorization_token);
create unique index app_user_phone_number_uindex on base_schema.app_user (phone_number);
create unique index app_user_app_user_id_uindex on base_schema.app_user (app_user_id);


create table base_schema.meeting
(
	meeting_id bigserial not null PRIMARY KEY,
	name text,
	place text,
	start_date timestamp,
	description text
);

create unique index meeting_meeting_id_uindex on base_schema.meeting (meeting_id);
comment on table base_schema.meeting is 'Встречи';


create table base_schema.meeting_user_href
(
  meeting_user_href_id bigserial not null PRIMARY KEY,
  meeting_id bigint not null constraint meeting_user_href_meeting_meeting_id_fk references base_schema.meeting,
  app_user_id bigint not null constraint meeting_user_href_app_user_app_user_id_fk references base_schema.app_user,
  is_organizer boolean default false not null
);

comment on table base_schema.meeting_user_href is 'Участники встречи';
comment on column base_schema.meeting_user_href.is_organizer is 'Если true, то этот участник является ораганизатором встречи';

