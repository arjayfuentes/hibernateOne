CREATE DATABASE personinformation;

create table Person (
    personId int not null, 
    first_name varchar(255), 
    middle_name varchar(255), 
    last_name varchar(255), 
    suffix varchar(255), 
    title varchar(255), 
    date_of_birth date, 
    employed boolean, 
    gwa float, 
    date_hired date, 
    address int not null, 
    primary key (personId));


create table Address (
    addressId int not null, 
    houseNo int, 
    street varchar(255), 
    barangay varchar(255), 
    city varchar(255), 
    zipCode int, 
    primary key (addressId)
);


create table Contacts (
    contactId int not null, 
    contact_type varchar(255), 
    contact_value varchar(255), 
    personId int, 
    index int, 
    primary key (contactId));


