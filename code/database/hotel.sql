CREATE DATABASE hotel;

USE hotel;

CREATE TABLE bookings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(100),
    room_no INT,
    room_type VARCHAR(20),
    days INT,
    rent INT,
    payment_status VARCHAR(20)
);
