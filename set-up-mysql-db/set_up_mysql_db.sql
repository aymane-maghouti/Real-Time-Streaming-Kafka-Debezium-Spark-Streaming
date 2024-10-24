-- Create the smartphones database 
create database smartphones;

use smartphones;

--  Create the tables where we will store the data coming from spark streaming job

-- 0. Table for statistics_summary
CREATE TABLE statistics_summary (
    total_phones INT,
    max_price DOUBLE,
    max_screen_size DOUBLE,
    max_ram DOUBLE,
    max_rom DOUBLE,
    max_battery DOUBLE,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 1. Table for number of phones per brand
CREATE TABLE phones_per_brand (
    brand VARCHAR(100),
    total_phones INT,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (brand)
);

-- 2. Table for number of phones per sim type
CREATE TABLE phones_per_sim_type (
    sim_type VARCHAR(50),
    total_phones INT,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (sim_type)
);

-- 3. Table for max price per brand
CREATE TABLE max_price_per_brand (
    brand VARCHAR(100),
    max_price DOUBLE,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (brand)
);

-- 4. Table for max price per sim type
CREATE TABLE max_price_per_sim_type (
    sim_type VARCHAR(50),
    max_price DOUBLE,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (sim_type)
);

-- 5. Table for max RAM per brand
CREATE TABLE max_ram_per_brand (
    brand VARCHAR(100),
    max_ram DOUBLE,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (brand)
);

-- 6. Table for max ROM per sim type
CREATE TABLE max_rom_per_sim_type (
    sim_type VARCHAR(50),
    max_rom DOUBLE,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (sim_type)
);

-- 7. Table for max battery capacity per brand
CREATE TABLE max_battery_per_brand (
    brand VARCHAR(100),
    max_battery DOUBLE,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (brand)
);

-- 8. Table for max screen size per sim type
CREATE TABLE max_screen_size_per_sim_type (
    sim_type VARCHAR(50),
    max_screen_size DOUBLE,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (sim_type)
);






