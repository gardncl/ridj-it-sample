CREATE TABLE trips
(
    id serial primary key,
    name varchar(40) not null,
    description text not null,
    date date
)