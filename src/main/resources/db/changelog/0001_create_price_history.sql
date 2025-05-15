create table price_history
(
    id serial primary key,
    timestamp timestamp with time zone,
    price numeric
);