create table demo_table (
  id varchar(36) primary key not null,
  first_name varchar(255) not null,
  middle_name varchar(255),
  last_name varchar(255) not null,
  email varchar(max) not null,
  sss_id varchar(12) not null,
  is_regular bit not null,
  number_of_dependents numeric not null,
  height numeric(1000,2) not null,
  hire_date date,
  start_time time,
  add_date timestamp not null
);
