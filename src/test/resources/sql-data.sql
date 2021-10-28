INSERT INTO `customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');

INSERT INTO `items` (`item_name`, `cost`) VALUES ('Fifa22', 59.99);

INSERT INTO `orders` (`fk_customer_id`) VALUES ('1');

INSERT INTO `order_items` (`fk_order_id`, `fk_item_id`) VALUES (1, 1);