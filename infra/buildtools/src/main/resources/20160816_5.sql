

create table Person (
    personId bigint not null, 
    first_name varchar(255), 
    middle_name varchar(255), 
    last_name varchar(255), 
    suffix varchar(255), 
    title varchar(255), 
    date_of_birth date, 
    currently_employed boolean, 
    gwa real, 
    date_hired date, 
    address bigint not null, 
    primary key (personId));


create table Address (
    addressId bigint not null, 
    house_no int, 
    street varchar(255), 
    barangay varchar(255), 
    city varchar(255), 
    zip_code int, 
    primary key (addressId)
);


create table Contacts (
    contactId bigint not null, 
    contact_type varchar(255), 
    contact_value varchar(255), 
    personId bigint, 
    index int, 
    primary key (contactId));


