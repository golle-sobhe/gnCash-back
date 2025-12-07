-- Initial schema based on JPA entities in com.fh.gncash.dao.entity
-- Note: SellerEntity extends UserEntity (single-table inheritance by default),
-- so sellers are stored in user_entity and referenced via seller_id -> user_entity(id).

-- Users (and Sellers via inheritance)
CREATE TABLE IF NOT EXISTS users (
    id            VARCHAR(255) PRIMARY KEY,
    phone_number  VARCHAR(255),
    first_name    VARCHAR(255),
    last_name     VARCHAR(255),
    id_type       VARCHAR(255),
    role          VARCHAR(50),
    DTYPE VARCHAR(31),
    -- Seller-specific relation (nullable for plain users)
    admin_id      VARCHAR(255),
    CONSTRAINT fk_user_admin
        FOREIGN KEY (admin_id)
        REFERENCES users (id)
        ON UPDATE CASCADE
        ON DELETE SET NULL
);

CREATE INDEX IF NOT EXISTS idx_user_admin_id ON users(admin_id);

-- Beneficiaries
CREATE TABLE IF NOT EXISTS beneficiary_entity (
    id            VARCHAR(255) PRIMARY KEY,
    first_name    VARCHAR(255),
    last_name     VARCHAR(255),
    phone_number  VARCHAR(255),
    avatar        VARCHAR(512),
    favorite      BOOLEAN
);

-- Transfers
CREATE TABLE IF NOT EXISTS transfer_entity (
    id             VARCHAR(255) PRIMARY KEY,
    seller_id      VARCHAR(255),
    recipient_id   VARCHAR(255),
    amount         NUMERIC(19,2),
    fees           NUMERIC(19,2),
    rate           NUMERIC(19,6),
    currency       VARCHAR(50),
    status         VARCHAR(50),
    date           TIMESTAMP,
    code           VARCHAR(255),
    CONSTRAINT fk_transfer_seller
        FOREIGN KEY (seller_id)
        REFERENCES users (id)
        ON UPDATE CASCADE
        ON DELETE SET NULL,
    CONSTRAINT fk_transfer_recipient
        FOREIGN KEY (recipient_id)
        REFERENCES beneficiary_entity (id)
        ON UPDATE CASCADE
        ON DELETE SET NULL
);

