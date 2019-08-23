CREATE TABLE cars (
    id BINARY(16) DEFAULT (uuid_to_bin(uuid())),
    owner_id BINARY(16),
    owner_name VARCHAR(255),
    owner_bio VARCHAR(255),
    brand VARCHAR(255),
    status VARCHAR(255),
    model VARCHAR(255),
    model_year YEAR,
    release_year YEAR,
    license_plate VARCHAR(50),
    latitude DOUBLE,
    longitude DOUBLE,

    CONSTRAINT cars_pk PRIMARY KEY(id),
    CONSTRAINT brand_ck check ( brand in ('AUDI', 'BMW', 'MERCEDES_BENZ', 'FORD', 'CHEVROLET') ),
    CONSTRAINT status_ck check ( status in ('WAITING_FOR_APPROVAL', 'ACTIVE', 'INACTIVE') )
);