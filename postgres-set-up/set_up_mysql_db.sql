CREATE TABLE smartphones (
    id INT PRIMARY KEY,
    brand VARCHAR(50),
    screen_size DECIMAL(3,2),
    ram DECIMAL(3,1),
    rom DECIMAL(4,1),
    sim_type VARCHAR(10),
    battery DECIMAL(5,1),
    price DECIMAL(6,1)
);



INSERT INTO smartphones (id, brand, screen_size, ram, rom, sim_type, battery, price)
VALUES
(9, 'Tecno', 6.8, 8.0, 128.0, 'Dual', 5000.0, 2125.0),
(12, 'Infinix', 6.82, 8.0, 128.0, 'Dual', 6000.0, 1377.0),
(13, 'XIAOMI', 6.52, 3.0, 64.0, 'Dual', 5000.0, 930.0),
(16, 'Tecno', 6.6, 4.0, 128.0, 'Dual', 5000.0, 1449.0),
(19, 'Infinix', 6.6, 2.0, 64.0, 'Dual', 5000.0, 876.0),
(20, 'XIAOMI', 6.52, 2.0, 32.0, 'Dual', 5000.0, 908.0),
(25, 'Freeyond', 6.52, 4.0, 64.0, 'Dual', 5000.0, 1115.0),
(26, 'Maxfone', 6.52, 2.0, 16.0, 'Dual', 5075.0, 524.0),
(28, 'Infinix', 6.6, 2.0, 64.0, 'Dual', 5000.0, 891.0),
(29, 'Freeyond', 6.52, 8.0, 128.0, 'Dual', 5000.0, 1370.0);
