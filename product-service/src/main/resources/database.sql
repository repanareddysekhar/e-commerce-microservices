-- Table Definition
CREATE TABLE "public"."category" (
     "id" uuid NOT NULL,
     "createdat" timestamptz NOT NULL,
     "modifiedat" timestamptz NOT NULL,
     "is_deleted" bool DEFAULT false,
     "category_name" varchar(255),
     "description" varchar(255),
     PRIMARY KEY ("id")
);


INSERT INTO "public"."category" ("id", "createdat", "modifiedat", "is_deleted", "category_name", "description")
VALUES
    (gen_random_uuid(), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, false, 'APPLIANCES', 'Appliances like washing machine, TVs etc'),
    (gen_random_uuid(), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, false, 'BOOKS', 'Books'),
    (gen_random_uuid(), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, false, 'TOYS', 'Toys'),
    (gen_random_uuid(), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, false, 'CLOTHES', 'Clothes'),
    (gen_random_uuid(), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, false, 'ELECTRONICS', 'Electronics');


-- Table Definition
CREATE TABLE "public"."product" (
    "id" uuid NOT NULL,
    "createdat" timestamptz NOT NULL,
    "modifiedat" timestamptz NOT NULL,
    "is_deleted" bool DEFAULT false,
    "category" int8,
    "description" varchar(255),
    "name" varchar(255),
    "price" numeric(38,2),
    "quantity" int4,
    PRIMARY KEY ("id")
);

-- Inserting sample data into the product table
INSERT INTO "public"."product" ("id", "createdat", "modifiedat", "is_deleted", "category", "description", "name", "price", "quantity")
VALUES
    (gen_random_uuid(), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, false, '0d643b44-5c8d-43d8-9400-bef4ffed1864', 'Bird Toy', 'Bird toy', 149.99, 100),
    (gen_random_uuid(), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, false, '1ec44b83-af36-4ee7-8696-3b7ac584e841', 'Appliances', 'Samsung TV', 19990.09, 5),
    (gen_random_uuid(), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, false, '8d062784-d137-4e26-842f-9b96e40f840a', 'Iphone 15 plus', 'Iphone 15 plus', 87999.99, 50),
    (gen_random_uuid(), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, false, 'af5fd233-b6c4-43c0-982a-0480790c272e', 'Harry potter series book', 'Harry potter', 449.99, 20),
    (gen_random_uuid(), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, false, 'd6754513-56e8-40b6-920c-36f32273b892', 'Tommy Hilfiger', 'Hilfiger - 40M', 4199.00, 15),
    (gen_random_uuid(), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, false, '8d062784-d137-4e26-842f-9b96e40f840a', 'Realme 15 Pro', 'Realme 15 Pro', 19999.00, 300),
    (gen_random_uuid(), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, false, '1ec44b83-af36-4ee7-8696-3b7ac584e841', 'Appliances', 'Onida TV', 17999.00, 10);
