
INSERT INTO cars(id,
                 owner_id,
                 owner_name,
                 owner_bio,
                 brand,
                 status,
                 model,
                 model_year,
                 release_year,
                 license_plate,
                 latitude,
                 longitude) VALUES
(
    uuid_to_bin('6a9d7bdc-7e84-45fc-9e3a-58f87c040574'),
    uuid_to_bin('614f470d-4938-4484-9073-0f8c1363ef93'),
    'Fernando',
    'Bla',
    'MERCEDES_BENZ',
    'ACTIVE',
    'CLC 200K',
    2010,
    2010,
    'ABC-5577',
    -28.5359, -52.1486
),

(
    uuid_to_bin('22feced4-93bb-4fa4-b55b-61b07cfe2644'),
    uuid_to_bin('614f470d-4938-4484-9073-0f8c1363ef93'),
    'Fernando',
    'Bla',
    'BMW',
    'ACTIVE',
    '330i',
    2011,
    2012,
    'ABC-5277',
    -23.5329, -46.6395
),

(
 uuid_to_bin('3a045f2a-8b75-46f5-8130-c07d07b5c4f8'),
 uuid_to_bin('614f470d-4938-4484-9073-0f8c1363ef93'),
 'Fernando',
 'Bla',
 'AUDI',
 'ACTIVE',
 'A4',
 2012,
 2013,
 'ABC-5077',
 -23.5208, -46.1854
);