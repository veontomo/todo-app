create table status (
   id integer not null,
   name varchar(255) not null,
   primary key(id)
);

create table user (
   id integer not null,
   name varchar(10) not null,
   role varchar(10) not null,
   primary key(id)
);

create table task(
   id integer not null,
   name varchar(20) not null,
   description varchar(255),
   status integer not null,
   user integer not null,
   primary key(id),
   foreign key (status) references status(id),
   foreign key (user) references user(id)
);