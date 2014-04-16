create sequence user_seq start 1 increment by 1;

create table if not exists users (
  id bigint default nextval('user_seq') primary key,
  username varchar(100) unique not null,
  password varchar(512) not null,
  roles varchar(100)[] not null,
  removed boolean default false
);