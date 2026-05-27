-- Order Management - Sample Data (PostgreSQL)
-- Run after starting backend once (so table exists):
--   psql -U orderuser -d ordermanagement -f backend/src/main/resources/data.sql

INSERT INTO orders (order_number, customer_name, customer_email, product, quantity, unit_price, total_amount, status, order_date, delivery_date, shipping_address) VALUES
('ORD-2024-001', 'Rahul Sharma', 'rahul.sharma@email.com', 'Laptop - Dell Inspiron 15', 1, 72999.00, 72999.00, 'DELIVERED', '2024-01-15 10:30:00', '2024-01-22 14:00:00', '42, MG Road, Bangalore, Karnataka 560001'),
('ORD-2024-002', 'Priya Patel', 'priya.patel@email.com', 'Samsung Galaxy S24 Ultra', 1, 134999.00, 134999.00, 'SHIPPED', '2024-02-05 09:15:00', NULL, '18, Marine Drive, Mumbai, Maharashtra 400020'),
('ORD-2024-003', 'Amit Kumar', 'amit.kumar@email.com', 'Sony WH-1000XM5 Headphones', 2, 29990.00, 59980.00, 'PROCESSING', '2024-03-10 16:45:00', NULL, '7, Connaught Place, New Delhi 110001'),
('ORD-2024-004', 'Sneha Reddy', 'sneha.reddy@email.com', 'Apple MacBook Air M3', 1, 114900.00, 114900.00, 'CONFIRMED', '2024-03-20 11:00:00', NULL, '25, Jubilee Hills, Hyderabad, Telangana 500033'),
('ORD-2024-005', 'Vikram Singh', 'vikram.singh@email.com', 'LG 55-inch OLED TV', 1, 149990.00, 149990.00, 'PENDING', '2024-04-01 08:30:00', NULL, '12, Civil Lines, Jaipur, Rajasthan 302006'),
('ORD-2024-006', 'Ananya Gupta', 'ananya.gupta@email.com', 'iPad Pro 12.9 inch', 1, 112900.00, 112900.00, 'CANCELLED', '2024-04-12 14:20:00', NULL, '88, Park Street, Kolkata, West Bengal 700016'),
('ORD-2024-007', 'Rajesh Menon', 'rajesh.menon@email.com', 'Dyson V15 Vacuum Cleaner', 1, 62900.00, 62900.00, 'DELIVERED', '2024-05-03 10:00:00', '2024-05-08 16:30:00', '5, MG Road, Kochi, Kerala 682011'),
('ORD-2024-008', 'Deepa Nair', 'deepa.nair@email.com', 'Canon EOS R6 Camera', 1, 215990.00, 215990.00, 'SHIPPED', '2024-05-18 12:30:00', NULL, '33, Anna Nagar, Chennai, Tamil Nadu 600040'),
('ORD-2024-009', 'Karthik Iyer', 'karthik.iyer@email.com', 'Herman Miller Aeron Chair', 2, 89900.00, 179800.00, 'PROCESSING', '2024-06-02 09:45:00', NULL, '15, Koramangala, Bangalore, Karnataka 560034'),
('ORD-2024-010', 'Meera Joshi', 'meera.joshi@email.com', 'Bose SoundLink Speaker', 3, 19900.00, 59700.00, 'CONFIRMED', '2024-06-15 15:10:00', NULL, '9, FC Road, Pune, Maharashtra 411004');
