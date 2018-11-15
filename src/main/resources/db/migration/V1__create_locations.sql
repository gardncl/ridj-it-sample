CREATE TABLE locations
(
    id serial primary key,
    name varchar(40) not null,
    address varchar(100) not null,
    city varchar(30) not null,
    state varchar(2) not null
)