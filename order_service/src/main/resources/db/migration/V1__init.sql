-- V1__Create_t_orders_table.sql

CREATE TABLE t_orders (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    order_number VARCHAR(255) NOT NULL,
    sku_code VARCHAR(255) NOT NULL,
    quantity INTEGER NOT NULL,
    price NUMERIC(19, 2) NOT NULL
);
