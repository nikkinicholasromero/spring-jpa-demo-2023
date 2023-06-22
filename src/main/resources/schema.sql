create table demo_table (
  id varchar(36) primary key not null,
  first_name varchar(255) not null,
  middle_name varchar(255),
  last_name varchar(255) not null,
  email varchar(max) not null,
  sss_id varchar(12) not null
--   last_name varchar(255) not null,
--   number_of_dependents numeric not null,
--   height numeric(1000,2) not null,
--   weight numeric(1000,2) not null,
--   hired_date date not null,
--   start_time time not null,
--   is_regular boolean
);
