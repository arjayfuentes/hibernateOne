CREATE TABLE person (
    personId bigint NOT NULL,
    first_name character varying(255),
    middle_name character varying(255),
    last_name character varying(255),
    suffix character varying(255),
    title character varying(255),
    date_of_birth date,
    currently_employed boolean,
    gwa real,
    date_hired date,
    addressId bigint NOT NULL
);

CREATE TABLE address (
    addressId bigint NOT NULL,
    houseNo character varying(255),
    street character varying(255),
    barangay character varying(255),
    city character varying(255),
    zip_code integer
);

CREATE TABLE contacts (
    contactId bigint NOT NULL,
    contact_type character varying(255),
    contact_value character varying(255),
    personId bigint,
    index integer
);
