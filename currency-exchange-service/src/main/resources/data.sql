-- Seed data for currency_exchange table
-- Columns: id, currency_from, currency_to, conversion_multiple, environment

INSERT INTO currency_exchange (id, currency_from, currency_to, conversion_multiple, environment) VALUES (10001, 'USD', 'INR', 65.00, 'local');
INSERT INTO currency_exchange (id, currency_from, currency_to, conversion_multiple, environment) VALUES (10002, 'EUR', 'INR', 75.50, 'local');
INSERT INTO currency_exchange (id, currency_from, currency_to, conversion_multiple, environment) VALUES (10003, 'GBP', 'INR', 85.75, 'local');
INSERT INTO currency_exchange (id, currency_from, currency_to, conversion_multiple, environment) VALUES (10004, 'USD', 'EUR', 0.85, 'local');
INSERT INTO currency_exchange (id, currency_from, currency_to, conversion_multiple, environment) VALUES (10005, 'USD', 'GBP', 0.75, 'local');
INSERT INTO currency_exchange (id, currency_from, currency_to, conversion_multiple, environment) VALUES (10006, 'INR', 'USD', 0.0154, 'local');

-- Add more rows as needed. The `environment` column can be updated at runtime by the service.

